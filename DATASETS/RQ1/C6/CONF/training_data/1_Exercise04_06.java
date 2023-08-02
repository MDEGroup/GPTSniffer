

import java.util.*;


public class RandomTriangleAngles{
    public static void main(String[] args) {
        double radius = 40;
        
        
        double randomAngle = 0.5 + Math.random() * 361;
        System.out.println(randomAngle);
        double angleRadians = Math.toRadians(randomAngle);
        
        double x1 = radius * Math.cos(angleRadians);
        double y1 = radius * Math.sin(angleRadians);
        System.out.println("x = " + x1 + ", " + "y = " + y1);

        
        double randomAngle2 = 0.5 + Math.random() * 361;
        System.out.println(randomAngle2);
        double angleRadians2 = Math.toRadians(randomAngle2);

        double x2 = radius * Math.cos(angleRadians2);
        double y2 = radius * Math.sin(angleRadians2);
        System.out.println("x = " + x2 + ", " + "y = " + y2);

        
        double randomAngle3 = 0.5 + Math.random() * 361;
        System.out.println(randomAngle3);
        double angleRadians3 = Math.toRadians(randomAngle3);

        double x3 = radius * Math.cos(angleRadians3);
        double y3 = radius * Math.sin(angleRadians3);
        System.out.println("x = " + x3 + ", " + "y = " + y3);

        
        double a = Math.sqrt((x2 - x3) * (x2 - x3)
                + (y2 - y3) * (y2 - y3));
        double b = Math.sqrt((x1 - x3) * (x1 - x3)
                + (y1 - y3) * (y1 - y3));
        double c = Math.sqrt((x1 - x2) * (x1 - x2)
                + (y1 - y2) * (y1 - y2));

        
        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c)
                / (-2 * b * c)));
        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c)
                / (-2 * a * c)));
        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a)
                / (-2 * a * b)));

        
        System.out.println("The three angles are " +
                Math.round(A * 100) / 100.0 + " " + Math.round(B * 100) / 100.0 + " " +
                Math.round(C * 100) / 100.0);

    }


}