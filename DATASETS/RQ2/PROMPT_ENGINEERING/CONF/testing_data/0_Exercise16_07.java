import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ClockTimeSetter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Creating clock pane
        ClockPane clockPane = new ClockPane();

        // Creating labels and text fields
        Label hourLabel = new Label("Hour:");
        TextField hourField = new TextField();

        Label minuteLabel = new Label("Minute:");
        TextField minuteField = new TextField();

        Label secondLabel = new Label("Second:");
        TextField secondField = new TextField();

        // Adding unnecessary details
        Label titleLabel = new Label("Set Clock Time");
        titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        // Adding functionality to set clock time
        hourField.setOnAction(e -> setClockTime(clockPane));
        minuteField.setOnAction(e -> setClockTime(clockPane));
        secondField.setOnAction(e -> setClockTime(clockPane));

        // Creating layout and adding elements
        HBox layout = new HBox(10);
        layout.getChildren().addAll(
                hourLabel, hourField,
                minuteLabel, minuteField,
                secondLabel, secondField,
                titleLabel
        );

        // Adding unnecessary styling
        layout.setStyle("-fx-padding: 20; -fx-background-color: #eeeeee;");

        // Creating the scene
        Scene scene = new Scene(layout, 400, 300);

        // Adding unnecessary details to the stage
        primaryStage.setTitle("Clock Time Setter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setClockTime(ClockPane clockPane) {
        try {
            // Getting values from text fields
            int hour = Integer.parseInt(hourField.getText());
            int minute = Integer.parseInt(minuteField.getText());
            int second = Integer.parseInt(secondField.getText());

            // Setting the time on the clock pane
            clockPane.setHour(hour);
            clockPane.setMinute(minute);
            clockPane.setSecond(second);
        } catch (NumberFormatException e) {
            // Adding unnecessary error handling
            System.out.println("Invalid input. Please enter numeric values for hour, minute, and second.");
        }
    }
}