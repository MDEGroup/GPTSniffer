import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FourFans extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Create fan images
        Image fanImage1 = new Image("file:fan.png");
        Image fanImage2 = new Image("file:fan.png");
        Image fanImage3 = new Image("file:fan.png");
        Image fanImage4 = new Image("file:fan.png");

        // Create fan ImageViews
        ImageView fan1 = new ImageView(fanImage1);
        ImageView fan2 = new ImageView(fanImage2);
        ImageView fan3 = new ImageView(fanImage3);
        ImageView fan4 = new ImageView(fanImage4);

        // Set fan sizes
        fan1.setFitWidth(100);
        fan1.setFitHeight(100);
        fan2.setFitWidth(100);
        fan2.setFitHeight(100);
        fan3.setFitWidth(100);
        fan3.setFitHeight(100);
        fan4.setFitWidth(100);
        fan4.setFitHeight(100);

        // Add fans to GridPane
        gridPane.add(fan1, 0, 0);
        gridPane.add(fan2, 1, 0);
        gridPane.add(fan3, 0, 1);
        gridPane.add(fan4, 1, 1);

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Four Fans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}