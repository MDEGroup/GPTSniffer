import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KnightsTourAnimation extends Application {
    private static final int SIZE = 8;  // Size of the chessboard

    @Override
    public void start(Stage primaryStage) {
        // Welcome message
        System.out.println("Welcome to Knight's Tour Animation!");

        // Create a chessboard grid
        GridPane chessboard = new GridPane();
        initializeChessboard(chessboard);

        // Create the Solve button
        Button solveButton = new Button("Solve");

        // Set up the scene
        Scene scene = new Scene(chessboard, 400, 400);
        primaryStage.setTitle("Knight's Tour Animation");
        primaryStage.setScene(scene);
        primaryStage.show();

        // TODO: Implement knight's tour animation logic on button click
        solveButton.setOnAction(event -> {
            // Add your animation logic here
            System.out.println("Solving Knight's Tour...");
        });
    }

    // Initialize the chessboard with buttons
    private void initializeChessboard(GridPane chessboard) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button square = new Button();  // Each button represents a square on the chessboard
                square.setMinSize(50, 50);  // Adjust button size
                chessboard.add(square, j, i);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}