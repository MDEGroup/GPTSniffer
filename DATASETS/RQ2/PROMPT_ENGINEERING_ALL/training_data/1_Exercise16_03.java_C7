




public class TrafficLightSimulator {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainBox = new VBox(5);
        HBox topBox = new HBox(5);
        topBox.setAlignment(Pos.CENTER);

        Rectangle rectangle = new Rectangle(100, 250);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.TRANSPARENT);

        HBox buttonBox = new HBox(5);
        ToggleGroup radioButtons = new ToggleGroup();
        RadioButton redButton = new RadioButton("Red");

        RadioButton greenButton = new RadioButton("Green");
        RadioButton yellowButton = new RadioButton("Yellow");
        radioButtons.getToggles().addAll(redButton, greenButton, yellowButton);
        buttonBox.getChildren().addAll(redButton, greenButton, yellowButton);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        rectangle.setTranslateY(50);
        rectangle.setTranslateX(30);
        buttonBox.setTranslateY(100);

        Circle redLight = new Circle(rectangle.getWidth() / 2 - 15);
        redLight.setTranslateX(-62);
        redLight.setTranslateY(-20);
        redLight.setFill(Color.TRANSPARENT);
        redLight.setStroke(Color.BLACK);

        Circle greenLight = new Circle(rectangle.getWidth() / 2 - 15);
        greenLight.setTranslateX(-137);
        greenLight.setTranslateY(57);
        greenLight.setFill(Color.TRANSPARENT);
        greenLight.setStroke(Color.BLACK);

        Circle yellowLight = new Circle(rectangle.getWidth() / 2 - 15);
        yellowLight.setTranslateX(-212);
        yellowLight.setTranslateY(135);
        yellowLight.setFill(Color.TRANSPARENT);
        yellowLight.setStroke(Color.BLACK);

        radioButtons.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (redButton.isSelected()) {
                redLight.setFill(Color.RED);
                greenLight.setFill(Color.TRANSPARENT);
                yellowLight.setFill(Color.TRANSPARENT);
            } else if (greenButton.isSelected()) {
                greenLight.setFill(Color.GREEN);
                redLight.setFill(Color.TRANSPARENT);
                yellowLight.setFill(Color.TRANSPARENT);
            } else if (yellowButton.isSelected()) {
                yellowLight.setFill(Color.YELLOW);
                greenLight.setFill(Color.TRANSPARENT);
                redLight.setFill(Color.TRANSPARENT);

            }
        });
        topBox.getChildren().add(rectangle);
        topBox.getChildren().add(redLight);
        topBox.getChildren().add(greenLight);
        topBox.getChildren().add(yellowLight);

        mainBox.getChildren().add(topBox);
        mainBox.getChildren().add(buttonBox);

        redButton.setSelected(true);

        Scene scene = new Scene(mainBox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

}
