import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TwoClocks extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        ClockPane clock1 = new ClockPane(4, 20, 45);
        ClockPane clock2 = new ClockPane(22, 46, 15);

        
        HBox hbox = new HBox(clock1, clock2);

        
        Scene scene = new Scene(hbox, 600, 300);

        
        primaryStage.setTitle("Two Clocks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
