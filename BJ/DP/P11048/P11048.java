package CodingTestMemory.BJ.DP.P11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11048 {

    static int N, M;
    static int[][] board;
    static int[][] visited;

    public static void print() {
        for(int j = 0; j < N; j++) {
            System.out.println(Arrays.toString(visited[j]));
        }
        System.out.println("-----");
    }
    public static void func() {
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                if(j + 1 < N) { // 남쪽으로 이동
                    visited[j + 1][i] = Math.max(visited[j + 1][i], visited[j][i] + board[j + 1][i]);
                }
                if(i + 1 < M) { // 동쪽으로 이동
                    visited[j][i + 1] = Math.max(visited[j][i + 1], visited[j][i] + board[j][i + 1]);
                }
                if(j + 1 < N && i + 1 < M) { // 동남쪽으로 이동
                    visited[j + 1][i + 1] = Math.max(visited[j + 1][i + 1], visited[j][i] + board[j + 1][i + 1]);
                }
                //print();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        board = new int[N][M];
        visited = new int[N][M];
        for(int j = 0; j < N; j++) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                board[j][i] = Integer.parseInt(stk.nextToken());
            }
        }
        visited[0][0] = board[0][0];
        func();
        System.out.println(visited[N - 1][M - 1]);
    }
}
