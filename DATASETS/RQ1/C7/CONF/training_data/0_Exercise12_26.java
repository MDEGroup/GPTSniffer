
public class CreateDirectory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a directory name: ");
        String dirname = input.nextLine();
        File dir = new File(dirname);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Directory already exists");
        } else if (dir.mkdirs()) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Failed to create directory");
        }
    }
}
