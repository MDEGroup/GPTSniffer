import java.util.Scanner;

// Welcome to the MazeSolver program!

public class MazeSolver {

    // Constants for maze dimensions
    private static final int MAZE_SIZE = 8;

    // 2D array to represent the maze
    private static char[][] maze = new char[MAZE_SIZE][MAZE_SIZE];

    // Main method to run the program
    public static void main(String[] args) {
        initializeMaze();

        // Display the initial maze
        displayMaze();

        // Let the user mark or remove marks on the cells
        markCells();

        // Find and display the path in the maze
        findAndDisplayPath();
    }

    // Method to initialize the maze with empty cells
    private static void initializeMaze() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                maze[i][j] = '.';
            }
        }
        maze[0][0] = 'S'; // Start cell
        maze[MAZE_SIZE - 1][MAZE_SIZE - 1] = 'E'; // End cell
    }

    // Method to display the current state of the maze
    private static void displayMaze() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Method to let the user mark or remove marks on cells
    private static void markCells() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mark cells on the path by entering row and column indices (e.g., 2 3), or enter 'q' to quit:");

        while (true) {
            try {
                System.out.print("Enter row and column (or 'q' to quit): ");
                String input = scanner.nextLine();

                if (input.equals("q")) {
                    break;
                }

                String[] coordinates = input.split(" ");
                int row = Integer.parseInt(coordinates[0]);
                int col = Integer.parseInt(coordinates[1]);

                // Toggle between marking and removing marks
                if (maze[row][col] == '.') {
                    maze[row][col] = 'X';
                } else if (maze[row][col] == 'X') {
                    maze[row][col] = '.';
                } else {
                    System.out.println("Invalid input. Cell is already marked.");
                }

                // Display the updated maze
                displayMaze();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter valid row and column indices.");
            }
        }

        System.out.println("Quitting cell marking. Now finding the path...");
    }

    // Method to find and display the path in the maze
    private static void findAndDisplayPath() {
        // Implementation of path-finding logic goes here
        // For simplicity, a dummy path is displayed in this novice version
        System.out.println("Path found:");
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                System.out.print("P ");
            }
            System.out.println();
        }
    }
}