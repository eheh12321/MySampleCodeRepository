package CodingTestMemory.BJ.BFSDFS.P4963;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4963 {

    public static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}; // 8방향 모두 체크!
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1}; // (대각선 포함)

    public static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            for(int i = 0; i < 8; i++) {
                int nx = e.x + dx[i];
                int ny = e.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue; // OutofBounds 체크
                if(visited[ny][nx] || board[ny][nx] == 0) continue; // 방문했거나 갈수 없는곳
                visited[ny][nx] = true;
                queue.add(new Node(ny, nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            M = Integer.parseInt(stk.nextToken());
            N = Integer.parseInt(stk.nextToken());
            if(N == 0 && M == 0) {
                break;
            }
            board = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < N; j++) {
                stk = new StringTokenizer(br.readLine());
                for (int i = 0; i < M; i++) {
                    board[j][i] = Integer.parseInt(stk.nextToken());
                }
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < M; i++) {
                    if (!visited[j][i] && board[j][i] != 0) {
                        bfs(j, i);
                        cnt++;
                    }
                }
            }
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
