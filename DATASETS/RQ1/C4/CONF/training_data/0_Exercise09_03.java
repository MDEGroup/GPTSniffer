import java.util.Date;

public class Main {
  public static void main(String[] args) {
    long[] elapsedTimes = { 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L };
    for (long elapsed : elapsedTimes) {
      Date date = new Date(elapsed);
      System.out.println(date.toString());
    }
  }
}