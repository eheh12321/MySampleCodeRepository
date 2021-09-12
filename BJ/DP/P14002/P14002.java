package CodingTestMemory.BJ.DP.P14002;

import java.io.*;
import java.util.StringTokenizer;

public class P14002 {

    static int N;
    static int[] nums;
    static int[] dp;
    static int[] tmp;
    static int max_len, max_idx;

    public static void func() {
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    tmp[i] = j;
                }
            }
            if(dp[i] > max_len) {
                max_len = dp[i];
                max_idx = i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];
        tmp = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        func();

        bw.write(max_len + "\n");
        int idx = max_idx;
        int[] ans = new int[max_len];
        for(int i = max_len - 1; i >= 0; i--) {
            ans[i] = nums[idx];
            idx = tmp[idx];
        }
        for (int e : ans) {
            bw.write(e + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
