
public class TestMyStack {
    
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter five strings:");
        for (int i = 0; i < 5; i++) {
            String s = scanner.nextLine();
            stack.push(s);
        }
        System.out.println("Stack contents:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    
}
