package CodingTestMemory.BJ.DP.P11660;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11660 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][N];
        dp = new int[N][N];
        for(int j = 0; j < N; j++) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                map[j][i] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            dp[0][i] = map[0][i];
            for(int j = 1; j < N; j++) {
                dp[j][i] = dp[j - 1][i] + map[j][i];
            }
        }

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken()) - 1; // 행(y)
            int y1 = Integer.parseInt(stk.nextToken()) - 1; // 열(x)
            int x2 = Integer.parseInt(stk.nextToken()) - 1;
            int y2 = Integer.parseInt(stk.nextToken()) - 1;

            if(x1 == x2 && y1 == y2) {
                bw.write(map[x1][y1] + "\n");
                continue;
            }

            int sum = 0;
            for(int k = y1; k <= y2; k++) {
                if(x1 == 0) {
                    sum += dp[x2][k];
                } else {
                    sum += (dp[x2][k] - dp[x1 - 1][k]);
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
