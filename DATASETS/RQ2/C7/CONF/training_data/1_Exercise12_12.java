




public class FileConverter {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        if (args.length < 1) {
            System.out.println("Usage: java FileConverter sourceFile");
            return;
        }
        File file = new File(args[0]);

        if (file.exists()) {

            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines.add(line);

                }

                for (int i = 1; i < lines.size(); i++) {
                    if (lines.get(i).contains("{")) {
                        String orgLine = lines.get(i);
                        orgLine = orgLine.replace('{', ' '); 
                        String targetLine = lines.get(i - 1); 
                        targetLine = targetLine + " {"; 
                        lines.set(i, orgLine);
                        lines.set(i - 1, targetLine);
                    }
                }
                PrintWriter writer = new PrintWriter(file);

                for (String line : lines) {
                    writer.println(line);
                }
                writer.close();


            } catch (FileNotFoundException e) {
                System.out.println("File could not be found to exist: " + e);

            }
        }
    }
}
