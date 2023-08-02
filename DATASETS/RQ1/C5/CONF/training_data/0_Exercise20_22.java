import java.util.Stack;

public class TowerOfHanoi {
    public static void moveDisks(int numDisks, char fromTower, char toTower, char auxTower) {
        Stack<Integer> fromStack = new Stack<Integer>();
        Stack<Integer> toStack = new Stack<Integer>();
        Stack<Integer> auxStack = new Stack<Integer>();
        for (int i = numDisks; i > 0; i--) {
            fromStack.push(i);
        }
        int totalMoves = (int) Math.pow(2, numDisks) - 1;
        if (numDisks % 2 == 0) {
            char temp = toTower;
            toTower = auxTower;
            auxTower = temp;
        }
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDisk(fromStack, toStack, fromTower, toTower);
            } else if (i % 3 == 2) {
                moveDisk(fromStack, auxStack, fromTower, auxTower);
            } else {
                moveDisk(auxStack, toStack, auxTower, toTower);
            }
        }
    }

    public static void moveDisk(Stack<Integer> fromStack, Stack<Integer> toStack, char fromTower, char toTower) {
        if (!fromStack.isEmpty() && (toStack.isEmpty() || fromStack.peek() < toStack.peek())) {
            int disk = fromStack.pop();
            toStack.push(disk);
            System.out.println("Move disk " + disk + " from " + fromTower + " to " + toTower);
        }
    }

    public static void main(String[] args) {
        moveDisks(3, 'A', 'C', 'B');
    }
}
