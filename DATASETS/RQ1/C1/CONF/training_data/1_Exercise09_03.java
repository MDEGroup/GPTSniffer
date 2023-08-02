package ch_09;


import java.util.Date;


public class Exercise09_03 {
    private static final long startElapsedTime = 10000;
    private static final long endElapsedTime = 100000000000L;

    public static void main(String[] args) {
        Date date = new Date();
        for (long elapsedTime = startElapsedTime; elapsedTime < endElapsedTime; elapsedTime *= 10) {
            date.setTime(elapsedTime);
            System.out.println(date.toString());
        }

    }
}
