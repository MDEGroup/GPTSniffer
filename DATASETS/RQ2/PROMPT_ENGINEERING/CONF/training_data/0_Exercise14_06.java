import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Checkerboard extends Application {
    @Override
    public void start(Stage primaryStage) {
        // create a GridPane to hold the rectangles
        GridPane gridPane = new GridPane();

        // set the size of each rectangle
        int rectSize = 50;

        // create the rectangles and add them to the GridPane
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(rectSize, rectSize);
                rect.setFill((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
                gridPane.add(rect, j, i);
            }
        }

        // create a scene and add the GridPane to it
        Scene scene = new Scene(gridPane, rectSize * 8, rectSize * 8);

        // set the title of the stage and show it
        primaryStage.setTitle("Checkerboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
