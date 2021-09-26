package CodingTestMemory.BJ.DP.P9461;

import java.io.*;

public class P9461 {

    static int N;
    static long[] dp = new long[101];

    public static long func() {
        dp[1] = 1l;
        dp[2] = 1l;
        dp[3] = 1l;
        for(int i = 4; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            bw.write(func() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
