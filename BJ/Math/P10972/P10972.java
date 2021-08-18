package CodingTestMemory.BJ.Math.P10972;

import java.io.*;
import java.util.StringTokenizer;
/*
    <다음 순열> 풀이방법
    (1). 뒤에서부터 탐색 시작. 오름차순이 깨지는 위치 찾기(a)
    (2). 다시 뒤에서부터 탐색하면서 a보다 큰 첫번째 인덱스 확인(b)
    (3). (a)와 (b)를 서로 swap
    (4). (a + 1) 부터 끝까지 오름차순 정렬.
 */
public class P10972 {

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
        int[] arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int i, a = 0;

        // 뒤에서부터 탐색 시작. 오름차순이 깨지는 위치 찾기
        for(i = N - 1; i > 0; i--) {
            if(arr[i] > arr[i - 1]) {
                a = i - 1; // 오름차순이 깨진 지점
                break;
            }
        }

        // 오름차순이 끝까지 유지되었음 -> 가장 마지막에 오는 순열
        if(i == 0) {
            System.out.println("-1");
            System.exit(0);
        }

        // 다시 뒤에서부터 탐색하면서 a보다 큰 첫번째 인덱스를 확인 후 서로 swap
        for(i = N - 1; i > a; i--) {
            if(arr[a] < arr[i]) { // SWAP
                swap(arr, a, i);
                break;
            }
        }

        // a + 1 지점부터 끝까지 오름차순 정렬
        int start = a + 1;
        int end = N - 1;
        while(start < end) {
            swap(arr, start++, end--);
        }
        for(int e : arr) {
            bw.write(String.valueOf(e) + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}