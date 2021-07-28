package CodingTestMemory.BJ.Sliv3.P9095;

import java.util.Scanner;

public class P9095 {
    static int dp(int n) {
        int[] dp = new int[12];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i=3; i<n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++) {
            int n = sc.nextInt();
            System.out.println(dp(n));
        }
    }
}
