package CodingTestMemory.BJ.Sliv3.P11727;

import java.util.Scanner;

public class P11727 {
    static long func(int N) {
        long[] arr = new long[1001];
        arr[1] = 1;
        arr[2] = 3;
        if(arr[N] != 0) {
            return arr[N];
        }
        for(int i = 3; i <= N; i++) {
            arr[i] = ((2 * arr[i - 2]) + arr[i - 1]) % 10007;
        }
        return arr[N];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(func(N));
    }
}
