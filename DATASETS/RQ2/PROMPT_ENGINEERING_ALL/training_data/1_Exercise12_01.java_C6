


public class main{
    public static void main(String[] args) {

        if (new Exercise12_01().checkInput(args)) { 
            int result = 0;

            switch (args[1].charAt(0)) {
                case '+':
                    result = Integer.parseInt(args[0]) +
                            Integer.parseInt(args[2]);
                    break;
                case '-':
                    result = Integer.parseInt(args[0]) -
                            Integer.parseInt(args[2]);
                    break;
                case '.':
                    result = Integer.parseInt(args[0]) *
                            Integer.parseInt(args[2]);
                    break;
                case '/':
                    result = Integer.parseInt(args[0]) /
                            Integer.parseInt(args[2]);
            }


            System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                    + " = " + result);
        }
    }

    
    boolean checkInput(String[] args) {
        try {
            Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {

            System.out.println("Invalid Input: " + args[0]);
            System.exit(1);

        }
        try {
            Integer.parseInt(args[2]);
        } catch (NumberFormatException ex) {

            System.out.println("Invalid Input: " + args[2]);
            System.exit(2);
        }
        return true;
    }

}