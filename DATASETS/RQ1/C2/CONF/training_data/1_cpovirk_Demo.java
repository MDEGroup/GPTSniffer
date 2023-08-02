/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

$ tail -n +1 MakeFile.java ReadDir.java 
==> MakeFile.java <==
import java.io.File;
import java.util.Arrays;

class MakeFile {
  public static void main(String[] args) throws Exception {
    File baseDir = new File(System.getProperty("java.io.tmpdir"));
    @SuppressWarnings("GoodTime") // reading system time without TimeSource
    String baseName = System.currentTimeMillis() + "-";

    for (int counter = 0; counter < 10000; counter++) {
      File tempDir = new File(baseDir, baseName + counter);
      if (tempDir.mkdir()) {
        System.out.println("created " + tempDir);
        System.out.print("press enter to continue");
        System.console().readLine();

        // tempDir is not guaranteed to have the correct permissions at this point.
        // See https://github.com/google/guava/issues/4011.
        if (!tempDir.setReadable(false, /* ownerOnly= */ false)
            || !tempDir.setWritable(false, /* ownerOnly= */ false)
            || !tempDir.setExecutable(false, /* ownerOnly= */ false)
            // At this point, permissions on tempDir should be d---------.
            || !tempDir.setReadable(true, /* ownerOnly= */ true)
            || !tempDir.setWritable(true, /* ownerOnly= */ true)
            || !tempDir.setExecutable(true, /* ownerOnly= */ true)) {
          throw new IllegalStateException(
              "Failed to ensure that " + tempDir + " has the expected ownership and permissions");
        }
        // At this point, permissions on tempDir should be drwx------,
        // but we still need to make sure that nothing was added to tempDir
        // while we were fixing its permissions.
        String[] children = tempDir.list();
        if (children == null || children.length != 0) {
          throw new IllegalStateException(
              "Failed to verify that " + tempDir + " is empty: " + Arrays.toString(children));
        }
        new File(tempDir, "one").createNewFile();
        new File(tempDir, "two").createNewFile();
        new File(tempDir, "three").createNewFile();
        return;
      }
    }
    throw new RuntimeException("could not create");
  }
}

==> ReadDir.java <==
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class ReadDir {
  public static void main(String[] args) throws Exception {
    deleteDirectoryContents(Path.of(args[0]));
  }

  public static void deleteDirectoryContents(Path path) throws IOException {
    Collection<IOException> exceptions = null; // created lazily if needed
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
      if (stream instanceof SecureDirectoryStream) {
        SecureDirectoryStream<Path> sds = (SecureDirectoryStream<Path>) stream;
        exceptions = deleteDirectoryContentsSecure(sds);
      } else {
        throw new RuntimeException();
      }
    } catch (IOException e) {
      if (exceptions == null) {
        throw e;
      } else {
        exceptions.add(e);
      }
    }

    if (exceptions != null) {
      throwDeleteFailed(path, exceptions);
    }
  }

  /**
   * Secure recursive delete using {@code SecureDirectoryStream}. Returns a collection of exceptions
   * that occurred or null if no exceptions were thrown.
   */
  private static Collection<IOException> deleteRecursivelySecure(
      SecureDirectoryStream<Path> dir, Path path) {
    Collection<IOException> exceptions = null;
    try {
      if (isDirectory(dir, path, NOFOLLOW_LINKS)) {
        try (SecureDirectoryStream<Path> childDir = dir.newDirectoryStream(path, NOFOLLOW_LINKS)) {
          exceptions = deleteDirectoryContentsSecure(childDir);
        }

        // If exceptions is not null, something went wrong trying to delete the contents of the
        // directory, so we shouldn't try to delete the directory as it will probably fail.
        if (exceptions == null) {
          dir.deleteDirectory(path);
        }
      } else {
        dir.deleteFile(path);
      }

      return exceptions;
    } catch (IOException e) {
      return addException(exceptions, e);
    }
  }

  /**
   * Secure method for deleting the contents of a directory using {@code SecureDirectoryStream}.
   * Returns a collection of exceptions that occurred or null if no exceptions were thrown.
   */
  private static Collection<IOException> deleteDirectoryContentsSecure(
      SecureDirectoryStream<Path> dir) {
    Collection<IOException> exceptions = null;
    try {
      Iterator<Path> itr = dir.iterator();
      System.out.print("press enter to continue");
      System.console().readLine();
      while (itr.hasNext()) {
        Path path = itr.next();
        System.out.println(path);
      }

      return exceptions;
    } catch (DirectoryIteratorException e) {
      return addException(exceptions, e.getCause());
    }
  }

  /** Returns whether or not the file with the given name in the given dir is a directory. */
  private static boolean isDirectory(
      SecureDirectoryStream<Path> dir, Path name, LinkOption... options) throws IOException {
    return dir.getFileAttributeView(name, BasicFileAttributeView.class, options)
        .readAttributes()
        .isDirectory();
  }

  /**
   * Returns a path to the parent directory of the given path. If the path actually has a parent
   * path, this is simple. Otherwise, we need to do some trickier things. Returns null if the path
   * is a root or is the empty path.
   */
  private static Path getParentPath(Path path) {
    Path parent = path.getParent();

    // Paths that have a parent:
    if (parent != null) {
      // "/foo" ("/")
      // "foo/bar" ("foo")
      // "C:\foo" ("C:\")
      // "\foo" ("\" - current drive for process on Windows)
      // "C:foo" ("C:" - working dir of drive C on Windows)
      return parent;
    }

    // Paths that don't have a parent:
    if (path.getNameCount() == 0) {
      // "/", "C:\", "\" (no parent)
      // "" (undefined, though typically parent of working dir)
      // "C:" (parent of working dir of drive C on Windows)
      //
      // For working dir paths ("" and "C:"), return null because:
      //   A) it's not specified that "" is the path to the working directory.
      //   B) if we're getting this path for recursive delete, it's typically not possible to
      //      delete the working dir with a relative path anyway, so it's ok to fail.
      //   C) if we're getting it for opening a new SecureDirectoryStream, there's no need to get
      //      the parent path anyway since we can safely open a DirectoryStream to the path without
      //      worrying about a symlink.
      return null;
    } else {
      // "foo" (working dir)
      return path.getFileSystem().getPath(".");
    }
  }

  /**
   * Adds the given exception to the given collection, creating the collection if it's null. Returns
   * the collection.
   */
  private static Collection<IOException> addException(
      Collection<IOException> exceptions, IOException e) {
    if (exceptions == null) {
      exceptions = new ArrayList<>(); // don't need Set semantics
    }
    exceptions.add(e);
    return exceptions;
  }

  /**
   * Concatenates the contents of the two given collections of exceptions. If either collection is
   * null, the other collection is returned. Otherwise, the elements of {@code other} are added to
   * {@code exceptions} and {@code exceptions} is returned.
   */
  private static Collection<IOException> concat(
      Collection<IOException> exceptions, Collection<IOException> other) {
    if (exceptions == null) {
      return other;
    } else if (other != null) {
      exceptions.addAll(other);
    }
    return exceptions;
  }

  /**
   * Throws an exception indicating that one or more files couldn't be deleted when deleting {@code
   * path} or its contents.
   *
   * <p>If there is only one exception in the collection, and it is a {@link NoSuchFileException}
   * thrown because {@code path} itself didn't exist, then throws that exception. Otherwise, the
   * thrown exception contains all the exceptions in the given collection as suppressed exceptions.
   */
  private static void throwDeleteFailed(Path path, Collection<IOException> exceptions)
      throws FileSystemException {
    NoSuchFileException pathNotFound = pathNotFound(path, exceptions);
    if (pathNotFound != null) {
      throw pathNotFound;
    }
    // TODO(cgdecker): Should there be a custom exception type for this?
    // Also, should we try to include the Path of each file we may have failed to delete rather
    // than just the exceptions that occurred?
    FileSystemException deleteFailed =
        new FileSystemException(
            path.toString(),
            null,
            "failed to delete one or more files; see suppressed exceptions for details");
    for (IOException e : exceptions) {
      deleteFailed.addSuppressed(e);
    }
    throw deleteFailed;
  }

  private static NoSuchFileException pathNotFound(Path path, Collection<IOException> exceptions) {
    if (exceptions.size() != 1) {
      return null;
    }
    IOException exception = exceptions.iterator().next();
    if (!(exception instanceof NoSuchFileException)) {
      return null;
    }
    NoSuchFileException noSuchFileException = (NoSuchFileException) exception;
    String exceptionFile = noSuchFileException.getFile();
    if (exceptionFile == null) {
      /*
       * It's not clear whether this happens in practice, especially with the filesystem
       * implementations that are built into java.nio.
       */
      return null;
    }
    Path parentPath = getParentPath(path);
    if (parentPath == null) {
      /*
       * This is probably impossible:
       *
       * - In deleteRecursively, we require the path argument to have a parent.
       *
       * - In deleteDirectoryContents, the path argument may have no parent. Fortunately, all the
       *   *other* paths we process will be descendants of that. That leaves only the original path
       *   argument for us to consider. And the only place we call pathNotFound is from
       *   throwDeleteFailed, and the other place that we call throwDeleteFailed inside
       *   deleteDirectoryContents is when an exception is thrown during the recursive steps. Any
       *   failure during the initial lookup of the path argument itself is rethrown directly. So
       *   any exception that we're seeing here is from a descendant, which naturally has a parent.
       *   I think.
       *
       * Still, if this can happen somehow (a weird filesystem implementation that lets callers
       * change its working directly concurrently with a call to deleteDirectoryContents?), it makes
       * more sense for us to fall back to a generic FileSystemException (by returning null here)
       * than to dereference parentPath and end up producing NullPointerException.
       */
      return null;
    }
    // requireNonNull is safe because paths have file names when they have parents.
    Path pathResolvedFromParent = parentPath.resolve(requireNonNull(path.getFileName()));
    if (exceptionFile.equals(pathResolvedFromParent.toString())) {
      return noSuchFileException;
    }
    return null;
  }
}


# In terminal #1:

$ javac MakeFile.java && sudo java MakeFile
created /tmp/1658849498447-0
press enter to continue

# In terminal #2:

$ javac ReadDir.java && java ReadDir /tmp/1658849498447-0
press enter to continue

Then press enter in terminal #1, which closes permissions.

Then press enter in terminal #2. It then successfully reads the directory that it would no longer have permissions to open:

/tmp/1658849498447-0/one
/tmp/1658849498447-0/three
/tmp/1658849498447-0/two

$ ls -l /tmp/1658849498447-0
ls: cannot open directory '/tmp/1658849498447-0': Permission denied
