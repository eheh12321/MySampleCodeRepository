package CodingTestMemory.BJ.BruteForce.P12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {

    static int N, K;
    static int[][] dp;
    static int[] weight;
    static int[] value;

    public static int func() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }

            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        dp = new int[N + 1][K + 1];
        weight = new int[N + 1];
        value = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(stk.nextToken());
            value[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(func());
    }
}
