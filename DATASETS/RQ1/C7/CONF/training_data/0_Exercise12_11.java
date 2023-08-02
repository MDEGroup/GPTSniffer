
public class RemoveText {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java RemoveText <string> <filename>");
            System.exit(1);
        }
        String stringToRemove = args[0];
        String filename = args[1];
        File inputFile = new File(filename);
        File outputFile = new File(inputFile.getParentFile(), "temp.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        FileWriter writer = new FileWriter(outputFile);
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll(stringToRemove, "");
            writer.write(line + System.lineSeparator());
        }
        reader.close();
        writer.close();
        inputFile.delete();
        outputFile.renameTo(inputFile);
    }
}
