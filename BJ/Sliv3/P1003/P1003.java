package CodingTestMemory.BJ.Sliv3.P1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1003 {
    static int[][] fibo(int n) {
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        if(n == 0) {
            return dp;
        }
        if (n == 1) {
            return dp;
        }
        for(int i=2; i<=n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        return dp;
    }
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = fibo(n);
            bw.write(dp[n][0] + " " + dp[n][1] + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
