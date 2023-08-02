



public class ChangeCircleColorOnClick{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Circle circle = new Circle(200, 125, 100, Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        pane.setOnMousePressed(event -> circle.setFill(Color.BLACK));
        pane.setOnMouseReleased(event -> circle.setFill(Color.WHITE));

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
