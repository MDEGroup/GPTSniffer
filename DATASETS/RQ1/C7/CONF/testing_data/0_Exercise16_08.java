
public class CircleIntersection extends Application {
    private Circle circle1 = new Circle(new Point2D(100, 100), 50);
    private Circle circle2 = new Circle(new Point2D(200, 200), 50);
    private Canvas canvas;

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        canvas = new Canvas(400, 400);
        root.setCenter(canvas);

        drawCircles();

        canvas.setOnMousePressed(event -> {
            if (circle1.contains(event.getX(), event.getY())) {
                circle1.setCenter(new Point2D(event.getX(), event.getY()));
                drawCircles();
            } else if (circle2.contains(event.getX(), event.getY())) {
                circle2.setCenter(new Point2D(event.getX(), event.getY()));
                drawCircles();
            }
        });

        canvas.setOnMouseDragged(event -> {
            if (circle1.contains(event.getX(), event.getY())) {
                circle1.setCenter(new Point2D(event.getX(), event.getY()));
                drawCircles();
            } else if (circle2.contains(event.getX(), event.getY())) {
                circle2.setCenter(new Point2D(event.getX(), event.getY()));
                drawCircles();
            }
        });

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawCircles() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (circle1.intersects(circle2)) {
            gc.setFill(Color.RED);
        } else {
            gc.setFill(Color.GREEN);
        }
        gc.fillOval(circle1.getCenter().getX() - circle1.getRadius(), circle1.getCenter().getY() - circle1.getRadius(),
                circle1.getRadius() * 2, circle1.getRadius() * 2);

        if (circle2.intersects(circle1)) {
            gc.setFill(Color.RED);
        } else {
            gc.setFill(Color.GREEN);
        }
        gc.fillOval(circle2.getCenter().getX() - circle2.getRadius(), circle2.getCenter().getY() - circle2.getRadius(),
                circle2.getRadius() * 2, circle2.getRadius() * 2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
