package CodingTestMemory.BJ.DP.P11722;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11722 {

    static int N;
    static int[] nums;
    static int[] dp = new int[1001];

    public static void func() {
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = N - 1; i >= 0; i--) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        func();

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
