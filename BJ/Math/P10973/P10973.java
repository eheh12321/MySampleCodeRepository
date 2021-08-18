package CodingTestMemory.BJ.Math.P10973;

import java.io.*;
import java.util.StringTokenizer;

/*
    1. 내림차순이 깨지는 위치 찾기(a)
    2. (a)보다 더 작은 인덱스 찾고 서로 swap
    3. (a + 1)부터 끝까지 내림차순 정렬
 */
public class P10973 {

    static int[] nums;

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        // 내림차순이 깨지는 위치 찾기
        int i, a = 0;
        for(i = N - 1; i > 0; i--) {
            if(nums[i] < nums[i - 1]) {
                a = i - 1;
                break; // break 빼먹지 말기
            }
        }
        if(i == 0) {
            System.out.println("-1");
            System.exit(0);
        }
        // a보다 더 작은 인덱스 찾고 swap
        for(i = N - 1; i > a; i--) {
            if(nums[i] < nums[a]) {
                swap(nums, a, i);
                break; // break 빼먹지 말기
            }
        }
        // a + 1 부터 끝까지 내림차순 정렬
        int start = a + 1;
        int end = N - 1;
        while(start < end) {
            swap(nums, start++, end--);
        }
        // 출력
        for(int e : nums) {
            bw.write(String.valueOf(e) + " ");
        }
        bw.flush();
        bw.close();
    }
}
