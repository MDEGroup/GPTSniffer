



public class InsideCircleHover{
    static final double WIDTH = 400;
    static final double HEIGHT = 150;
    static double mouseX;
    static double mouseY;
    static double RADIUS = 50;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Circle circle = new Circle(100, 60, RADIUS, Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        Text message = new Text(circle.getCenterX(), circle.getCenterY(), "");
        pane.getChildren().add(circle);
        pane.getChildren().add(message);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnMouseMoved(mouseEvent -> {
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
            if (isPointInCircle(mouseX, mouseY, circle)) {
                message.setX(mouseX);
                message.setY(mouseY);
                message.setText("Mouse point is inside the circle");
            } else {
                message.setX(mouseX);
                message.setY(mouseY);
                message.setText("Mouse point is outside the circle");

            }
        });

        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isPointInCircle(double mouseX, double mouseY, Circle circle) {
        double distFromCenterPoint =
                Math.sqrt(Math.pow(mouseX - circle.getCenterX(), 2) + Math.pow(mouseY - circle.getCenterY(), 2));
        return distFromCenterPoint <= RADIUS;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
