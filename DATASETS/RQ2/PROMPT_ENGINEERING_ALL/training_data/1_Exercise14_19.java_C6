

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class nan{
    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    @Override
    public void start(Stage primaryStage) {
        Polyline polyline = new Polyline();
        ObservableList<Double> sinePoints = polyline.getPoints();
        double scaleFactor = 50;
        
        for (int x = -200; x <= 200; x++) {
            sinePoints.add(x + 200.0);
            sinePoints.add(200 - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI));
        }
        polyline.setStroke(Color.RED);
        
        Polyline polyline2 = new Polyline();
        ObservableList<Double> cosinePoints = polyline2.getPoints();
        for (int x = -200; x <= 200; x++) {
            cosinePoints.add(x + 200.0);
            cosinePoints.add(200 - scaleFactor * Math.cos((x / 100.0) * 2 * Math.PI));
        }
        polyline2.setStroke(Color.BLUE);
        Group group = new Group();
        group.getChildren().addAll(polyline, polyline2);

        Line line1 = new Line(10, 200, 390, 200); 
        group.getChildren().add(line1);

        Line line2 = new Line(200, 30, 200, 390); 
        group.getChildren().add(line2);

        
        Line line3 = new Line(390, 200, 370, 190);
        group.getChildren().add(line3);
        Line line4 = new Line(390, 200, 370, 210);
        group.getChildren().add(line4);

        
        Line line5 = new Line(200, 30, 190, 50);
        group.getChildren().add(line5);
        Line line6 = new Line(200, 30, 210, 50);
        group.getChildren().add(line6);

        Text X = new Text(390, 190, "X");
        Text Y = new Text(220, 40, "Y");

        Text zero = new Text(205, 220, "0"); 


        Text negPI = new Text(140, 220, "-" + "\u03c0");
        Text negTwoPI = new Text(90, 220, "-2" + "\u03c0");
        Text PI = new Text(250, 220, "\u03c0");
        Text twoPI = new Text(290, 220, "2" + "\u03c0");
        Text threePI = new Text(40, 220, "-3" + "\u03c0");
        Text negThreePI = new Text(340, 220, "3" + "\u03c0");

        group.getChildren().addAll(X, Y, zero, negPI, negTwoPI, PI, twoPI, threePI, negThreePI);

        Scene scene = new Scene(new BorderPane(group), WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
