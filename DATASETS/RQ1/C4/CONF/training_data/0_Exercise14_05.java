public class CircleString {
    public static void main(String[] args) {
        String message = "Welcome to Java";
        int radius = 10; 
        int centerX = 20; 
        int centerY = 10; 
        
        
        for (int i = 0; i < message.length(); i++) {
            double angle = i * 2 * Math.PI / message.length();
            int x = (int)(centerX + radius * Math.cos(angle));
            int y = (int)(centerY + radius * Math.sin(angle));
            System.out.print(" ");
            System.out.print("\033[" + y + ";" + x + "H"); 
            System.out.print(message.charAt(i)); 
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}