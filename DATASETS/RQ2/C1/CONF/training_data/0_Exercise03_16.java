import java.util.Random;

public class RandomCoordinate {
    public static void main(String[] args) {
        int xMin = -50; // left edge of rectangle
        int xMax = 50; // right edge of rectangle
        int yMin = -100; // bottom edge of rectangle
        int yMax = 100; // top edge of rectangle
        
        Random rand = new Random();
        int x = rand.nextInt(xMax - xMin + 1) + xMin;
        int y = rand.nextInt(yMax - yMin + 1) + yMin;
        
        System.out.printf("Random coordinate within rectangle: (%d, %d)", x, y);
    }
}