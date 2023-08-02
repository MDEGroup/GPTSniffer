/* 
박주원 _ joowon99xx@gmail.com 
 * Lottery
 * Scanner 조건문 반복문 배열
 * 1-45개의 숫자 사이의 값 중 6개 맞추면 당첨
 * 여러장 구매 가능
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

/* 1. 당첨 배열 생성
 * 2. 구매 장수 입력받기
 * 3. 구매 장수 만큼 로또 줄 나열
 * 4. 구매 장수 만큼 당첨배열과 비교
 * 5. 
 */

//구매 장수 만큼 당첨배열과 비교

class Lottery {
    // 로또 배열 생성하기
    public int[] setLotto() {
        TreeSet<Integer> setLt = new TreeSet<>();

        for (int i = 0; i < 6; i++) {
            setLt.add((int) (Math.random() * 45 + 1));
        }
        // System.out.println("Set:"+setLt);

        int[] intSetLt = setLt.stream().mapToInt(Integer::intValue).toArray();

        return intSetLt;
    }

    // 구매 장수 만큼 로또 배열 생성
    int[][] ranLotto(int num) {
        // int[] pick = setLotto();
        int[][] pickedNums = new int[num][];
        for (int i = 0; i < num; i++) {
            pickedNums[i] = setLotto();
        }
        return pickedNums;
    }

}

public class mini7 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        char[] title = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
        Lottery lotto = new Lottery();
        int num;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[로또 당첨 프로그램]");
        System.out.print("로또 개수를 입력해 주세요.(1~10): ");
        num = Integer.parseInt(br.readLine());
        br.close();

        int[][] pickedArr = lotto.ranLotto(num); // 뽑기 2차원 배열
        // System.out.println(Arrays.deepToString(pickedArr)); // 뽑기 배열 출력
        for (int i = 0; i < num; i++) {
            System.out.print(title[i] + "\t");
            for (int j = 0; j < pickedArr.length - (pickedArr.length - 1); j++) {
                System.out.println(Arrays.toString(pickedArr[i])); // 뽑기 배열 줄 나눠서 출력
            }

        }
        System.out.println();
        System.out.println("[로또 발표]");
        int[] winnerL = lotto.setLotto(); // 당첨 배열
        System.out.println(Arrays.toString(winnerL)); // 당첨 배열 출력

        System.out.println();
        System.out.println("[내 로또 결과]");
        int[] counts = Arrays.stream(pickedArr)
                .mapToInt(subarr -> (int) Arrays.stream(subarr)
                        .filter(x -> Arrays.stream(winnerL)
                                .anyMatch(y -> y == x))
                        .count())
                .toArray();

        for (int i = 0; i < num; i++) {
            System.out.print(title[i] + "\t");
            for (int j = 0; j < pickedArr.length - (pickedArr.length - 1); j++) {
                System.out.print(Arrays.toString(pickedArr[i]) + " => ");
                for (int j2 = 0; j2 < counts.length - (counts.length - 1); j2++) {
                    System.out.println(counts[i] + "개 일치");
                } // 뽑기 배열 줄 나눠서 출력
            }

        }

    }
}
