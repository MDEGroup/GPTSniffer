import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToeBoardApp extends Application {

    private static final int BOARD_SIZE = 3; // Size of the Tic-Tac-Toe board (3x3)

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic-Tac-Toe Board");

        // Create a GridPane to represent the Tic-Tac-Toe board
        GridPane ticTacToeBoard = createTicTacToeBoard();

        // Create a Scene with the Tic-Tac-Toe board
        Scene scene = new Scene(ticTacToeBoard, 300, 300);

        // Set the Scene on the Stage
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }

    private GridPane createTicTacToeBoard() {
        GridPane gridPane = new GridPane();

        // Create a random number generator
        Random random = new Random();

        // Loop through the board cells and add X, O, or leave empty randomly
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                ImageView cellImageView = new ImageView();

                // Generate a random number to decide whether to place X, O, or leave empty
                int randomNumber = random.nextInt(3);

                // Load the appropriate image based on the random number
                if (randomNumber == 0) {
                    cellImageView.setImage(new Image("x.gif"));
                } else if (randomNumber == 1) {
                    cellImageView.setImage(new Image("o.gif"));
                }

                // Add the ImageView representing the cell to the GridPane
                gridPane.add(cellImageView, col, row);
            }
        }

        return gridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}