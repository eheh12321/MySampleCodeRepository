package CodingTestMemory.BJ.DP.P15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15988 {

    static long[] dp = new long[4];

    public static long func(int N) {
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;
        for(int i = 4; i <= N; i++) {
            dp[i % 4] = (dp[(i - 1) % 4] + dp[(i - 2) % 4] + dp[(i - 3) % 4]) % 1000000009;
        }
        return dp[N % 4];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(func(N));
        }
    }
}
