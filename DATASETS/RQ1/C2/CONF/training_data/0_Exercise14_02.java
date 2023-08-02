import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToeBoard extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the GridPane and set the padding and gap between cells
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create an array to hold the X and O images
        Image[] images = new Image[3];
        images[0] = new Image("https://i.imgur.com/WHdYnoM.png");
        images[1] = new Image("https://i.imgur.com/sNDtBvL.png");
        images[2] = null;

        // Create a Random object to generate random numbers
        Random random = new Random();

        // Fill the grid with X's, O's, and empty cells randomly
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int index = random.nextInt(3);
                ImageView imageView = new ImageView(images[index]);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                gridPane.add(imageView, col, row);
            }
        }

        // Create a Scene and add the GridPane to it
        Scene scene = new Scene(gridPane, 350, 350);

        // Set the alignment of the GridPane and show the window
        gridPane.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic-Tac-Toe Board");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}