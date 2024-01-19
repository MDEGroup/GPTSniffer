import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckerboardDisplay extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int rows = 8;
        int cols = 8;
        double cellSize = 40; // Size of each cell

        GridPane grid = new GridPane();

        // Create the checkerboard pattern
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Rectangle cell = new Rectangle(cellSize, cellSize);

                // Set fill color based on row and column
                if ((row + col) % 2 == 0) {
                    cell.setFill(Color.WHITE);
                } else {
                    cell.setFill(Color.BLACK);
                }

                // Add cell to the grid
                grid.add(cell, col, row);
            }
        }

        // Create a scene and set it in the stage
        Scene scene = new Scene(grid, cellSize * cols, cellSize * rows);

        // Set the stage title
        primaryStage.setTitle("Checkerboard Display");

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}