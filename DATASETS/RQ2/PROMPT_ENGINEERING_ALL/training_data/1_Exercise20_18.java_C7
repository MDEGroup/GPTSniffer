



public class IterativeDirectorSize {
    private static final String TEST_DIRECTORY = "ch_09";

    public static void main(String[] args) {
        String rawSize = String.valueOf(new Exercise20_18().getSize(new File(TEST_DIRECTORY)));
        StringBuilder sizeInBytes = new StringBuilder();
        for (int i = rawSize.length() - 1; i >= 0; i--) {
            sizeInBytes.append(rawSize.charAt(i));
            if (i % 3 == 0) {
                sizeInBytes.append(",");
            }
        }
        System.out.println("Size of test directory: " + TEST_DIRECTORY + " is " + sizeInBytes + " bytes");
    }

    private long getSize(File directory) {
        long size = 0;
        java.util.Queue<File> queue = new java.util.LinkedList<>();
        queue.offer(directory);
        while (queue.size() > 0) {
            File t = queue.remove();
            if (t.isFile()) {
                size += t.length();
            } else {
                File[] subFiles = t.listFiles();
                if (subFiles == null || subFiles.length == 0) {
                    continue;
                }

                for (File f : subFiles) {
                    queue.offer(f);
                }
            }
        }
        return size;
    }
}
