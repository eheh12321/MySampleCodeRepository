// https://www.acmicpc.net/problem/15650

import java.util.*;

/**
 * N = 5 / M = 3
 * [1, 2, 3]
 * [1, 2, 4]
 * [1, 2, 5]
 * [1, 3, 4]
 * [1, 3, 5]
 * [1, 4, 5]
 * [2, 3, 4]
 * [2, 3, 5]
 * [2, 4, 5]
 * [3, 4, 5]
 */
public class Solution {

    // visited[] 배열이 필요없음 (idx가 그 역할을 하기때문)
    private int[] arr;

    // 1부터 N까지의 자연수에서 중복 없이 M개를 고른 수열(오름차순만)출력 (M <= N)
    public void solution(int N, int M) {
        arr = new int[M];
        func(N, M, 0, 0);
    }

    private void func(int N, int M, int idx, int depth) {
        if (depth == M) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = idx; i < N; i++) {
            arr[depth] = i + 1; // 1부터 찍기 위함
            func(N, M, i + 1, depth + 1);
        }
    }
}
