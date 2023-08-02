
public class Main {
    public static void main(String[] args) {
        try {
            
            File file = new File("example.txt");
        
            
            byte[] fileContent = Files.readAllBytes(file.toPath());
        
            
            for (byte b : fileContent) {
                System.out.print(b + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

