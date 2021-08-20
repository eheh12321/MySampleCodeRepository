package CodingTestMemory.BJ.DP.P1149;

import java.io.*;
import java.util.StringTokenizer;

public class P1149 {

    static int[][] dp = new int[1001][3];
    static int[][] arr = new int[1001][3];

    public static int func(int N) {
        dp[0][0] = arr[0][0]; // R
        dp[0][1] = arr[0][1]; // G
        dp[0][2] = arr[0][2]; // B
        for(int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }
        int tmp = Math.min(dp[N][0], dp[N][1]);
        return Math.min(tmp, dp[N][2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        System.out.println(func(N));
    }
}
