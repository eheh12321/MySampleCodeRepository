package CodingTestMemory.BJ.Silv1.BFSDFS.P7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7576 {
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[][] board;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for(int y = 0; y < N; y++) { // 첫 시작점을 모두 큐에 삽입한다
            for(int x = 0; x < M; x++) {
                if(board[y][x] == 1) {
                    queue.add(new Node(y, x));
                    dist[y][x] = 0;
                }
            }
        }
        while(!queue.isEmpty()) {
            Node r = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = r.x + dx[i];
                int ny = r.y + dy[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if(dist[ny][nx] != -1 || board[ny][nx] == -1) { // 이미 방문을 했거나, 갈수 없는곳이라면
                    continue;
                }
                queue.add(new Node(ny, nx));
                dist[ny][nx] = dist[r.y][r.x] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[N][M];
        dist = new int[N][M];
        int max = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                board[y][x] = sc.nextInt();
                dist[y][x] = -1; // 거리 초기화도 같이 ㅎㅎ
            }
        }
        bfs();
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if(dist[y][x] == -1 && board[y][x] != -1) {
                    System.out.println("-1");
                    return;
                }
                if(max < dist[y][x]) {
                    max = dist[y][x];
                }
            }
        }
        System.out.println(max);
    }
}
