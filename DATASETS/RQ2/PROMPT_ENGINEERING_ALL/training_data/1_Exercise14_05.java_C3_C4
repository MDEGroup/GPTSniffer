

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Exercise14_05 extends Application {
    static String[] message = new String[]{"W", "E", "L", "C", "O", "M", "E", " ", "T", "O", " ", "J", "A", "V", "A"};
    static Font font = Font.font("Times New Roman", FontWeight.BOLD, 28);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        double radius = 75;
        for (int i = 0, currentAngle = 0, rotation = 90; i < message.length; i++, currentAngle += 22, rotation += 22) {
            double x = 105 + radius * Math.cos(Math.toRadians(currentAngle));
            double y = 105 + radius * Math.sin(Math.toRadians(currentAngle));
            Text text = new Text(x, y, message[i]);
            text.setFont(font);
            text.setRotate(rotation);
            pane.getChildren().add(text);

        }
        Scene scene = new Scene(pane, 225, 225);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}