
public class CylinderDrawing extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        Arc topArc = new Arc(150, 50, 100, 50, 0, 180);
        Arc bottomArc = new Arc(150, 200, 100, 50, 0, 180);

        
        topArc.setStrokeType(StrokeType.INSIDE);
        topArc.setStrokeWidth(5);
        bottomArc.setStrokeType(StrokeType.INSIDE);
        bottomArc.setStrokeWidth(5);

        
        topArc.setStroke(Color.BLACK);
        topArc.setFill(Color.WHITE);
        bottomArc.setStroke(Color.BLACK);
        bottomArc.setFill(Color.WHITE);

        
        topArc.setType(ArcType.ROUND);
        bottomArc.setType(ArcType.ROUND);

        
        topArc.getStrokeDashArray().addAll(6.0, 21.0);
        bottomArc.getStrokeDashArray().addAll(6.0, 21.0);

        
        Group group = new Group(topArc, bottomArc);

        
        Scene scene = new Scene(group, 300, 300);

        
        primaryStage.setTitle("Cylinder Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
