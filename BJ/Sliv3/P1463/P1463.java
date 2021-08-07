package CodingTestMemory.BJ.Sliv3.P1463;

import java.io.*;

public class P1463 {
    public static int func(int N) {
        int[] dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        if(dp[N] != 0) {
            return dp[N];
        }
        int min;
        for(int i=4; i<=N; i++) {
            min = dp[i - 1];
            if(i % 2 == 0 && dp[i / 2] < min) {
                min = dp[i / 2];
            }
            if(i % 3 == 0 && dp[i / 3] < min) {
                min = dp[i / 3];
            }
            dp[i] = min + 1;
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        System.out.println(func(N));
    }
}
