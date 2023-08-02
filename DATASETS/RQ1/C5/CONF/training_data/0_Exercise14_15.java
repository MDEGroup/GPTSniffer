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
        octagon.setFill(Color.RED); 
        
        
        Text stopText = new Text("STOP");
        stopText.setFont(Font.font("Arial", 100)); 
        stopText.setFill(Color.WHITE); 
        
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(octagon, stopText);
        
        
        Scene scene = new Scene(stackPane, 300, 300);
        
        
        primaryStage.setTitle("STOP Sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}