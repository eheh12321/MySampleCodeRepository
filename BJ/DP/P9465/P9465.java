package CodingTestMemory.BJ.DP.P9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9465 {

    static int N;
    static int[][] board;
    static int[][] dp;

    public static int func() {
        dp[1][0] = board[1][0];
        dp[2][0] = board[2][0];
        for(int i = 1; i < N; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]); // 현재 라인에서 스티커를 안떼는 경우
            dp[1][i] = Math.max(dp[0][i - 1] + board[1][i], dp[2][i - 1] + board[1][i]); // 1행 스티커를 떼는 경우
            dp[2][i] = Math.max(dp[0][i - 1] + board[2][i], dp[1][i - 1] + board[2][i]); // 2행 스티커를 떼는 경우
        }
        int ans = Math.max(dp[0][N - 1], dp[1][N - 1]);
        return Math.max(ans, dp[2][N - 1]); // 현재 라인에서 최댓값 케이스를 리턴.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[3][N];
            dp = new int[3][N];
            for(int j = 1; j <= 2; j++) {
                stk = new StringTokenizer(br.readLine());
                for(int i = 0; i < N; i++) {
                    board[j][i] = Integer.parseInt(stk.nextToken());
                }
            }
            System.out.println(func());
        }
    }
}
