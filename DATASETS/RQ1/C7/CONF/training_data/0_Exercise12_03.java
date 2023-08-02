
public class ArrayElement {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an index to retrieve the corresponding element: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= arr.length) {
            System.out.println("Out of Bounds");
        } else {
            System.out.println("Element at index " + index + " is " + arr[index]);
        }
    }
}
