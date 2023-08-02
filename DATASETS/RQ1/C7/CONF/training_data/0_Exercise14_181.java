
public class SquareFunctionPlotter extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Polyline polyline = new Polyline();
        polyline.setStroke(Color.BLUE);
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.0125;
        for (int x = -100; x <= 100; x++) {
            list.add(x + 200.0);
            list.add(scaleFactor * x * x);
        }

        pane.getChildren().add(polyline);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Square Function Plotter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
