package CodingTestMemory.BJ.DP.P1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1932 {

    static int N;
    static int[][] board;
    static int[][] visited;

    public static void print() {
        for(int j = 0; j < N; j++) {
            System.out.println(Arrays.toString(visited[j]));
        }
        System.out.println("-----");
    }

    public static int func() {
       visited[0][0] = board[0][0];
       for(int j = 1; j < N; j++) {
           for(int i = 0; i <= j; i++) {
               if(i - 1 >= 0) {
                   visited[j][i] = Math.max(visited[j][i], board[j][i] + visited[j - 1][i - 1]);
               }
               if(i + 1 < N) {
                   visited[j][i] = Math.max(visited[j][i], board[j][i] + visited[j - 1][i]);
               }
           }
           //print();
       }
       int max = 0;
       for(int i = 0; i < N; i++) {
           if(visited[N - 1][i] > max) {
               max = visited[N - 1][i];
           }
       }
       return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new int[N][N];
        for(int j = 0; j < N; j++) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i <= j; i++) {
                board[j][i] = Integer.parseInt(stk.nextToken());
            }
        }
        System.out.println(func());
    }
}
