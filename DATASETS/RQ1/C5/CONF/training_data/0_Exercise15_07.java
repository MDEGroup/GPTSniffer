import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleColor extends Application {

    @Override
    public void start(Stage primaryStage) {

        
        Circle circle = new Circle(150, 150, 50);

        
        circle.setFill(Color.BLACK);

        
        circle.setOnMousePressed(event -> circle.setFill(Color.WHITE));
        circle.setOnMouseReleased(event -> circle.setFill(Color.BLACK));

        
        Pane pane = new Pane();
        pane.getChildren().add(circle);

        
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Color");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}