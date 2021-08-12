package CodingTestMemory.BJ.BFSDFS.P1926;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {
    static class Node {
        int x, y;
        Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static Queue<Node> queue = new LinkedList<>();

    public static int bfs(int y, int x) {
        int cnt = 0;
        queue.add(new Node(y, x));
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            Node r = queue.remove();
            cnt++;
            for(int dir = 0; dir < 4; dir++) {
                int nx = r.x + dx[dir];
                int ny = r.y + dy[dir];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }
                if(visited[ny][nx] || board[ny][nx] == 0) {
                    continue;
                }
                visited[ny][nx] = true;
                queue.add(new Node(ny, nx));
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        int cnt = 0, max_size = 0, tmp;
        board = new int[N][M];
        visited = new boolean[N][M];

        for(int y = 0; y < N; y++) { // 판 채우기
            stk = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++) {
                board[y][x] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if(!visited[y][x] && board[y][x] == 1) {
                    tmp = bfs(y, x);
                    if(max_size < tmp) {
                        max_size = tmp;
                    }
                    cnt++;
                }
            }
        }
        bw.write(String.valueOf(cnt) + "\n" + String.valueOf(max_size));
        bw.flush();
        bw.close();
    }
}
