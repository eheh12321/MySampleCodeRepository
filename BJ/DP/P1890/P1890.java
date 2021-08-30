package CodingTestMemory.BJ.DP.P1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1890 {

    static int N;
    static int[][] board;
    static long[][] visited;

    public static void print() {
        System.out.println("------");
        for(int j = 0; j < N; j++) {
            System.out.println(Arrays.toString(visited[j]));
        }
    }

    public static void func() {
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < N; i++) {
                if(visited[j][i] != 0 && board[j][i] != 0) {
                    int val = board[j][i];
                    if (val + i < N) { // 오른쪽으로 점프가 가능한 경우
                        if(visited[j][val + i] == 0) {
                            visited[j][val + i] = visited[j][i];
                        } else {
                            visited[j][val + i] = visited[j][val + i] + visited[j][i];
                        }
                    }
                    if (val + j < N) { // 아래로 점프가 가능한 경우
                        if(visited[val + j][i] == 0) {
                            visited[val + j][i] = visited[j][i];
                        } else {
                            visited[val + j][i] = visited[val + j][i] + visited[j][i];
                        }
                    }
                }
                //print();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new long[N][N];
        for(int j = 0; j < N; j++) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                board[j][i] = Integer.parseInt(stk.nextToken());
            }
        }
        visited[0][0] = 1;
        func();
        System.out.println(visited[N - 1][N - 1]);
    }
}
