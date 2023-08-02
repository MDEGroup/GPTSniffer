
public class MoveBall extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int RADIUS = 20;
    private static final int SPEED = 50; 

    private Circle ball;
    private Pane pane;
    private TranslateTransition transition;

    @Override
    public void start(Stage primaryStage) {
        
        ball = new Circle(RADIUS, Color.RED);
        ball.setTranslateX(WIDTH / 2);
        ball.setTranslateY(HEIGHT / 2);

        
        pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(ball);

        
        transition = new TranslateTransition(Duration.seconds(1), ball);
        transition.setByX(0); 
        transition.setByY(0); 
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);

        
        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    moveUp();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case RIGHT:
                    moveRight();
                    break;
                default:
                    break;
            }
        });
        pane.requestFocus(); 

        
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Move Ball");
        primaryStage.show();
    }

    private void moveUp() {
        if (ball.getTranslateY() - RADIUS > 0) {
            transition.stop();
            transition.setByX(0);
            transition.setByY(-SPEED);
            transition.play();
        }
    }

    private void moveDown() {
        if (ball.getTranslateY() + RADIUS < HEIGHT) {
            transition.stop();
            transition.setByX(0);
            transition.setByY(SPEED);
            transition.play();
        }
    }

    private void moveLeft() {
        if (ball.getTranslateX() - RADIUS > 0) {
            transition.stop();
            transition.setByX(-SPEED);
            transition.setByY(0);
            transition.play();
        }
    }

    private void moveRight() {
        if (ball.getTranslateX() + RADIUS < WIDTH) {
            transition.stop();
            transition.setByX(SPEED);
            transition.setByY(0);
            transition.play();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
