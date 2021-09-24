package CodingTestMemory.BJ.DP.P9184;

import java.io.*;
import java.util.StringTokenizer;

public class P9184 {

    public static int[][][] dp = new int[21][21][21];

    public static int func(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return func(20, 20, 20);
        }
        if(dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            return dp[a][b][c] = func(a, b, c - 1) + func(a, b - 1, c - 1) - func(a, b - 1, c);
        }
        else {
            return dp[a][b][c] = func(a - 1, b, c) + func(a - 1, b - 1, c) + func(a - 1, b, c - 1) - func(a - 1, b - 1, c - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        while(true) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            if(a == -1 && b == -1 && c == -1) {
                break;
            }
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + func(a, b, c) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
