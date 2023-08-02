public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; 
        char fromPeg = 'A';
        char toPeg = 'C';
        char auxPeg = 'B';

        System.out.println("Steps to move " + n + " disks from peg " + fromPeg + " to peg " + toPeg + ":");
        moveDisks(n, fromPeg, toPeg, auxPeg);
    }

    private static void moveDisks(int n, char fromPeg, char toPeg, char auxPeg) {
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }

        moveDisks(n - 1, fromPeg, auxPeg, toPeg);
        System.out.println("Move disk " + n + " from peg " + fromPeg + " to peg " + toPeg);
        moveDisks(n - 1, auxPeg, toPeg, fromPeg);
    }
}

