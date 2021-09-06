package CodingTestMemory.BJ.DP.P11053;

import java.util.Scanner;

public class P11053 {

    static int N;
    static int[] nums;
    static int[] dp;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N + 1];
        dp = new int[N + 1];
        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        func();
        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
