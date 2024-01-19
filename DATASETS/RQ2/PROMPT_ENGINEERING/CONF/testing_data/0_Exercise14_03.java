import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisplayThreeRandomCards extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox cardBox = new HBox();

        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            cardNumbers.add(i);
        }
        Collections.shuffle(cardNumbers);

        for (int i = 0; i < 3; i++) {
            int cardNumber = cardNumbers.get(i);
            String cardImagePath = "image/card/" + cardNumber + ".png";
            Image cardImage = new Image(cardImagePath);
            ImageView cardImageView = new ImageView(cardImage);
            cardBox.getChildren().add(cardImageView);
        }

        Scene scene = new Scene(cardBox);
        primaryStage.setTitle("Three Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}