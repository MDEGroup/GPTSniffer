



public class LongestCommonPrefix {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter string one: ");
        String str1 = input.nextLine();

        final int lengthOne = str1.length();
        System.out.println("Enter string two: ");

        String str2 = input.nextLine();
        final int lengthTwo = str2.length();

        if (str1.charAt(0) != str2.charAt(0)) {

            System.out.println(str1 + " and " + str2 + " have :(. ---> no common prefix <---");

        } else {
            int indexOfLCP = 0;
            for (int i = 0; i < (Math.max(lengthOne, lengthTwo)); i++) {

                if (str1.charAt(i) == str2.charAt(i)) {
                    indexOfLCP = i;
                } else {
                    break;
                }
            }
            System.out.print("The common prefix is: " + str1.substring(0, indexOfLCP + 1));

        }

        input.close();
    }

}
