public class CircleString {
    public static void main(String[] args) {
        String message = "Welcome to Java";
        int radius = 10; // change this value to adjust the size of the circle
        int centerX = 20; // change this value to adjust the position of the circle
        int centerY = 10; // change this value to adjust the position of the circle
        
        // loop through each character in the message and display it in the right location
        for (int i = 0; i < message.length(); i++) {
            double angle = i * 2 * Math.PI / message.length();
            int x = (int)(centerX + radius * Math.cos(angle));
            int y = (int)(centerY + radius * Math.sin(angle));
            System.out.print(" ");
            System.out.print("\033[" + y + ";" + x + "H"); // set the cursor position to (x, y)
            System.out.print(message.charAt(i)); // display the character at the current position
            try {
                Thread.sleep(100); // wait for 100 milliseconds before displaying the next character
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}