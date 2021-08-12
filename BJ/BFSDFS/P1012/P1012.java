package CodingTestMemory.BJ.BFSDFS.P1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012 {
    static class Node {
        int x, y;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    public static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = e.x + dx[i];
                int ny = e.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if(visited[ny][nx] || graph[ny][nx] == 0) {
                    continue;
                }
                queue.add(new Node(ny, nx));
                visited[ny][nx] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int T = Integer.parseInt(br.readLine());
        int K, a, b, cnt;

        for(int t = 0; t < T; t++) {
            cnt = 0;
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            K = Integer.parseInt(stk.nextToken());
            graph = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < K; i++) {
                stk = new StringTokenizer(br.readLine());
                a = Integer.parseInt(stk.nextToken());
                b = Integer.parseInt(stk.nextToken());
                graph[a][b] = 1;
            }
            for(int j = 0; j < N; j++) {
                for(int i = 0; i < M; i++) { // 시작점 찾고 bfs
                    if(!visited[j][i] && graph[j][i] != 0) {
                        bfs(j, i);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
