


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mini07 {
    public static int[] randomLotto() {
        int[] lotto = new int[6];
        Random random = new Random();

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = random.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lotto);
        return lotto;
    }
    public static int checkLotto(int[] lotto, int[] winLotto){
        int cnt = 0;
        for(int i = 0; i < lotto.length; i++){
            for(int j = 0; j < winLotto.length; j++){
                if(winLotto[j] == lotto[i]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("[로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int lottoCnt = sc.nextInt();
        int[] winLotto = randomLotto();
        int[][] lotto = new int[lottoCnt][6];
        char lottoChar = 'A';
        for(int i = 0; i < lottoCnt; i++){
            lotto[i] = randomLotto();
        }
        for(int i = 0; i < lotto.length; i++){
            System.out.print(lottoChar++ + "\t");
            for(int j = 0; j < 6; j++){
                System.out.printf("%02d",lotto[i][j]);
                if(j < 5){
                    System.out.print(",");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.println("[로또 발표]");
        System.out.print("\t");
        for(int i = 0; i < winLotto.length; i++){
            System.out.printf("%02d",winLotto[i]);
            if(i < winLotto.length - 1){
                System.out.print(",");
            }
        }
        System.out.print("\n\n");
        System.out.println("[내 로또 결과]");
        lottoChar = 'A';
        for(int i = 0; i < lotto.length; i++){
            System.out.print(lottoChar++ + "\t");
            for(int j = 0; j < 6; j++){
                System.out.printf("%02d",lotto[i][j]);
                if(j < 5){
                    System.out.print(",");
                }
            }
            System.out.print(" => "+checkLotto(lotto[i], winLotto)+"개 일치");
            System.out.println();
        }
        sc.close();
    }
}
