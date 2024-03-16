import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MilesKilometersConverter extends Application {

    private TextField milesField;
    private TextField kilometersField;

    @Override
    public void start(Stage primaryStage) {
        // Create the input fields for miles and kilometers
        milesField = new TextField();
        kilometersField = new TextField();

        // Set the event handlers for when the user presses Enter in the input fields
        milesField.setOnAction(e -> convertMilesToKilometers());
        kilometersField.setOnAction(e -> convertKilometersToMiles());

        // Create labels for the input fields
        Label milesLabel = new Label("Miles:");
        Label kilometersLabel = new Label("Kilometers:");

        // Create a layout for the input fields and labels
        HBox inputBox = new HBox(10, milesLabel, milesField, kilometersLabel, kilometersField);
        inputBox.setAlignment(Pos.CENTER);

        // Create the main layout of the scene
        VBox root = new VBox(20, inputBox);
        root.setAlignment(Pos.CENTER);

        // Set the scene and show the stage
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Miles/Kilometers Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convertMilesToKilometers() {
        try {
            // Get the value from the miles input field and convert it to kilometers
            double miles = Double.parseDouble(milesField.getText());
            double kilometers = miles * 1.609344;

            // Update the kilometers input field with the converted value
            kilometersField.setText(String.format("%.2f", kilometers));
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g. non-numeric values)
            kilometersField.setText("Invalid input");
        }
    }

    private void convertKilometersToMiles() {
        try {
            // Get the value from the kilometers input field and convert it to miles
            double kilometers = Double.parseDouble(kilometersField.getText());
            double miles = kilometers / 1.609344;

            // Update the miles input field with the converted value
            milesField.setText(String.format("%.2f", miles));
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g. non-numeric values)
            milesField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
