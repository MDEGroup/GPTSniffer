

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class nan{
    String[] cards;
    int[] picked = new int[4];
    int pick = 0;
    static final String CORRECT_RESULT = "Correct";
    static final String INCORRECT_RESULT = "Incorrect Result";
    static final String WRONG_NUMBERS = "The Numbers in the expression, don't match the number in the set.";

    private void setCards() {
        cards = new String[52];
        int cardNum = 1;
        for (int i = 0; i < cards.length; i++) {
            String path = "resources/images/card/" + cardNum + ".png";
            cards[i] = path;
            cardNum++;

        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setCards();
        VBox vbox = new VBox();
        HBox cardBox = new HBox();
        HBox toolBarBottom = new HBox(15);
        HBox buttonBarTop = new HBox(10);
        vbox.setFillWidth(true);

        VBox.setMargin(cardBox, new Insets(10, 20, 20, 10));

        Text text = new Text("");
        SimpleStringProperty message = new SimpleStringProperty();
        message.bind(text.textProperty());

        Image i1 = new Image(cards[randomCard()]);
        Image i2 = new Image(cards[randomCard()]);
        Image i3 = new Image(cards[randomCard()]);
        Image i4 = new Image(cards[randomCard()]);

        ImageView card1 = new ImageView(i1);
        card1.setPreserveRatio(true);
        card1.setFitHeight(300);

        ImageView card2 = new ImageView(i2);
        card2.setPreserveRatio(true);
        card2.setFitHeight(300);

        ImageView card3 = new ImageView(i3);
        card3.setPreserveRatio(true);
        card3.setFitHeight(300);

        ImageView card4 = new ImageView(i4);
        card4.setPreserveRatio(true);
        card4.setFitHeight(300);

        TextField inputField = new TextField();
        inputField.setMinWidth(200);

        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(e -> {
            text.setText("");
            inputField.setText("");
            shuffleCards(cardBox);
        });


        Button verifyButton = new Button("Verify");
        verifyButton.setOnAction(event -> {
            String result = verifyExpression(inputField.getText());
            text.setText(result);
        });

        buttonBarTop.getChildren().add(text);
        buttonBarTop.getChildren().add(shuffleButton);
        buttonBarTop.setAlignment(Pos.TOP_RIGHT);
        HBox.setMargin(shuffleButton, new Insets(5, 10, 5, 5));

        Label inputLabel = new Label("Enter an expression: ");

        toolBarBottom.getChildren().add(inputLabel);
        toolBarBottom.getChildren().add(inputField);
        toolBarBottom.getChildren().add(verifyButton);
        toolBarBottom.setAlignment(Pos.CENTER);
        toolBarBottom.setPadding(new Insets(10, 10, 10, 15));

        cardBox.getChildren().addAll(card1, card2, card3, card4);
        vbox.getChildren().add(buttonBarTop);
        vbox.getChildren().add(cardBox);
        vbox.getChildren().add(toolBarBottom);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

    private String verifyExpression(String text) {
        String[] currentCards = new String[4];

        for (int i = 0; i < picked.length; i++) {
            currentCards[i] = cards[picked[i]];
        }
        String[] cardNums = new String[4];
        int i = 0;
        for (String card : currentCards) {
            String[] parts = card.split("/");
            String name = parts[parts.length - 1];
            String cardNum = name.split("\\.")[0];
            cardNums[i] = cardNum;
            i++;
        }
        List<Integer> cardValues = new ArrayList<>();

        for (i = 0; i < cardNums.length; i++) {
            cardValues.add(getNumberValue(cardNums[i]));
        }

        List<Integer> inputNumbers = parseInputNumbers(text);

        for (i = 0; i < inputNumbers.size(); i++) {
            boolean removed = cardValues.remove(inputNumbers.get(i));
            if (!removed) {
                return WRONG_NUMBERS;
            }
        }

        if (!(cardValues.size() == 0)) {
            return WRONG_NUMBERS;
        }

        if (evalExpression(text) == 24) {
            return CORRECT_RESULT;
        }

        return INCORRECT_RESULT;
    }

    private List<Integer> parseInputNumbers(String text) {
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                if (i + 1 < text.length()) {
                    i++;
                    char ch2 = text.charAt(i);
                    if (Character.isDigit(ch2)) {
                        values.add(Integer.parseInt(ch + "" + ch2));
                        continue;
                    }
                }
                values.add(Integer.parseInt(ch + ""));
            }
        }
        return values;
    }

    private void shuffleCards(HBox hBox) {
        pick = 0;
        Image i1 = new Image(cards[randomCard()]);
        Image i2 = new Image(cards[randomCard()]);
        Image i3 = new Image(cards[randomCard()]);
        Image i4 = new Image(cards[randomCard()]);

        ImageView card1 = new ImageView(i1);
        card1.setPreserveRatio(true);
        card1.setFitHeight(300);

        ImageView card2 = new ImageView(i2);
        card2.setPreserveRatio(true);
        card2.setFitHeight(300);

        ImageView card3 = new ImageView(i3);
        card3.setPreserveRatio(true);
        card3.setFitHeight(300);

        ImageView card4 = new ImageView(i4);
        card4.setPreserveRatio(true);
        card4.setFitHeight(300);
        hBox.getChildren().setAll(card1, card2, card3, card4);
    }

    int randomCard() {
        int ran = -1;
        do {
            ran = (int) (Math.random() * 52);
        } while (ran == picked[0] || ran == picked[1] || ran == picked[2] || ran == picked[3]);
        picked[pick++] = ran;
        return ran;
    }

    private int getNumberValue(String card) {
        int cardValue = 0;
        Path p = Paths.get(card);
        String fileName = p.getFileName().toString();
        final int cardNum = Integer.parseInt(fileName);

        
        if (cardNum <= 13) {
            cardValue = cardNum;

            
        } else {
            if (cardNum <= 26) {
                cardValue = reduceToValue(cardNum);

                
            } else if (cardNum <= 39) {
                cardValue = reduceToValue(cardNum);

                
            } else {
                cardValue = reduceToValue(cardNum);
            }
        }
        return cardValue;
    }

    private int reduceToValue(int value) {
        
        while (value > 13) {
            value -= 13;
        }
        return value;
    }

    private static int evalExpression(String exp) {
        
        Stack<Integer> operandStack = new Stack<>();

        
        Stack<Character> operatorStack = new Stack<>();

        
        exp = delimit(exp);

        String[] tokens = exp.split(" ");

        for (String token : tokens) {
            if (token.length() == 0) { 
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));

            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));

            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); 
            } else if (token.trim().charAt(0) == ')') {
                
                while (operatorStack.peek() != '(') {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); 
            } else { 
                
                operandStack.push(new Integer(token));
            }
        }
        
        while (!operatorStack.isEmpty()) {
            processOperator(operandStack, operatorStack);
        }
        
        return operandStack.pop();
    }

    
    private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }

    private static String delimit(String str) {
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '+' || str.charAt(i) == '-'
                    || str.charAt(i) == '/' || str.charAt(i) == '*') {

                res += " " + str.charAt(i) + " ";

            } else {
                res += str.charAt(i);

            }

        }

        return res;
    }
}