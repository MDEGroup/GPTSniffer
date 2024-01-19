import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RadioButtonDemo extends Application {

    private Text messageText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Setting up the primary stage
        primaryStage.setTitle("Radio Button Demo");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    private Scene createScene() {
        // Creating a horizontal box layout
        HBox root = new HBox(10);
        root.setStyle("-fx-background-color: #eeeeee;"); // Setting background color

        // Creating a Text element
        messageText = new Text("Hello, JavaFX!");
        messageText.setFont(new Font(20));

        // Creating buttons to move the message
        Button leftButton = new Button("Move Left");
        Button rightButton = new Button("Move Right");

        // Adding button functionality
        leftButton.setOnAction(e -> moveMessageLeft());
        rightButton.setOnAction(e -> moveMessageRight());

        // Creating radio buttons to change text color
        RadioButton redRadio = new RadioButton("Red");
        RadioButton greenRadio = new RadioButton("Green");
        RadioButton blueRadio = new RadioButton("Blue");

        // Adding radio buttons to a toggle group
        ToggleGroup colorGroup = new ToggleGroup();
        redRadio.setToggleGroup(colorGroup);
        greenRadio.setToggleGroup(colorGroup);
        blueRadio.setToggleGroup(colorGroup);

        // Adding radio button functionality
        redRadio.setOnAction(e -> changeColor(Color.RED));
        greenRadio.setOnAction(e -> changeColor(Color.GREEN));
        blueRadio.setOnAction(e -> changeColor(Color.BLUE));

        // Adding elements to the layout
        root.getChildren().addAll(leftButton, rightButton, redRadio, greenRadio, blueRadio, messageText);

        // Creating the scene
        return new Scene(root, 400, 150);
    }

    private void moveMessageLeft() {
        // Move message to the left
        double currentX = messageText.getTranslateX();
        messageText.setTranslateX(currentX - 10);
    }

    private void moveMessageRight() {
        // Move message to the right
        double currentX = messageText.getTranslateX();
        messageText.setTranslateX(currentX + 10);
    }

    private void changeColor(Color color) {
        // Change text color
        messageText.setFill(color);
    }
}