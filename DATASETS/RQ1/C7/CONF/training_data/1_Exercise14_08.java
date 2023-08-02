




public class nan{
    Image[] cards;

    private void setCards() {
        cards = new Image[54];
        int cardNum = 1;
        for (int i = 0; i < cards.length; i++) {
            Image card =
                    new Image("resources" + File.separator + "images" + File.separator + "card" + File.separator + cardNum +
                            ".png");
            cards[i] = card;
            cardNum++;

        }

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        setCards();
        shuffle(cards);
        VBox vbox = new VBox();
        HBox buttonBar = new HBox();
        vbox.setFillWidth(true);
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> refreshCards(vbox));

        buttonBar.getChildren().add(refreshButton);
        buttonBar.setAlignment(Pos.CENTER);
        renderCardView(vbox);
        vbox.getChildren().add(buttonBar);
        Scene scene = new Scene(vbox);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void refreshCards(VBox vBox) {
        shuffle(cards); 
        int cardIdx = 0;
        int rowIdx = 0;
        HBox nuCardBox = new HBox();
        while (cardIdx < 54) {
            ImageView imageView = new ImageView(cards[cardIdx]);
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(150);
            nuCardBox.getChildren().add(imageView);
            cardIdx++;
            if (cardIdx % 9 == 0) {
                vBox.getChildren().set(rowIdx, nuCardBox);
                nuCardBox = new HBox();
                rowIdx++;
            }
        }
    }

    private void renderCardView(VBox vBox) {
        int cardIdx = 0;
        int rowIdx = 0;
        HBox nuCardBox = new HBox();
        while (cardIdx < 54) {
            ImageView imageView = new ImageView(cards[cardIdx]);
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(150);
            nuCardBox.getChildren().add(imageView);
            cardIdx++;
            if (cardIdx % 9 == 0) {
                vBox.getChildren().add(rowIdx, nuCardBox);
                nuCardBox = new HBox();
                rowIdx++;
            }
        }
    }

    static void shuffle(Image[] cards) {
        for (int i = 0; i < 54; i++) {
            int randomIndex = (int) (Math.random() * 54);
            Image temp = cards[randomIndex];
            cards[randomIndex] = cards[i];
            cards[i] = temp;
        }
    }
}
