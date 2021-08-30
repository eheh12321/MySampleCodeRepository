package CodingTestMemory.BJ.BackTracking.NandM.P15666;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15666 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] nums;
    static int[] arr;

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
            if(prev != nums[i]) {
                arr[depth] = nums[i];
                func(depth + 1, i);
                prev = nums[i];
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
