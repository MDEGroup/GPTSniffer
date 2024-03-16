


public class RandomNumberGenerator {
    public static void main(String[] args) {
        System.out.println("Random number is " + getRandom(12, 13, 47));
    }

    public static int getRandom(int... numbers) {
        int randomInt = (int) (1 + Math.random() * 54);
        for (int num : numbers) {
            if (randomInt == num) {
                return getRandom(numbers);
            }
        }
        return randomInt;

    }
}