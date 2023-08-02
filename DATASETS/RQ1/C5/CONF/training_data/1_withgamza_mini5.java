

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;



public class mini5 {

    public static void makeCalender(int year, int month) {
        int date = 1;
        int day;
        LocalDate firstDate = LocalDate.of(year, month, date);
        day = firstDate.getDayOfWeek().getValue();

        System.out.println(
                month >= 10 ? String.format("[%d년 %d월]", year, month) : String.format("[%d년 %02d월]", year, month));
        System.out.println("일\t월\t화\t수\t목\t금\t토\t");

        
        for (int i = 0; i < day % 7; i++) {
            System.out.print("\t");
        }

        
        for (int i = 1; i <= firstDate.lengthOfMonth(); i++) {
            System.out.printf("%02d\t", date++);
            day++;

            if (day % 7 == 0) { 
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int year;
        int month;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("[달력 출력 프로그램]");
                System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
                year = Integer.parseInt(br.readLine());
                br.close();
                
                if (year < 0) {
                    System.out.println("Wrong Year input. reload..\n");
                    continue;
                }

                System.out.print("달력의 월을 입력해 주세요.(mm): ");
                month = Integer.parseInt(br.readLine());
                br.close();
                
                if (month <= 0 || month > 12) {
                    System.out.println("Wrong Month input. reload..\n");
                    continue;
                }
                break;
            }
        }
        System.out.println();
        makeCalender(year, month);
    }
}
