/* 
박주원 _ joowon99xx@gmail.com 
 * Scanner, 조건문 및 반복문을 활용한 달력 만들기.
 * 년도, 월 입력 값을 받음.
 * LocalDate / Calendar / Date Class 활용.
 */

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

        // 1일 전까지의 공백 생성
        for (int i = 0; i < day % 7; i++) {
            System.out.print("\t");
        }

        // 달력 일 출력
        for (int i = 1; i <= firstDate.lengthOfMonth(); i++) {
            System.out.printf("%02d\t", date++);
            day++;

            if (day % 7 == 0) { // 다음 주로 줄 바꿈
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
                // 년도 음수 입력 방지
                if (year < 0) {
                    System.out.println("Wrong Year input. reload..\n");
                    continue;
                }

                System.out.print("달력의 월을 입력해 주세요.(mm): ");
                month = Integer.parseInt(br.readLine());
                br.close();
                // 월 1~12 외 입력 방지
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
