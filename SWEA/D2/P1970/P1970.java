package CodingTestMemory.SWEA.D2.P1970;

import java.util.Arrays;
import java.util.Scanner;

public class P1970 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().trim());
        int[] change;
        int num;

        for(int i=0; i<T; i++) {
            num = sc.nextInt();
            change = new int[] {0, 0, 0, 0, 0, 0, 0, 0};

            // 5만원
            while(num >= 50000) {
                num -= 50000;
                change[0] += 1;
            }
            // 1만원
            while(num >= 10000) {
                num -= 10000;
                change[1] += 1;
            }
            // 5천원
            while(num >= 5000) {
                num -= 5000;
                change[2] += 1;
            }
            // 1천원
            while(num >= 1000) {
                num -= 1000;
                change[3] += 1;
            }
            // 5백원
            while(num >= 500) {
                num -= 500;
                change[4] += 1;
            }
            // 1백원
            while(num >= 100) {
                num -= 100;
                change[5] += 1;
            }
            // 50원
            while(num >= 50) {
                num -= 50;
                change[6] += 1;
            }
            // 10원
            change[7] = num / 10;

            System.out.printf("#%d\n", i+1);
            System.out.println(Arrays.toString(change).replace("[", "").replace("]", "").replace(",", ""));
        }
    }
}
