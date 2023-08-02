

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Exercise14_14 extends Application {
    double sceneWidth = 325;
    double sceneHeight = 325;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        
        Rectangle bottomLeftAlignedRectangle = new Rectangle(0, 0);
        bottomLeftAlignedRectangle.setFill(Color.TRANSPARENT);
        bottomLeftAlignedRectangle.setStroke(Color.BLACK);
        
        bottomLeftAlignedRectangle.xProperty().bind(pane.widthProperty().divide(4).subtract(25));
        bottomLeftAlignedRectangle.yProperty().bind(pane.heightProperty().divide(4).add(25));
        bottomLeftAlignedRectangle.widthProperty().bind(pane.widthProperty().divide(2));
        bottomLeftAlignedRectangle.heightProperty().bind(pane.heightProperty().divide(2));

        
        Rectangle topRightAlignedRectangle = new Rectangle(0, 0);
        topRightAlignedRectangle.setFill(Color.TRANSPARENT);
        topRightAlignedRectangle.setStroke(Color.BLACK);

        
        topRightAlignedRectangle.xProperty().bind(pane.widthProperty().divide(4).add(25));
        topRightAlignedRectangle.yProperty().bind(pane.heightProperty().divide(4).subtract(25));
        topRightAlignedRectangle.widthProperty().bind(pane.widthProperty().divide(2));
        topRightAlignedRectangle.heightProperty().bind(pane.heightProperty().divide(2));

        
        
        Line l1 = new Line();
        l1.startXProperty().bind(bottomLeftAlignedRectangle.xProperty());
        l1.startYProperty().bind(bottomLeftAlignedRectangle.yProperty());
        l1.endXProperty().bind(topRightAlignedRectangle.xProperty());
        l1.endYProperty().bind(topRightAlignedRectangle.yProperty());

        Line l2 = new Line();
        l2.startXProperty().bind(bottomLeftAlignedRectangle.xProperty());
        l2.startYProperty().bind(bottomLeftAlignedRectangle.yProperty().add(bottomLeftAlignedRectangle.heightProperty()));
        l2.endXProperty().bind(topRightAlignedRectangle.xProperty());
        l2.endYProperty().bind(topRightAlignedRectangle.yProperty().add(bottomLeftAlignedRectangle.heightProperty()));

        Line l3 = new Line();
        l3.startXProperty().bind(bottomLeftAlignedRectangle.xProperty().add(bottomLeftAlignedRectangle.widthProperty()));
        l3.startYProperty().bind(bottomLeftAlignedRectangle.yProperty().add(bottomLeftAlignedRectangle.heightProperty()));
        l3.endXProperty().bind(topRightAlignedRectangle.xProperty().add(bottomLeftAlignedRectangle.widthProperty()));
        l3.endYProperty().bind(topRightAlignedRectangle.yProperty().add(bottomLeftAlignedRectangle.heightProperty()));

        Line l4 = new Line();
        l4.startXProperty().bind(bottomLeftAlignedRectangle.xProperty().add(bottomLeftAlignedRectangle.widthProperty()));
        l4.startYProperty().bind(bottomLeftAlignedRectangle.yProperty());
        l4.endXProperty().bind(topRightAlignedRectangle.xProperty().add(bottomLeftAlignedRectangle.widthProperty()));
        l4.endYProperty().bind(topRightAlignedRectangle.yProperty());

        pane.getChildren().addAll(bottomLeftAlignedRectangle, topRightAlignedRectangle, l1, l2, l3, l4);
        Scene scene = new Scene(pane, sceneWidth, sceneHeight);
        scene.xProperty().add(scene.yProperty());
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}