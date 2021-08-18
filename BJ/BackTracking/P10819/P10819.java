package CodingTestMemory.BJ.BackTracking.P10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10819 {
    static int N, max = 0;
    static int[] nums;
    static int[] arr;
    static boolean[] visited;

    public static void func(int depth) {
        if(depth == N) {
            int tmp = 0;
            for(int i = 1; i < N; i++) {
                tmp += Math.abs((nums[arr[i - 1]] - nums[arr[i]]));
            }
            if(max < tmp) {
                max = tmp;
            }
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                func(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nums = new int[N];
        visited = new boolean[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        func(0);
        System.out.println(max);
    }
}
