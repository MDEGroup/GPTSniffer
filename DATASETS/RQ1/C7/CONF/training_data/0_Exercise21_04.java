
public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text file name: ");
        String fileName = input.nextLine();

        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int numVowels = 0;
        int numConsonants = 0;

        try {
            File file = new File(fileName);
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNext()) {
                String line = fileInput.nextLine().toUpperCase();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (Character.isLetter(ch)) {
                        if (vowels.contains(ch)) {
                            numVowels++;
                        } else {
                            numConsonants++;
                        }
                    }
                }
            }
            fileInput.close();
            System.out.println("Number of vowels: " + numVowels);
            System.out.println("Number of consonants: " + numConsonants);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
