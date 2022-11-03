import java.util.*;

/**
 * [1, 1, 1]
 * [1, 1, 2]
 * [1, 1, 3]
 * [1, 2, 2]
 * [1, 2, 3]
 * [1, 3, 3]
 * [2, 2, 2]
 * [2, 2, 3]
 * [2, 3, 3]
 * [3, 3, 3]
 */
public class Solution {

    private int[] arr;

    // 1부터 N까지의 자연수에서 M개를 고른 수열 (중복가능, 비내림차순) 출력 (M <= N)
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
            arr[depth] = i + 1;
            func(N, M, i, depth + 1);
        }
    }
}
