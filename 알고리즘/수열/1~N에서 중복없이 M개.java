// * https://www.acmicpc.net/problem/15649
// * https://st-lab.tistory.com/114

import java.util.*;

public class Solution {

    private boolean[] visited;
    private int[] arr;

    // 1부터 N까지의 자연수에서 중복 없이 M개를 고른 수열 출력 (M <= N)
    public void solution(int N, int M) {
        visited = new boolean[N];
        arr = new int[M];
        func(N, M, 0);
    }

    private void func(int N, int M, int depth) {
        if (depth == M) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1; // 1부터 시작하기 위함
                func(N, M, depth +1);
                visited[i] = false;
            }
        }
    }
}
