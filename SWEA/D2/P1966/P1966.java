package CodingTestMemory.SWEA.D2.P1966;

import java.util.Arrays;
import java.util.Scanner;

public class P1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr;
        int len;
        for(int t=0; t<T; t++) {
            len = sc.nextInt();
            arr = new int[len];
            for(int i=0; i<len; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.printf("#%d ", t+1);
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr).replace("[", "").replace("]", "").replace(",", ""));
        }
    }
}
