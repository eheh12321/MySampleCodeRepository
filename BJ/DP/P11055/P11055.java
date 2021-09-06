package CodingTestMemory.BJ.DP.P11055;

import java.util.Scanner;

public class P11055 {

    static int N;
    static int[] nums = new int[1001];
    static int[] dp = new int[1001];

    public static void func() {

        for(int i = 0; i < N; i++) {
            int idx = nums[i];
            dp[idx] = nums[i];
            for(int j = 0; j < idx; j++) {
                if(dp[j] == 0) {
                    continue;
                }
                dp[idx] = Math.max(dp[idx], dp[j] + nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        func();
        int max = 0;
        for(int e : dp) {
            max = Math.max(max, e);
        }
        System.out.println(max);
    }
}
