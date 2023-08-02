import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StopSign extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create a polygon that represents an octagon
        Polygon octagon = new Polygon();
        octagon.getPoints().addAll(new Double[]{
            100.0, 0.0,
            200.0, 0.0,
            300.0, 100.0,
            300.0, 200.0,
            200.0, 300.0,
            100.0, 300.0,
            0.0, 200.0,
            0.0, 100.0
        });
        octagon.setFill(Color.RED); // Set the octagon to be red
        
        // Create a text object that says "STOP"
        Text stopText = new Text("STOP");
        stopText.setFont(Font.font("Arial", 100)); // Set the font and size of the text
        stopText.setFill(Color.WHITE); // Set the text color to white
        
        // Create a stack pane to hold the octagon and text
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(octagon, stopText);
        
        // Create a scene with the stack pane as the root node
        Scene scene = new Scene(stackPane, 300, 300);
        
        // Set the title of the window and display it
        primaryStage.setTitle("STOP Sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}