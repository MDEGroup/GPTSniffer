



public class NumberWriter{
    static ArrayList<Integer> lines = new ArrayList<>();

    public static void main(String[] args) {
        boolean success = true;
        File file = new File("src" + File.separator + "ch_12" + File.separator + "exercise12_15" + File.separator +
                "Exercise12_15.txt");
        if (!file.exists()) {
            try {
                success = file.createNewFile();
            } catch (IOException ioe) {
                success = false;
                ioe.printStackTrace();
            }
        }
        if (success) {
            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (int i = 0; i < 100; i++) {
                    int random = (int) (1 + Math.random() * 9999);
                    printWriter.write(String.valueOf(random));
                    printWriter.write(" ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try (Scanner fileIn = new Scanner(file)) {
                while (fileIn.hasNextLine()) {
                    String[] line = fileIn.nextLine().split(" ");
                    for (String num : line) {
                        lines.add(Integer.parseInt(num));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            lines.sort((i1, i2) -> i1 - i2);
            System.out.println(Arrays.toString(lines.toArray()));
            System.out.println("Integer count= " + lines.size());

        }
    }
}
