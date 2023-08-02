import java.util.*;

public class BresenhamLineAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the coordinates of the starting point: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        
        System.out.println("Enter the coordinates of the ending point: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;
        
        while (x1 != x2 || y1 != y2) {
            System.out.println("(" + x1 + ", " + y1 + ")");
            int e2 = 2 * err;
            
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
        
        System.out.println("(" + x2 + ", " + y2 + ")");
    }
}

