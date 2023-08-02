
public class AlternateText extends Application {

    private Label label;

    @Override
    public void start(Stage primaryStage) {
        label = new Label("Java is fun");
        StackPane root = new StackPane(label);
        root.setOnMouseClicked(this::handleMouseClick);

        Scene scene = new Scene(root, 200, 100);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMouseClick(MouseEvent event) {
        String currentText = label.getText();
        if (currentText.equals("Java is fun")) {
            label.setText("Java is powerful");
        } else {
            label.setText("Java is fun");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
