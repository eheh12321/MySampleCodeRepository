package CodingTestMemory.BJ.BackTracking.P9663;

import java.io.*;
import java.util.Stack;

public class P9663 {
    static int[][] visited;
    static Stack<Integer> queen = new Stack<>();
    static int N, cnt = 0;

    public static void func(int y) {
        if(y >= N) { // base condition
            if(queen.size() == N) {
                cnt++;
            }
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[y][i] == 0) {
                visited[y][i] += 1;
                queen.add(0);
                for(int t = 1; y + t < N; t++) {
                    visited[y + t][i] += 1;
                    if(i + t < N) {
                        visited[y + t][i + t] += 1;
                    }
                    if(i - t >= 0) {
                        visited[y + t][i - t] += 1;
                    }
                }
                func(y + 1);
                visited[y][i] -= 1;
                for(int t = 1; y + t < N; t++) {
                    visited[y + t][i] -= 1;
                    if(i + t < N) {
                        visited[y + t][i + t] -= 1;
                    }
                    if(i - t >= 0) {
                        visited[y + t][i - t] -= 1;
                    }
                }
                queen.pop();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N][N];
        func(0);
        System.out.println(cnt);
    }
}
