package CodingTestMemory.BJ.DP.P15989;

import java.io.*;

public class P15989 {

    static int[][] dp = new int[10001][4];
    public static int func(int N) {
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i = 4; i <= N; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
        return dp[N][1] + dp[N][2] + dp[N][3];
    }

    public static int func_반복문(int N) {
        int two, three;
        int cnt = 0;
        three = N / 3; // 3이 몇개 들어갈 수 있는지
        while(three >= 0) {
            two = (N - (three * 3)) / 2; // 3 개수 빼고나서 2가 몇개 들어갈 수 있는지
            while(two >= 0) { // 남은 수는 1의 개수
                two--;
                cnt++;
            }
            three--;
        }
        return cnt;
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
