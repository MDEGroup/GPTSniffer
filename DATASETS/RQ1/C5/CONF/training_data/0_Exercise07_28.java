import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("Enter 10 integers: ");
        
        
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = input.nextInt();
        }
        
        
        System.out.println("All combinations of picking two numbers:");
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                System.out.println(nums[i] + " " + nums[j]);
            }
        }
    }
}