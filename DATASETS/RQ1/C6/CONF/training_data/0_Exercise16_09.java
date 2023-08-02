import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RectangleIntersection extends Application {

    private Rectangle rect1;
    private Rectangle rect2;
    private Text center1X;
    private Text center1Y;
    private Text center2X;
    private Text center2Y;

    @Override
    public void start(Stage primaryStage) {
        
        rect1 = new Rectangle(50, 50, 100, 100);
        rect1.setFill(Color.TRANSPARENT);
        rect1.setStroke(Color.BLACK);
        rect2 = new Rectangle(200, 150, 150, 75);
        rect2.setFill(Color.TRANSPARENT);
        rect2.setStroke(Color.BLACK);
        center1X = new Text(rect1.getX() + rect1.getWidth() / 2, rect1.getY() + rect1.getHeight() / 2, String.valueOf(rect1.getX() + rect1.getWidth() / 2));
        center1Y = new Text(rect1.getX() + rect1.getWidth() / 2, rect1.getY() + rect1.getHeight() / 2 + 20, String.valueOf(rect1.getY() + rect1.getHeight() / 2));
        center2X = new Text(rect2.getX() + rect2.getWidth() / 2, rect2.getY() + rect2.getHeight() / 2, String.valueOf(rect2.getX() + rect2.getWidth() / 2));
        center2Y = new Text(rect2.getX() + rect2.getWidth() / 2, rect2.getY() + rect2.getHeight() / 2 + 20, String.valueOf(rect2.getY() + rect2.getHeight() / 2));

        
        rect1.setOnMouseDragged(e -> {
            rect1.setX(e.getX() - rect1.getWidth() / 2);
            rect1.setY(e.getY() - rect1.getHeight() / 2);
            updateCenterText(center1X, center1Y, rect1);
            checkIntersection();
        });
        rect2.setOnMouseDragged(e -> {
            rect2.setX(e.getX() - rect2.getWidth() / 2);
            rect2.setY(e.getY() - rect2.getHeight() / 2);
            updateCenterText(center2X, center2Y, rect2);
            checkIntersection();
        });

        
        Pane pane = new Pane();
        pane.getChildren().addAll(rect1, rect2, center1X, center1Y, center2X, center2Y);

        
        primaryStage.setTitle("Rectangle Intersection");
        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();

        
        checkIntersection();
    }

    private void updateCenterText(Text centerX, Text centerY, Rectangle rect) {
        centerX.setText(String.valueOf(rect.getX() + rect.getWidth() / 2));
        centerY.setText(String.valueOf(rect.getY() + rect.getHeight() / 2));
    }

    private void checkIntersection() {
        if (rect1.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
            System.out.println("Rectangles intersect");
        } else {
            System.out.println("Rectangles do not intersect");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
