



public class nan {
    private static int moves;

    public static void main(String[] args) {
        moves = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
        System.out.println("Total number of moves is: " + moves);
    }


    public static void moveDisks(int n, char fromTower,
                                 char toTower, char auxTower) {
        moves++;
        if (n == 1) 
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
