package CodingTestMemory.BJ.DP.P11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {

    static int[] dp = new int[100001];
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(stk.nextToken());
        dp[1] = arr[1];
        for(int i = 2; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            dp[i] = dp[i - 1] + arr[i];
        }

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            System.out.println(dp[b] - dp[a - 1]);
        }
    }
}
