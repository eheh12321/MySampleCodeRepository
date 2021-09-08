package CodingTestMemory.BJ.DP.P1912;

import java.io.*;
import java.util.StringTokenizer;

public class P1912 {

    static int N;
    static int[] nums;

    public static int func() {
        int max = nums[0], sum = 0;
        for(int i = 0; i < N; i++) {
            sum += nums[i];
            if(sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        bw.write(String.valueOf(func()));
        bw.flush();
        bw.close();
    }
}
