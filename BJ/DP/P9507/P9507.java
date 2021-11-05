package CodingTestMemory.BJ.DP.P9507;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P9507 {

    static long[] dp = new long[68];

    public static long func(int N) {
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }
        return dp[N];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int n;
        for(int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            bw.write(func(n) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
