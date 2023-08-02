



public class BabyNameRanking{
    private static final String FILENAME_PREFIX = "babynameranking";
    private static final String workingDir = "ch_12/exercise12_31";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = in.nextInt();

        System.out.print("\nEnter the gender: ");
        String gender = in.next().trim();

        System.out.print("\nEnter the name: ");
        String name = in.next();

        int rank = getRank(year, gender.charAt(0), name);
        if (rank == -7) {
            System.out.println("That name is not on the list for that year....");
        }
        System.out.print("\n" + name + " is ranked #" + rank + " in year " + year);

        in.close();

    }

    private static int getRank(int year, char gender, String name) {
        if (year < 2001 || year > 2010) return -1;
        if (gender != 'M' && gender != 'F') return -2;

        int ranking = -7; 
        String fileName = FILENAME_PREFIX + year + ".txt";
        File file = new File(workingDir, fileName);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] line = fileScanner.nextLine().split("\\s+"); 
                if (gender == 'M') {
                    if (line[1].equalsIgnoreCase(name)) {
                        ranking = Integer.parseInt(line[0].trim());
                        break;
                    }
                } else {
                    if (line[3].equalsIgnoreCase(name)) {
                        ranking = Integer.parseInt(line[0].trim());
                        break;
                    }
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return ranking;
    }
}
