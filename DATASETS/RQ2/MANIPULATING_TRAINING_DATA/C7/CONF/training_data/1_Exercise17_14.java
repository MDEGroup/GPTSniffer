



public class FileEncoder {
    public static void main(String[] args) {
        String CURRENT_DIR = "ch_17" + File.separator + "exercise17_14";

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the input file name to be encrypted: ");
        String inFileStr = in.next();

        File inputFile = new File(CURRENT_DIR, inFileStr);

        System.out.print("Please enter a name for the output file: ");
        String outFileStr = in.next();

        File outputFile = new File(CURRENT_DIR, outFileStr);
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            try {
                byte[] inBytes = Files.readAllBytes(inputFile.toPath());
                for (byte b : inBytes) {
                    bufferedOutputStream.write(b + 5);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        in.close();
    }
}
