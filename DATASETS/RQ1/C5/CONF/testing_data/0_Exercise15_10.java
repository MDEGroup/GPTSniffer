import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StringDisplay extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        StackPane root = new StackPane();
        root.getChildren().add(textArea);

        Scene scene = new Scene(root, 300, 200);

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                textArea.appendText("\n"); 
            }
        });

        scene.setOnKeyTyped(event -> {
            String input = event.getCharacter();
            textArea.appendText(input);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}