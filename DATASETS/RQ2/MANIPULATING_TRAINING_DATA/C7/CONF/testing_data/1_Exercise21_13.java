



public class nan {
    static ArrayList<HashMap<String, String>> boysNames = new ArrayList<>();
    static ArrayList<HashMap<String, String>> girlsNames = new ArrayList<>();

    static final String BABY_NAMES_BASE_URL = "https:
    static String[] babyNamesHttpPaths;
    static final int BOY = 1;
    static final int GIRL = 3;
    String selectedYear;
    String selectedGender;
    String selectedName;

    static {
        babyNamesHttpPaths = new String[10];
        
        for (int i = 0, year = 2001; i < 10; year++, i++) {
            babyNamesHttpPaths[i] = BABY_NAMES_BASE_URL + year + ".txt";
        }
    }

    public static void main(String[] args) {
        nan context = new Exercise21_13();
        Scanner in = new Scanner(System.in);
        try {
            context.populateRankings(boysNames, BOY);
            context.populateRankings(girlsNames, GIRL);
            for (; ; ) {
                System.out.print("\nEnter the year: ");
                context.selectedYear = in.next().trim();

                System.out.print("\nEnter the gender (M or F):");
                context.selectedGender = in.next().trim();

                System.out.print("\nEnter a name: ");
                context.selectedName = in.next().trim();
                String result = context.getSelectedRank(boysNames, girlsNames);
                if (result.startsWith("Invalid")) {
                    System.out.println(result);
                } else {
                    System.out.println((context.selectedGender.equalsIgnoreCase("M") ? "Boy" : "Girl") + " name "
                            + context.selectedName + " is ranked #" + result + " in year " + context.selectedYear);

                }
                System.out.print("\nEnter another inquiry?(Y or N) ");
                String loop = in.next().trim();
                if (loop.equalsIgnoreCase("Y")) {
                    continue;
                }
                System.out.println("GoodBye");
                break;
            }

        } catch (IOException e) {
            System.out.println("Exception occurred while reading data files..");
            System.out.println("Exiting the program....");
            System.exit(1);

        }

    }

    private void populateRankings(ArrayList<HashMap<String, String>> names,
                                  int gender) throws IOException {
        for (int i = 0; i < babyNamesHttpPaths.length; i++) {
            URL dataUrl = new URL(babyNamesHttpPaths[i]);
            Scanner urlScanner = new Scanner(dataUrl.openStream());
            HashMap<String, String> map = new HashMap<>();

            while (urlScanner.hasNextLine()) {
                String[] line = urlScanner.nextLine().split("\\s+"); 
                String ranking = line[0].trim();
                map.put(line[gender].trim(), ranking);
            }
            names.add(map);
            urlScanner.close();
        }
    }

    private String getSelectedRank(ArrayList<HashMap<String, String>> boysNames,
                                   ArrayList<HashMap<String, String>> girlsNames) {
        if (selectedName == null || selectedName.isEmpty() ||
                selectedGender == null || selectedGender.isEmpty() ||
                selectedYear == null || selectedYear.isEmpty()) {
            return "Invalid: Name, Gender, and Year must not be null or empty.";
        }
        int mapIndex = Integer.parseInt(selectedYear.substring(2)) - 1; 
        String rank = "";
        if (selectedGender.equalsIgnoreCase("M")) {
            HashMap<String, String> rankings = boysNames.get(mapIndex);
            rank = rankings.get(selectedName);
        } else if (selectedGender.equalsIgnoreCase("F")) {
            HashMap<String, String> rankings = girlsNames.get(mapIndex);
            rank = rankings.get(selectedName);
        }

        return rank;
    }

}
