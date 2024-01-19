import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MultipleBallApp extends Application {
    
    private ArrayList<Circle> balls = new ArrayList<>();
    private Group root = new Group();
    
    @Override
    public void start(Stage primaryStage) {
        
        Button removeButton = new Button("-");
        removeButton.setOnAction(e -> removeLargestBall());
        
        StackPane pane = new StackPane();
        pane.getChildren().addAll(root, removeButton);
        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();
        
        for (int i = 0; i < 10; i++) {
            Circle ball = createRandomBall();
            balls.add(ball);
            root.getChildren().add(ball);
        }
    }
    
    private Circle createRandomBall() {
        double radius = Math.random() * 18 + 2;
        Circle ball = new Circle(radius, Color.BLUE);
        ball.relocate(Math.random() * 360, Math.random() * 360);
        return ball;
    }
    
    private void removeLargestBall() {
        if (balls.size() > 0) {
            Circle largestBall = balls.get(0);
            for (Circle ball : balls) {
                if (ball.getRadius() > largestBall.getRadius()) {
                    largestBall = ball;
                }
            }
            root.getChildren().remove(largestBall);
            balls.remove(largestBall);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
