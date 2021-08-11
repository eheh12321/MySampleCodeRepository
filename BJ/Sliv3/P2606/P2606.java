package CodingTestMemory.BJ.Sliv3.P2606;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {
    static int[][] board;
    static boolean[] visited;
    static int N;

    public static int bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        visited[idx] = true;
        queue.add(idx);
        int cnt = 0;
        while(!queue.isEmpty()) {
            int e = queue.poll();
            for(int i = 1; i <= N; i++) {
                if(board[e][i] != 0 && !visited[i]) {
                    queue.add(i);
                    cnt++;
                    visited[i] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int a, b;
        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            board[a][b] = 1;
            board[b][a] = 1;
        }

        bw.write(String.valueOf(bfs(1)));
        bw.close();
    }
}
