package CodingTestMemory.BJ.Sliv3.P2579;

import java.util.Scanner;

public class P2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[10001][2];
        int[] stair = new int[10001];
        for(int i = 1; i <= N; i++) {
            stair[i] = sc.nextInt();
        }
        dp[1][0] = stair[1];
        dp[2][0] = stair[2];
        dp[2][1] = dp[1][0] + stair[2];
        for(int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 2][1], dp[i - 2][0]) + stair[i];
            dp[i][1] = dp[i - 1][0] + stair[i];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
