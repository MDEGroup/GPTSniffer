package ch_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Exercise15_13 extends Application {
    static final double WIDTH = 400;
    static final double HEIGHT = 150;
    static double mouseX;
    static double mouseY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(100, 60, 100, 40);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        Text message = new Text(rectangle.getWidth() / 2, rectangle.getHeight() / 2, "");
        pane.getChildren().add(rectangle);
        pane.getChildren().add(message);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnMouseMoved(mouseEvent -> {
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
            if (isPointInRectangle(mouseX, mouseY, rectangle)) {
                message.setText("Mouse point is inside the rectangle");
            } else {
                message.setText("Mouse point is outside the rectangle");
            }
            message.setX(mouseX);
            message.setY(mouseY);
        });

        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isPointInRectangle(double mouseX, double mouseY, Rectangle rectangle) {
        return rectangle.contains(mouseX, mouseY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
