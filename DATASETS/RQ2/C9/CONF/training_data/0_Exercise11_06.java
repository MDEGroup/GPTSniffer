import java.util.ArrayList;
import java.util.Date;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        
        Loan loan = new Loan(1000, 0.05, 5);
        Date date = new Date();
        String str = "Hello, world!";
        Circle circle = new Circle(2.0);
        
        list.add(loan);
        list.add(date);
        list.add(str);
        list.add(circle);
        
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
