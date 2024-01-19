import java.util.ArrayList;

public class SquareNumbersFinder {

    public static void main(String[] args) {

        long currentNumber = 1;
        int foundSquares = 0;

        ArrayList<Long> squareNumbers = new ArrayList<>();

        while (foundSquares < 10) {
            long square = currentNumber * currentNumber;

            if (square > Long.MAX_VALUE) {
                squareNumbers.add(square);
                foundSquares++;
            }

            currentNumber++; // Increment current number
        }

        System.out.println("The first ten square numbers greater than Long.MAX_VALUE are:");
        for (long square : squareNumbers) {
            System.out.println(square);
        }
    }
}