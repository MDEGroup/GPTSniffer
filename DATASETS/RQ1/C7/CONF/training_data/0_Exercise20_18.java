
public class DirectorySize {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DirectorySize directory");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.isDirectory()) {
            System.out.println(file.getName() + " is not a directory");
            System.exit(2);
        }

        System.out.println("The size of " + file.getAbsolutePath() + " is " + getSize(file) + " bytes.");
    }

    public static long getSize(File directory) {
        long size = 0;
        Queue<File> queue = new LinkedList<>();
        queue.offer(directory);

        while (!queue.isEmpty()) {
            File t = queue.poll();

            if (t.isFile()) {
                size += t.length();
            } else {
                File[] files = t.listFiles();
                if (files != null) {
                    for (File file : files) {
                        queue.offer(file);
                    }
                }
            }
        }

        return size;
    }
}
