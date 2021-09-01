package CodingTestMemory.BJ.DP.P16194;

import java.util.Arrays;
import java.util.Scanner;

public class P16194 {

    static int N;
    static int[] price;
    static int[] dp;

    public static int func(int cnt) {
        dp[1] = price[1];
        for(int i = 2; i <= N; i++) {
            dp[i] = price[i];
            for(int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + price[i - j]);
            }
        }
        return dp[cnt];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        price = new int[N + 1];
        dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            price[i] = sc.nextInt();
        }
        Arrays.fill(dp, 10000);
        System.out.println(func(N));
    }
}
