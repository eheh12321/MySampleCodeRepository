package CodingTestMemory.BJ.DP.P2579;

import java.io.*;

public class P2579 {

    static int[][] dp = new int[301][2];
    static int[] nums = new int[301];

    public static int func(int N) {
        dp[1][1] = nums[1];
        dp[2][0] = nums[2]; // 두칸을 뛰었을때 -> 다음번에는 한칸 or 두칸 뛸 수 있다
        dp[2][1] = nums[1] + nums[2]; // 한칸 + 한칸 뛰었을때 -> 다음번에는 두칸 뛰어야함
        for(int i = 3; i <= N; i++) {
            int a = dp[i - 2][0]; // 두칸 - 두칸으로 올라온 케이스
            int b = dp[i - 2][1]; // 한칸 - 두칸으로 올라온 케이스
            int c = dp[i - 1][0]; // 두칸 - 한칸으로 올라온 케이스
            dp[i][0] = Math.max(a, b) + nums[i]; // 한칸 뛰거나 두칸 뛸 수 있다
            dp[i][1] = c + nums[i]; // 다음번에는 반드시 두칸을 뛰어야함.
        }
        return Math.max(dp[N][0], dp[N][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(func(N));
    }
}