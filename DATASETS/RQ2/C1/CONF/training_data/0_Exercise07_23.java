public class LockerPuzzle {
    public static void main(String[] args) {
        boolean[] lockers = new boolean[100];

        // Open all lockers initially
        for (int i = 0; i < lockers.length; i++) {
            lockers[i] = true;
        }

        // Perform the student operations
        for (int student = 2; student <= 100; student++) {
            for (int locker = student - 1; locker < lockers.length; locker += student) {
                lockers[locker] = !lockers[locker];
            }
        }

        // Print the open lockers
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}