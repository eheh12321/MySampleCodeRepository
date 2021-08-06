package CodingTestMemory.BJ.Sliv3.P11726;

import java.util.Scanner;

public class P11726 {
    public static long func(int N) {
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        if(dp[N] != 0) {
            return dp[N];
        }
        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]);
            dp[i] %= 10007;
        }
        return dp[N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(func(N));
    }
}
