
public class HexReader{
    public static void main(String[] args) {
        
        String fileName = System.console().readLine("Enter file name: ");

        try (FileInputStream input = new FileInputStream(fileName)) {
            
            int value;
            while ((value = input.read()) != -1) {
                String hex = Integer.toHexString(value & 0xFF);
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                System.out.print(hex.toUpperCase() + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
