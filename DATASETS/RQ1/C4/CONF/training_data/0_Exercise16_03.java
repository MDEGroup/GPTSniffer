import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLight extends Application {
    private Circle redLight;
    private Circle yellowLight;
    private Circle greenLight;

    @Override
    public void start(Stage stage) {
        
        redLight = new Circle(50, Color.GRAY);
        yellowLight = new Circle(50, Color.GRAY);
        greenLight = new Circle(50, Color.GRAY);

        
        RadioButton redButton = new RadioButton("Red");
        redButton.setOnAction(e -> setRed());
        RadioButton yellowButton = new RadioButton("Yellow");
        yellowButton.setOnAction(e -> setYellow());
        RadioButton greenButton = new RadioButton("Green");
        greenButton.setOnAction(e -> setGreen());

        
        ToggleGroup group = new ToggleGroup();
        redButton.setToggleGroup(group);
        yellowButton.setToggleGroup(group);
        greenButton.setToggleGroup(group);

        
        group.selectToggle(null);

        
        HBox lightsBox = new HBox(20, redLight, yellowLight, greenLight);
        HBox buttonsBox = new HBox(20, redButton, yellowButton, greenButton);
        StackPane root = new StackPane(lightsBox, buttonsBox);
        root.setPadding(new Insets(20));

        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Traffic Light");
        stage.show();
    }

    private void setRed() {
        redLight.setFill(Color.RED);
        yellowLight.setFill(Color.GRAY);
        greenLight.setFill(Color.GRAY);
    }

    private void setYellow() {
        redLight.setFill(Color.GRAY);
        yellowLight.setFill(Color.YELLOW);
        greenLight.setFill(Color.GRAY);
    }

    private void setGreen() {
        redLight.setFill(Color.GRAY);
        yellowLight.setFill(Color.GRAY);
        greenLight.setFill(Color.GREEN);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
