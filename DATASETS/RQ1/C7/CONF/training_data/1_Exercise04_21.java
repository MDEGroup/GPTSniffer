



public class CheckSSN{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Social Security number in the format DDD-DD-DDDD, where D is a digit: ");
        String userInput = in.nextLine().trim();

        String socSec = "(\\d\\d\\d)-(\\d\\d)-(\\d\\d\\d\\d)";
        Pattern ssNum = Pattern.compile(socSec);
        Matcher matcher = ssNum.matcher(userInput);
        if (matcher.matches()) {
            System.out.println(userInput + " is a valid social security number.");
        } else {
            System.out.println(userInput + " is not a valid social security number.");
        }


    }
}
