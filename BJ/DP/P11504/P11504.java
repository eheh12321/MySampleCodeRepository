package CodingTestMemory.BJ.DP.P11504;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11504 {

    static int N;
    static int[] nums = new int[1001];
    static int[] dp_r = new int[1001];
    static int[] dp_l = new int[1001];
    static int[] dp_sum = new int[1001];

    // LIS(Increasing) 구하기
    public static void LIS() {
        for(int i = 0; i < N; i++) {
            dp_r[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp_r[i] = Math.max(dp_r[j] + 1, dp_r[i]);
                }
            }
        }
    }

    // LDS(Decreasing) 구하기
    public static void LDS() {
        for(int i = N - 1; i >= 0; i--) {
            dp_l[i] = 1;
            for(int j = N - 1; j > i; j--) {
                if(nums[i] > nums[j]) {
                    dp_l[i] = Math.max(dp_l[j] + 1, dp_l[i]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for (int i = 0; i < N; i++) {
            dp_sum[i] = dp_l[i] + dp_r[i] - 1;
            max = Math.max(max, dp_sum[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
