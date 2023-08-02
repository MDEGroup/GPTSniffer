import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Rectanguloid extends Application {

    private final double BOX_SIZE = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        StackPane root = new StackPane();

        
        Group group = new Group();
        root.getChildren().add(group);

        
        Box box = new Box(BOX_SIZE, BOX_SIZE, BOX_SIZE);
        box.setMaterial(new PhongMaterial(Color.RED));
        group.getChildren().add(box);

        
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setFieldOfView(45);
        camera.setFarClip(10000);
        camera.setTranslateZ(-1000);
        root.getChildren().add(camera);

        
        Scene scene = new Scene(root, 500, 500, true, SceneAntialiasing.BALANCED);
        scene.setCamera(camera);

        
        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            double scale = newValue.doubleValue() / scene.getHeight();
            group.setScaleX(scale);
        });
        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            double scale = newValue.doubleValue() / scene.getWidth();
            group.setScaleY(scale);
        });

        
        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        group.getTransforms().addAll(rotateX, rotateY);

        Point3D axisX = new Point3D(1, 0, 0);
        Point3D axisY = new Point3D(0, 1, 0);

        group.setOnMousePressed(event -> {
            group.getTransforms().add(new Translate(event.getSceneX(), event.getSceneY(), 0));
        });

        group.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - group.getTransforms().get(group.getTransforms().size() - 1).getTx();
            double deltaY = event.getSceneY() - group.getTransforms().get(group.getTransforms().size() - 1).getTy();

            rotateX.setAngle(rotateX.getAngle() - deltaY / 5);
            rotateY.setAngle(rotateY.getAngle() + deltaX / 5);

            group.getTransforms().set(group.getTransforms().size() - 1, new Translate(event.getSceneX(), event.getSceneY(), 0));
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rectanguloid");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}