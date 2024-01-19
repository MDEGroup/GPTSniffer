import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TwoClocksApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create ClockPane for the first clock
        ClockPane clock1 = new ClockPane(4, 20, 45);

        // Create ClockPane for the second clock
        ClockPane clock2 = new ClockPane(22, 46, 15);

        // Create an HBox to hold the clocks
        HBox hbox = new HBox(20); // Add some spacing between clocks
        hbox.getChildren().addAll(clock1, clock2);

        // Create a scene and set it in the stage
        Scene scene = new Scene(hbox, 400, 200);

        // Set the stage title
        primaryStage.setTitle("Two Clocks");

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class ClockPane {
        // Some overly descriptive attributes
        private int hour;
        private int minute;
        private int second;

        // Constructor for the ClockPane
        public ClockPane(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            // More unnecessary comments
        }

        // Other clock-related methods...
    }
}