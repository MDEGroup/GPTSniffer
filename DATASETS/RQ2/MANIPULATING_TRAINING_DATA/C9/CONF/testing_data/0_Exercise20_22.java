import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int numberOfDisks = 3; // Change this to the number of disks you want to solve
        solveTowerOfHanoi(numberOfDisks, 'A', 'B', 'C');
    }

    public static void solveTowerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        Stack<Move> moveStack = new Stack<>();
        moveStack.push(new Move(numDisks, source, auxiliary, destination));

        while (!moveStack.isEmpty()) {
            Move currentMove = moveStack.pop();

            if (currentMove.numDisks == 1) {
                System.out.println("Move disk 1 from " + currentMove.source + " to " + currentMove.destination);
            } else {
                // Push sub-problems onto the stack to be solved iteratively
                moveStack.push(new Move(currentMove.numDisks - 1, currentMove.auxiliary, currentMove.source, currentMove.destination));
                moveStack.push(new Move(1, currentMove.source, currentMove.auxiliary, currentMove.destination));
                moveStack.push(new Move(currentMove.numDisks - 1, currentMove.source, currentMove.destination, currentMove.auxiliary));
            }
        }
    }

    static class Move {
        int numDisks;
        char source;
        char auxiliary;
        char destination;

        Move(int numDisks, char source, char auxiliary, char destination) {
            this.numDisks = numDisks;
            this.source = source;
            this.auxiliary = auxiliary;
            this.destination = destination;
        }
    }
}