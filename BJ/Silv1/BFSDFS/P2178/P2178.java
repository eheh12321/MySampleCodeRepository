package CodingTestMemory.BJ.Silv1.BFSDFS.P2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    static class Node {
        int x, y;
        Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void initDist() {
        for(int y = 0; y < dist.length; y++) {
            for(int x = 0; x < dist[y].length; x++) {
                dist[y][x] = -1;
            }
        }
    }

    public static void bfs(int y, int x) {
        dist[y][x] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        while(!queue.isEmpty()) {
            Node r = queue.remove();
            for(int i = 0; i < 4; i++) {
                int nx = r.x + dx[i];
                int ny = r.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) { // OutofBound 체크
                    continue;
                }
                if(board[ny][nx] == 0 || dist[ny][nx] != -1) { // 이미 방문했거나, 갈수없는 곳이라면
                    continue;
                }
                queue.add(new Node(ny, nx));
                dist[ny][nx] = dist[r.y][r.x] + 1;
            }
        }
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        board = new int[N][M];
        dist = new int[N][M];
        initDist();

        for(int y = 0; y < N; y++) { // 데이터 입력부
            for(int x = 0; x < M; x++) {
                board[y][x] = br.read() - 48;
            }
            br.read(); // 개행문자 비우기용
        }

        bfs(0, 0);
    }
}
