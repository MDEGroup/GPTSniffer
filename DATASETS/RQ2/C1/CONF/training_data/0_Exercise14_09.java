import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FansGrid extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the GridPane and set the padding and gap between cells
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        // Create four ImageView objects to hold the fan images
        ImageView fan1 = new ImageView(new Image("https://image.flaticon.com/icons/png/512/2948/2948073.png"));
        ImageView fan2 = new ImageView(new Image("https://image.flaticon.com/icons/png/512/2948/2948073.png"));
        ImageView fan3 = new ImageView(new Image("https://image.flaticon.com/icons/png/512/2948/2948073.png"));
        ImageView fan4 = new ImageView(new Image("https://image.flaticon.com/icons/png/512/2948/2948073.png"));

        // Set the size of the fan images
        fan1.setFitWidth(150);
        fan1.setFitHeight(150);
        fan2.setFitWidth(150);
        fan2.setFitHeight(150);
        fan3.setFitWidth(150);
        fan3.setFitHeight(150);
        fan4.setFitWidth(150);
        fan4.setFitHeight(150);

        // Add the fans to the GridPane
        gridPane.add(fan1, 0, 0);
        gridPane.add(fan2, 1, 0);
        gridPane.add(fan3, 0, 1);
        gridPane.add(fan4, 1, 1);

        // Create a Scene and add the GridPane to it
        Scene scene = new Scene(gridPane, 500, 500);

        // Set the title of the window and show it
        primaryStage.setTitle("Fans Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}