



public class nan {

    @Override
    public void start(Stage primaryStage) {
        RecursiveCirclePane circlePane = new RecursiveCirclePane();
        Scene scene = new Scene(circlePane, 340, 340);
        circlePane.widthProperty().addListener(cl -> circlePane.resetCircles());
        circlePane.heightProperty().addListener(cl -> circlePane.resetCircles());
        primaryStage.setScene(scene);
        primaryStage.show();

        circlePane.paint();

    }

    static class RecursiveCirclePane extends Pane {
        private final double distanceBetween = 10.0;

        RecursiveCirclePane() {

        }

        private void resetCircles() {
            this.getChildren().clear();
            paint();
        }

        protected void paint() {
            this.setCenterShape(true);
            double initialRadius = (((getWidth() + getHeight()) / 2) / 2) - distanceBetween;
            drawCircles(initialRadius);

        }


        protected void drawCircles(double radius) {
            if (radius > 9.0) {
                Circle circle = new Circle(getWidth() / 2, getHeight() / 2, radius);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.TRANSPARENT);
                this.getChildren().add(circle);
                drawCircles(radius - distanceBetween);
            }
        }
    }

}

