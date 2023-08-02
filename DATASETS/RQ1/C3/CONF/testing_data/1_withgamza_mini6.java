/* 
박주원 _ joowon99xx@gmail.com 
 * 가상 대선 당선 시뮬레이션 프로그램
 * 조건문 반복문 배열.
 * 후보 순서 및 기수 고정
 * 총 투표수 10,000건
 * 각 투표수의 결과는 4명의 후보들이 동일한 비율로 랜덤하게 발생
 * 임의 번호는 Random 의 nextInt() 사용
 */

import java.util.Random;


public class mini6 {
    // 총 투표수 10,000건
    static int totalCnt = 10000;

    public static void main(String[] args) {
        Random random = new Random();
        int[] candidate = new int[4];
        String[] name = new String[]{"이재명", "윤석열", "심상정", "안철수"};
        // 각 투표수의 결과는 동일한 비율로 랜덤하게 발생
        for (int i = 1; i <= totalCnt; i++) {
            // 나눈값이 : 0 1 2 3 이 나오면 1:1:1:1 이다. 25%확률
            int voteRate = (random.nextInt(4) + 1) % 4;
            candidate[voteRate]++;
            System.out.println();
            System.out.printf("[투표진행율]: %05.02f%c, %d명 투표 => %s\n", ((double) candidate[voteRate] / (double) totalCnt) * 100.0f, '%', (int) candidate[voteRate], name[voteRate]);
            System.out.printf("[기호:1] 이재명: %05.02f%c, (투표수: %d)\n", ((double) candidate[0] / (double) totalCnt) * 100.0f, '%', candidate[0]);
            System.out.printf("[기호:2] 윤석열: %05.02f%c, (투표수: %d)\n", ((double) candidate[1] / (double) totalCnt) * 100.0f, '%', candidate[1]);
            System.out.printf("[기호:3] 심상정: %05.02f%c, (투표수: %d)\n", ((double) candidate[2] / (double) totalCnt) * 100.0f, '%', candidate[2]);
            System.out.printf("[기호:4] 안철수: %05.02f%c, (투표수: %d)\n", ((double) candidate[3] / (double) totalCnt) * 100.0f, '%', candidate[3]);

            if (i == totalCnt) {
                int max = 0;
                for (int j = 0; j < 4; j++) {
                    if (max < candidate[j]) {
                        max = candidate[j];
                    }
                }
                int same = 0;
                for (int j = 0; j < 4; j++) {
                    if (max == candidate[j]) {
                        same++;
                    }
                }

                if (same > 1) {
                    i--;
                }
            }
        }

        int max = 0;
        String vitorier = new String();
        for (int i = 0; i < 4; i++) {
            if (max < candidate[i]) {
                max = candidate[i];
                vitorier = name[i];
            }
        }

        System.out.printf("[투표결과] 당선인: %s\n", vitorier);

    }
}


