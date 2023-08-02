import java.util.Random;

public class RandomCoordinate {
    public static void main(String[] args) {
        int xMin = -50; 
        int xMax = 50; 
        int yMin = -100; 
        int yMax = 100; 
        
        Random rand = new Random();
        int x = rand.nextInt(xMax - xMin + 1) + xMin;
        int y = rand.nextInt(yMax - yMin + 1) + yMin;
        
        System.out.printf("Random coordinate within rectangle: (%d, %d)", x, y);
    }
}