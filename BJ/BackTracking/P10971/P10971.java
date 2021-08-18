package CodingTestMemory.BJ.BackTracking.P10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10971 {

    static int N, min = Integer.MAX_VALUE;
    static boolean[] visited; // 방문노드
    static int[] arr;
    static int[][] adjlist; // 인접행렬

    public static void func(int depth) {
        if(depth == N) {
            arr[N] = arr[0]; //
            int add, tmp = 0;
            for(int i = 0; i < N; i++) {
                add = adjlist[arr[i]][arr[i + 1]];
                if(add == 0) { // 갈수 없는 경로인경우 return.
                    return;
                }
                tmp += add;
            }
            if(tmp < min) {
                min = tmp;
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
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        adjlist = new int[N][N];
        arr = new int[N + 1];
        visited = new boolean[N];
        for(int j = 0; j < N; j++) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                adjlist[j][i] = Integer.parseInt(stk.nextToken());
            }
        }
        func(0);
        System.out.println(min);
    }
}
