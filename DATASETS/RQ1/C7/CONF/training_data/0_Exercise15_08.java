
public class MousePositionOnPress extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text positionText = new Text();

        Pane pane = new Pane();
        pane.getChildren().add(positionText);

        pane.setOnMousePressed(e -> {
            double x = e.getX();
            double y = e.getY();

            positionText.setText("Mouse position: (" + x + ", " + y + ")");
            positionText.setX(x);
            positionText.setY(y);
        });

        pane.setOnMouseReleased(e -> {
            positionText.setText("");
        });

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mouse Position On Press");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
