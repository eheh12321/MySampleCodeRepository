package CodingTestMemory.BJ.BackTracking.P15664;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15664 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] nums;
    static int[] arr;
    static boolean[] visited;

    public static void func(int depth, int idx) throws IOException {
        if(depth == M) {
            for(int e : arr) {
                bw.write(String.valueOf(e) + " ");
            }
            bw.newLine();
            return;
        }
        int prev = -1;
        for(int i = idx; i < N; i++) {
            if(!visited[i] && prev != nums[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                func(depth + 1, i + 1);
                prev = nums[i];
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        nums = new int[N];
        arr = new int[M];
        visited = new boolean[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(nums);
        func(0, 0);
        bw.flush();
        bw.close();
    }
}
