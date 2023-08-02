import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Hangman extends Application {
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int MARGIN = 50;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Line base = new Line(MARGIN, HEIGHT - MARGIN, WIDTH - MARGIN, HEIGHT - MARGIN);
        Line pole = new Line(MARGIN, MARGIN, MARGIN, HEIGHT - MARGIN);
        Line rope = new Line(pole.getEndX(), pole.getEndY(), pole.getEndX(), pole.getEndY() + 50);
        Circle head = new Circle(rope.getEndX(), rope.getEndY() + 25, 25);
        Line body = new Line(head.getCenterX(), head.getCenterY() + head.getRadius(), head.getCenterX(), head.getCenterY() + head.getRadius() + 100);
        Line leftArm = new Line(body.getEndX(), body.getEndY() - 50, body.getEndX() - 50, body.getEndY());
        Line rightArm = new Line(body.getEndX(), body.getEndY() - 50, body.getEndX() + 50, body.getEndY());
        Line leftLeg = new Line(body.getEndX(), body.getEndY(), body.getEndX() - 50, body.getEndY() + 100);
        Line rightLeg = new Line(body.getEndX(), body.getEndY(), body.getEndX() + 50, body.getEndY() + 100);
        
        
        Rectangle ground = new Rectangle(MARGIN, HEIGHT - MARGIN + 10, WIDTH - 2 * MARGIN, 10);
        ground.setFill(javafx.scene.paint.Color.BROWN);
        
        
        Group group = new Group(base, pole, rope, head, body, leftArm, rightArm, leftLeg, rightLeg, ground);
        
        
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        
        
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}