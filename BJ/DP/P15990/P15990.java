package CodingTestMemory.BJ.DP.P15990;

import java.io.*;
import java.util.Arrays;

public class P15990 {

    static long[][] dp = new long[100001][4];

    public static long func(int N) {
        dp[1][1] = 1L; // 1
        dp[2][2] = 1L; // 2
        dp[3][1] = 1L; // 1 + 2
        dp[3][2] = 1L; // 2 + 1
        dp[3][3] = 1L; // 3

        for(int i = 4; i <= N; i++) {
            if(dp[i][1] != 0 || dp[i][2] != 0 || dp[i][3] != 0) {
                continue;
            }
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }
        return (dp[N][1] + dp[N][2] + dp[N][3]) % 1000000009;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(func(N)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
