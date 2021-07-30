package CodingTestMemory.BJ.Silv4.P1920;

import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] arr;
        long tmp;
        int N = sc.nextInt();
        arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextLong();
        }
        int M = sc.nextInt();
        Arrays.sort(arr);
        for(int i=0; i<M; i++) {
            tmp = sc.nextLong();
            if(Arrays.binarySearch(arr, tmp) >= 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
