



public class Hex2Bin{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a hex digit: ");
        String s = in.next();
        String test = "0123456789ABCDEF";
        if (test.contains(s)) {
            s = s.replaceAll("0", "0000");
            s = s.replaceAll("1", "0001");
            s = s.replaceAll("2", "0010");
            s = s.replaceAll("3", "0011");
            s = s.replaceAll("4", "0100");
            s = s.replaceAll("5", "0101");
            s = s.replaceAll("6", "0110");
            s = s.replaceAll("7", "0111");
            s = s.replaceAll("8", "1000");
            s = s.replaceAll("9", "1001");
            s = s.replaceAll("A", "1010");
            s = s.replaceAll("B", "1011");
            s = s.replaceAll("C", "1100");
            s = s.replaceAll("D", "1101");
            s = s.replaceAll("E", "1110");
            s = s.replaceAll("F", "1111");
            System.out.println("The binary value is " + s);

        } else {
            System.out.println("Invalid Input.");
        }

    }
}
