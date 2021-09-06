package CodingTestMemory.BJ.BFSDFS.P2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2206 {

    static int N, M;
    static int[][] board;
    static int[][][] distance;
    static boolean[][][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static class Node {
        int y, x;
        int flag; // 현재 벽을 뚫었다(1) | 안뚫었다(0)
        Node(int y, int x, int flag) {
            this.y = y;
            this.x = x;
            this.flag = flag;
        }
    }
    public static void print() {
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                System.out.printf("%d ", distance[j][i][0]);
            }
            System.out.println();
        }
        System.out.println("----");
    }

    public static void bfs(int y, int x, int flag) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        visited[0][0][0] = true;
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = e.x + dx[i];
                int ny = e.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if(e.flag == 0) { // 아직 벽을 뚫은게 없는경우
                    if(visited[ny][nx][0]) {
                        continue;
                    }
                    if(board[ny][nx] == 1) { // 벽을 만나면 벽을 한번 뚫는다
                        distance[ny][nx][1] = distance[e.y][e.x][0] + 1;
                        visited[ny][nx][1] = true;
                        queue.add(new Node(ny, nx, 1));
                    } else {
                        distance[ny][nx][0] = distance[e.y][e.x][0] + 1;
                        visited[ny][nx][0] = true;
                        queue.add(new Node(ny, nx, 0));
                    }
                } else { // 이미 벽을 한번 뚫은 경우
                    if(visited[ny][nx][1]) {
                        continue;
                    }
                    if(board[ny][nx] == 1) {
                        continue;
                    } else {
                        distance[ny][nx][1] = distance[e.y][e.x][1] + 1;
                        visited[ny][nx][1] = true;
                        queue.add(new Node(ny, nx, 1));
                    }
                }
            }
            //print();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        board = new int[N][M];
        distance = new int[N][M][2];
        visited = new boolean[N][M][2];
        for(int j = 0; j < N; j++) {
            String input = br.readLine();
            for(int i = 0; i < M; i++) {
                board[j][i] = (int)input.charAt(i) - 48;
            }
        }
        bfs(0, 0, 0);
        int a = distance[N - 1][M - 1][0];
        int b = distance[N - 1][M - 1][1];

        if(a == 0 && b == 0) {
            if(N == 1 && M == 1) {
                System.out.println("1");
            } else {
                System.out.println("-1");
            }
        } else if (a == 0) {
            System.out.println(b + 1);
        } else if (b == 0) {
            System.out.println(a + 1);
        } else {
            System.out.println(Math.min(a + 1, b + 1));
        }
    }
}
