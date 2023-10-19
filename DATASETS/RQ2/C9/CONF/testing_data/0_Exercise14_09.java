import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FanGridApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fan Grid Example");

        // Create a GridPane with 2 rows and 2 columns
        GridPane gridPane = createGridPane();

        // Create four fans as ImageView objects
        ImageView fan1 = createFanImageView();
        ImageView fan2 = createFanImageView();
        ImageView fan3 = createFanImageView();
        ImageView fan4 = createFanImageView();

        // Add fans to the GridPane
        gridPane.add(fan1, 0, 0);
        gridPane.add(fan2, 1, 0);
        gridPane.add(fan3, 0, 1);
        gridPane.add(fan4, 1, 1);

        // Create a Scene with the GridPane
        Scene scene = new Scene(gridPane, 400, 400);

        // Set the Scene on the Stage
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Horizontal gap between cells
        gridPane.setVgap(10); // Vertical gap between cells
        return gridPane;
    }

    private ImageView createFanImageView() {
        // Load an image of a fan (you can use your own image)
        Image fanImage = new Image("fan.png");

        // Create an ImageView to display the fan image
        ImageView fanImageView = new ImageView(fanImage);

        // Optionally, you can set the width and height of the ImageView
        fanImageView.setFitWidth(150);
        fanImageView.setFitHeight(150);

        return fanImageView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
