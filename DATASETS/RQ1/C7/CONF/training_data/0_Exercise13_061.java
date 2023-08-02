public class TestComparableCircle {
    
    public static void main(String[] args) {
        ComparableCircle circle1 = new ComparableCircle(5);
        ComparableCircle circle2 = new ComparableCircle(3);
        
        if (circle1.compareTo(circle2) > 0) {
            System.out.println("Circle 1 has a larger area than Circle 2");
        } else if (circle1.compareTo(circle2) < 0) {
            System.out.println("Circle 2 has a larger area than Circle 1");
        } else {
            System.out.println("Circle 1 and Circle 2 have the same area");
        }
    }
    
}
