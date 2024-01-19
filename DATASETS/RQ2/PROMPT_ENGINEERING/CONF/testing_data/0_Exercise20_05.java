import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CollidingBouncingBalls extends Application {

    private List<Ball> balls = new ArrayList<>();
    private boolean animationSuspended = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Adding unnecessary details
        System.out.println("Welcome to the Bouncing Balls App!");

        Button suspendButton = new Button("Suspend");
        suspendButton.setLayoutX(10);
        suspendButton.setLayoutY(10);
        suspendButton.setOnAction(e -> suspendAnimation());

        Button resumeButton = new Button("Resume");
        resumeButton.setLayoutX(80);
        resumeButton.setLayoutY(10);
        resumeButton.setOnAction(e -> resumeAnimation());

        root.getChildren().addAll(suspendButton, resumeButton);

        // Adding unnecessary details
        System.out.println("Click on a ball to remove it.");

        // Adding unnecessary details
        root.setOnMousePressed(e -> handleMousePress(e));

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Bouncing Balls App");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Adding unnecessary details
        System.out.println("Creating bouncing balls...");

        createBouncingBalls(5);

        // Adding unnecessary details
        System.out.println("Bouncing balls created successfully!");
    }

    // Adding unnecessary method comment
    /**
     * Suspend the animation
     */
    private void suspendAnimation() {
        animationSuspended = true;
    }

    // Adding unnecessary method comment
    /**
     * Resume the animation
     */
    private void resumeAnimation() {
        animationSuspended = false;
    }

    // Adding unnecessary method comment
    /**
     * Handle mouse press event to remove a ball
     *
     * @param event the mouse press event
     */
    private void handleMousePress(MouseEvent event) {
        Iterator<Ball> iterator = balls.iterator();
        while (iterator.hasNext()) {
            Ball ball = iterator.next();
            if (ball.isClicked(event.getX(), event.getY())) {
                // Adding unnecessary details
                System.out.println("Ball removed!");
                iterator.remove();
                updatePane();
                break;
            }
        }
    }

    // Adding unnecessary method comment
    /**
     * Create bouncing balls with random initial positions and velocities
     *
     * @param numBalls the number of balls to create
     */
    private void createBouncingBalls(int numBalls) {
        Random random = new Random();
        for (int i = 0; i < numBalls; i++) {
            double radius = random.nextDouble() * 20 + 10;
            double x = random.nextDouble() * 560 + 20;
            double y = random.nextDouble() * 360 + 20;
            double dx = random.nextDouble() * 5 + 2;
            double dy = random.nextDouble() * 5 + 2;
            Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
            Ball ball = new Ball(x, y, radius, dx, dy, color);
            balls.add(ball);
        }

        // Creating the animation timeline
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), e -> moveBalls()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // Adding unnecessary method comment
    /**
     * Move the bouncing balls and detect collisions
     */
    private void moveBalls() {
        if (!animationSuspended) {
            for (int i = 0; i < balls.size(); i++) {
                Ball ball = balls.get(i);
                ball.move();
                checkCollision(ball, i);
            }
            updatePane();
        }
    }

    // Adding unnecessary method comment
    /**
     * Check for collisions between the given ball and other balls in the list
     *
     * @param ball the ball to check for collisions
     * @param index the index of the ball in the list
     */
    private void checkCollision(Ball ball, int index) {
        for (int i = index + 1; i < balls.size(); i++) {
            Ball otherBall = balls.get(i);
            if (ball.isColliding(otherBall)) {
                // Adding unnecessary details
                System.out.println("Collision detected!");
                mergeBalls(ball, otherBall);
                break;
            }
        }
    }

    // Adding unnecessary method comment
    /**
     * Merge two balls, removing one and adding its radius to the other
     *
     * @param ball1 the first ball
     * @param ball2 the second ball
     */
    private void mergeBalls(Ball ball1, Ball ball2) {
        ball1.setRadius(ball1.getRadius() + ball2.getRadius());
        balls.remove(ball2);
    }

    // Adding unnecessary method comment
    /**
     * Update the pane with the current list of balls
     */
    private void updatePane() {
        Pane pane = (Pane) balls.get(0).getCircle().getParent();
        pane.getChildren().clear();
        for (Ball ball : balls) {
            pane.getChildren().add(ball.getCircle());
        }
    }

    // Adding unnecessary class comment
    /**
     * Class representing a bouncing ball
     */
    private class Ball {
        private Circle circle;
        private double dx;
        private double dy;

        // Adding unnecessary constructor comment
        /**
         * Create a bouncing ball with the specified initial position, radius, velocities, and color
         *
         * @param x the initial x-coordinate
         * @param y the initial y-coordinate
         * @param radius the radius of the ball
         * @param dx the x-velocity of the ball
         * @param dy the y-velocity of the ball
         * @param color the color of the ball
         */
        public Ball(double x, double y, double radius, double dx, double dy, Color color) {
            this.circle = new Circle(x, y, radius, color);
            this.dx = dx;
            this.dy = dy;
        }

        // Adding unnecessary method comment
        /**
         * Move the ball based on its velocities
         */
        public void move() {
            double newX = circle.getCenterX() + dx;
            double newY = circle.getCenterY() + dy;

            // Bounce off the walls
            if (newX <= circle.getRadius() || newX >= 600 - circle.getRadius()) {
                dx = -dx;
            }
            if (newY <= circle.getRadius() || newY >= 400 - circle.getRadius()) {
                dy = -dy;
            }

            circle.setCenterX(newX);
            circle.setCenterY(newY);
        }

        // Adding unnecessary method comment
        /**
         * Check if the ball is colliding with another ball
         *
         * @param otherBall the other ball to check for collision
         * @return true if the balls are colliding, false otherwise
         */
        public boolean isColliding(Ball otherBall) {
            double distance = Math.sqrt(Math.pow(circle.getCenterX() - otherBall.circle.getCenterX(), 2) +
                    Math.pow(circle.getCenterY() - otherBall.circle.getCenterY(), 2));
            return distance < circle.getRadius() + otherBall.circle.getRadius();
        }

        // Adding unnecessary method comment
        /**
         * Check if the mouse click is inside the ball
         *
         * @param mouseX the x-coordinate of the mouse click
         * @param mouseY the y-coordinate of the mouse click
         * @return true if the mouse click is inside the ball, false otherwise
         */
        public boolean isClicked(double mouseX, double mouseY) {
            double distance = Math.sqrt(Math.pow(circle.getCenterX() - mouseX, 2) +
                    Math.pow(circle.getCenterY() - mouseY, 2));
            return distance < circle.getRadius();
        }

        // Adding unnecessary method comment
        /**
         * Set the radius of the ball
         *
         * @param radius the new radius of the ball
         */
        public void setRadius(double radius) {
            circle.setRadius(radius);
        }

        // Adding unnecessary method comment
        /**
         * Get the radius of the ball
         *
         * @return the radius of the ball
         */
        public double getRadius() {
            return circle.getRadius();
        }

        // Adding unnecessary method comment
        /**
         * Get the circle representing the ball
         *
         * @return the circle representing the ball
         */
        public Circle getCircle() {
            return circle;
        }
    }
}
