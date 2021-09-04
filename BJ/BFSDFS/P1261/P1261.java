package CodingTestMemory.BJ.BFSDFS.P1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1261 {

    static final int INF = 999999;
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static class Node implements Comparable<Node> {
        int idx_x;
        int idx_y;
        int dist;

        Node(int idx_x, int idx_y, int dist) {
            this.idx_x = idx_x;
            this.idx_y = idx_y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void dijkstra(int start_x, int start_y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[start_y][start_x] = 0;
        queue.add(new Node(start_x, start_y, 0));
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            if(visited[e.idx_y][e.idx_x]) {
                continue;
            }
            visited[e.idx_y][e.idx_x] = true;
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + e.idx_x;
                int ny = dy[i] + e.idx_y;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue; // OutOfBounds
                }
                if(distance[e.idx_y][e.idx_x] + board[ny][nx] < distance[ny][nx]) {
                    distance[ny][nx] = distance[e.idx_y][e.idx_x] + board[ny][nx];
                    queue.add(new Node(nx, ny, distance[ny][nx]));
                }
            }
            //print();
        }
    }

    public static void print() {
        for(int j = 0; j < M; j++) {
            for(int i = 0; i < N; i++) {
                int val = distance[j][i];
                if(val == INF) {
                    System.out.printf("@ ");
                } else {
                    System.out.printf("%d ", val);
                }
            }
            System.out.println();
        }
        System.out.println("----");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken()); // 세로 - x축
        M = Integer.parseInt(stk.nextToken()); // 가로 - y축
        board = new int[M][N];
        visited = new boolean[M][N];
        distance = new int[M][N];
        for(int j = 0; j < M; j++) {
            String input = br.readLine();
            Arrays.fill(distance[j], INF);
            for(int i = 0; i < N; i++) {
                board[j][i] = (int)input.charAt(i) - 48;
            }
        }
        dijkstra(0, 0);
        System.out.println(distance[M - 1][N - 1]);
    }
}