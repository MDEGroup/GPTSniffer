package ch_15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Exercise15_15 extends Application {
    static final double WIDTH = 400;
    static final double HEIGHT = 150;
    static double mouseX;
    static double mouseY;
    final static double RADIUS = 5;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        ObservableList<Node> observableList = pane.getChildren();
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnMouseClicked(mouseEvent -> {
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
            if (mouseEvent.getButton().name().equals(MouseButton.PRIMARY.name())) {
                Circle circle = new Circle(mouseX, mouseY, RADIUS);
                circle.setFill(Color.TRANSPARENT);
                circle.setStroke(Color.BLACK);
                observableList.add(circle);
            } else if (mouseEvent.getButton().name().equals(MouseButton.SECONDARY.name())) {
                for (int i = 0; i < observableList.size(); i++) {
                    Node node = observableList.get(i);
                    if (node instanceof Circle) {
                        if (node.contains(mouseX, mouseY)) {
                            observableList.remove(node);
                        }
                    }
                }
            }

        });

        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
