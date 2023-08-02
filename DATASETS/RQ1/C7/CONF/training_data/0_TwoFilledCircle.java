

public class CirclesAndLineExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();
        
        
        Random random = new Random();
        
        
        double centerX1 = random.nextDouble() * (pane.getWidth() - 30) + 15;
        double centerY1 = random.nextDouble() * (pane.getHeight() - 30) + 15;
        Circle circle1 = new Circle(centerX1, centerY1, 15);
        circle1.setFill(Color.RED);
        
        
        double centerX2 = random.nextDouble() * (pane.getWidth() - 30) + 15;
        double centerY2 = random.nextDouble() * (pane.getHeight() - 30) + 15;
        Circle circle2 = new Circle(centerX2, centerY2, 15);
        circle2.setFill(Color.BLUE);
        
        
        Line line = new Line(centerX1, centerY1, centerX2, centerY2);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(2.0);
        
        
        double distance = Math.sqrt(Math.pow(centerX2 - centerX1, 2) + Math.pow(centerY2 - centerY1, 2));
        
        
        Text distanceText = new Text((centerX1 + centerX2) / 2, (centerY1 + centerY2) / 2, String.format("%.2f", distance));
        distanceText.setFill(Color.BLACK);
        distanceText.setStroke(Color.WHITE);
        distanceText.setStrokeWidth(2.0);
        
        
        pane.getChildren().addAll(circle1, circle2, line, distanceText);
        
        
        Scene scene = new Scene(pane, 400, 300);
        
        
        primaryStage.setTitle("Circles and Line Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

