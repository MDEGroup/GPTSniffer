import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayImages extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10));
        
        
        ImageView image1 = new ImageView(new Image("image1.jpg"));
        pane.add(image1, 0, 0);
        
        ImageView image2 = new ImageView(new Image("image2.jpg"));
        pane.add(image2, 1, 0);
        
        ImageView image3 = new ImageView(new Image("image3.jpg"));
        pane.add(image3, 0, 1);
        
        ImageView image4 = new ImageView(new Image("image4.jpg"));
        pane.add(image4, 1, 1);
        
        
        Scene scene = new Scene(pane, 400, 400);
        
        
        primaryStage.setTitle("Display Images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}