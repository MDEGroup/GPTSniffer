





public class DisplayTicTacToeGame {
    Random random = new Random();
    static final String resourcePath = "resources" + File.separator + "tictactoe";

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gameBoard = new GridPane();
        Image X = new Image(resourcePath + File.separator + "x.png");
        Image O = new Image(resourcePath + File.separator + "o.png");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Pane pane = new Pane();
                ImageView imageView = new ImageView();
                if (getRandomXO()) {
                    if (getRandomXO()) {
                        imageView.setImage(X);
                    } else {
                        imageView.setImage(O);
                    }

                }
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(100);
                pane.getChildren().add(imageView);
                gameBoard.add(pane, i, j);
            }
        }
        Scene scene = new Scene(gameBoard, 315, 315);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    boolean getRandomXO() {
        return random.nextBoolean();
    }
}
