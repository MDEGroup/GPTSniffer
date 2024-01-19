


import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Date;


public class PrimeNumberGenerator {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Loan());
        list.add(new Date());
        list.add("stringTest");
        list.add(new Circle());
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
