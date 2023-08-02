

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;





class Lottery {
    
    public int[] setLotto() {
        TreeSet<Integer> setLt = new TreeSet<>();

        for (int i = 0; i < 6; i++) {
            setLt.add((int) (Math.random() * 45 + 1));
        }
        

        int[] intSetLt = setLt.stream().mapToInt(Integer::intValue).toArray();

        return intSetLt;
    }

    
    int[][] ranLotto(int num) {
        
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

        int[][] pickedArr = lotto.ranLotto(num); 
        
        for (int i = 0; i < num; i++) {
            System.out.print(title[i] + "\t");
            for (int j = 0; j < pickedArr.length - (pickedArr.length - 1); j++) {
                System.out.println(Arrays.toString(pickedArr[i])); 
            }

        }
        System.out.println();
        System.out.println("[로또 발표]");
        int[] winnerL = lotto.setLotto(); 
        System.out.println(Arrays.toString(winnerL));  출력

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
                } 
            }

        }

    }
}
