package CodingTestMemory.BJ.BruteForce.P2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {

    static int N, M;
    static int[] nums = new int[10001];

    public static int func() {
        int cnt = 0;
        long sum = 0L;
        for(int i = 0; i < N; i++) {
            if(nums[i] == M) { // 더 볼필요 없음
                cnt++;
                continue;
            }
            sum = nums[i];
            for(int j = i + 1; j < N; j++) {
                sum += nums[j];
                if(sum > M) {
                    break; // M보다 더 크면 더 볼필요 없음
                } else if (sum == M) { // M이어도 더 볼필요 없음
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        int val = func();
        System.out.println(val);
    }
}
