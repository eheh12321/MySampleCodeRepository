package CodingTestMemory.BJ.DP.P2156;

import java.util.Arrays;
import java.util.Scanner;

public class P2156 {

    static int N;
    static int[][] dp; // 0: 안마심 / 1: 1연속 마심 / 2: 2연속 마심
    static int[] wine;

    public static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("----");
    }

    public static int func() {
        dp[0][1] = wine[0];
        for(int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + wine[i];
            dp[i][2] = dp[i - 1][1] + wine[i];
            //print();
        }
        int ans = Math.max(dp[N - 1][0], dp[N - 1][1]);
        return Math.max(ans, dp[N - 1][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N][3];
        wine = new int[N];
        for(int i = 0; i < N; i++) {
            wine[i] = sc.nextInt();
        }
        System.out.println(func());
    }
}
