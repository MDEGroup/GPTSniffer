


public class 1_Exercise01_09.java {
    public static void main(String[] args) {

        double area = 4.5 * 7.9;
        area = Math.round(area * 100);
        area /= 100;

        System.out.println("The area of a rectangle with a width of 4.5 and a height"
                + " of 7.9 is " + area);
        
        System.out.println("Perimeter is " + (2 * (4.5 + 7.9)));
    }
}
