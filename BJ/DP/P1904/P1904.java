package CodingTestMemory.BJ.DP.P1904;

import java.io.*;

public class P1904 {

    static int N;
    static int[] dp = new int[1000001];

    public static int func() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        for(int i = 5; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        bw.write(func() + "\n");
        bw.flush();
        bw.close();
    }
}
