
public class AddRemovePoints extends Application {
    
    private Pane pane;
    
    @Override
    public void start(Stage primaryStage) {
        pane = new Pane();
        Scene scene = new Scene(pane, 400, 400);
        
        
        pane.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                
                double x = event.getX();
                double y = event.getY();
                Circle point = new Circle(x, y, 5.0, Color.RED);
                pane.getChildren().add(point);
            } else if (event.getButton() == MouseButton.SECONDARY) {
                
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    Circle point = (Circle) pane.getChildren().get(i);
                    if (point.contains(event.getX(), event.getY())) {
                        pane.getChildren().remove(point);
                        break;
                    }
                }
            }
        });
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add/Remove Points");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
