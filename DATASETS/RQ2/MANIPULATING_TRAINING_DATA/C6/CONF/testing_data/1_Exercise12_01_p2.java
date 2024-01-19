


public class 1_Exercise12_01_p2.java{
    public static void main(String[] args) {

        String t1 = args[0]; 
        String t2 = args[2]; 

        checkInput(t1);
        checkInput(t2);

        int result = 0;

        switch (args[1].charAt(0)) {
            case '+':
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                break;
            case '-':
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                break;
            case '.':
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                break;
            case '/':
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
        }

        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
    }

    public static void checkInput(String str) {
        int i = str.length() - 1;
        while (i >= 0) {

            if (!Character.isDigit(str.charAt(i))) {

                System.out.println("Invalid Input: " + str);
                System.exit(0);
            }
            i--;
        }
    }
}
