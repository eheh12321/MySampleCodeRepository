package CodingTestMemory.SWEA.D2.P1204;

import java.util.Scanner;

public class P1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int max, idx, a;
        for(int t=1; t<=T; t++) {
            int[] arr = new int[101];
            a = sc.nextInt(); // 쓰레기값
            max = idx = 0;
            for(int i=0; i<1000; i++) {
                arr[sc.nextInt()] += 1;
            }
            for(int i=0; i<101; i++) {
                if(max <= arr[i]) {
                    max = arr[i];
                    idx = i;
                }
            }
            System.out.printf("#%d %d\n", t, idx);
        }
    }
}
