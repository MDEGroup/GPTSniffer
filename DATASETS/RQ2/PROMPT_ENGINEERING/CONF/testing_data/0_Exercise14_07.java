import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class RandomMatrixDisplay extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int rows = 10;
        int cols = 10;

        GridPane grid = new GridPane();

        Random random = new Random();

        // Create a 10x10 matrix of random 0s and 1s
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int randomNumber = random.nextInt(2); // Generate random 0 or 1
                String value = String.valueOf(randomNumber);

                // Create a TextField to display the number
                TextField textField = new TextField(value);

                // Style the TextField
                textField.setPrefWidth(30);
                textField.setPrefHeight(30);
                textField.setEditable(false);
                textField.setStyle("-fx-alignment: center;");

                // Add the TextField to the grid
                grid.add(textField, col, row);
            }
        }

        // Create a scene and set it in the stage
        Scene scene = new Scene(grid, 300, 300);

        // Set the stage title
        primaryStage.setTitle("Random Matrix Display");

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}