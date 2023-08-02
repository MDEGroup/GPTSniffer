/*
김재윤
 */

import java.util.Scanner;

public class Mini08 {
    static long inCome;            // 소득
    static long rateTax;           // 세율
    static long progressiveTax;    // 누진공제
    static long[] taxArr = {0, 12000000L, 46000000L, 88000000L, 150000000L, 300000000L, 500000000L, 1000000000L, Long.MAX_VALUE};
    static int[] rate = {0, 6, 15, 24, 35, 38, 40, 42, 45};
    static long[] progressive = {0, 0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

    public static void data(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        inCome = sc.nextLong();
        sc.close();
    }
    public static long rateTax(Long inCome) {
        for(int i = 1; i < taxArr.length; i++){
            if(inCome <= taxArr[i]){
                long money = (inCome - taxArr[i - 1]) * rate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n\n",inCome - taxArr[i - 1], rate[i], money);
                rateTax += money;
                break;
            }else{
                long money = (taxArr[i] - taxArr[i - 1]) * rate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n",taxArr[i] - taxArr[i - 1], rate[i], money);
                rateTax += money;
            }
        }
        return rateTax;
    }
    public static long progressiveTax(Long inCome){
        for (int i = 1; i < taxArr.length; i++) {
            if (inCome <= taxArr[i]) {
                progressiveTax = (inCome * rate[i] / 100) - progressive[i];
                break;
            }
        }
        return progressiveTax;
    }
    public static void main(String[] args) {
        data();
        rateTax(inCome);
        progressiveTax(inCome);
        System.out.println("[세율에 의한 세금]:\t\t\t" + rateTax);
        System.out.println("[누진공제 계산에 의한 세금]:\t" + progressiveTax);
    }
}