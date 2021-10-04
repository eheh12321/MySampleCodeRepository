package CodingTestMemory.BJ.Other.P18870;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        int[] tmp = nums.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int j = 0;
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], j++);
            }
        }
        for(int i = 0; i < N; i++) {
            bw.write(map.get(tmp[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
