package CodingTestMemory.BJ.Silv1.BFSDFS.P4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P4179 {
    static class Node {
        int x, y;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int R, C;
    static char[][] board;
    static int[][] dist_fire;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> queue = new LinkedList<>();
    static Node fire;
    static Node jihoon;

    public static void bfs(int y, int x) {
        queue.add(new Node(y, x));
        while (!queue.isEmpty()) {
            Node e = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = e.x + dx[i];
                int ny = e.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
                    continue;
                }
                if (dist[ny][nx] != -1 || board[ny][nx] == '#') {
                    continue; // 이미 방문했거나 / 갈수 없거나 / 불이 이미 도착했을때
                }
                if(dist_fire[ny][nx] != -1 && dist[e.y][e.x] + 1 >= dist_fire[ny][nx]) {
                    continue;
                }
                dist[ny][nx] = dist[e.y][e.x] + 1;
                queue.add(new Node(ny, nx));
            }
        }
    }

    public static void bfs_fire() {
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = e.x + dx[i];
                int ny = e.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
                    continue;
                }
                if (dist_fire[ny][nx] != -1 || board[ny][nx] == '#') {
                    continue;
                }
                dist_fire[ny][nx] = dist_fire[e.y][e.x] + 1;
                queue.add(new Node(ny, nx));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        board = new char[R][C];
        dist = new int[R][C];
        dist_fire = new int[R][C];

        for (int y = 0; y < R; y++) {
            board[y] = br.readLine().toCharArray(); // 데이터 입력
            for (int x = 0; x < C; x++) { // dist 배열 초기화
                dist[y][x] = -1;
                dist_fire[y][x] = -1;
            }
        }
        for (int y = 0; y < R; y++) { // 시작점 위치 찾기
            for (int x = 0; x < C; x++) {
                if (board[y][x] == 'F') {
                    queue.add(new Node(y, x));
                    dist_fire[y][x] = 1;
                }
                if (board[y][x] == 'J') {
                    jihoon = new Node(y, x);
                    dist[y][x] = 1;
                }
            }
        }
        bfs_fire();
        bfs(jihoon.y, jihoon.x);
        int min = 99999;
        for (int y = 1; y < R - 1; y++) {
            if (board[y][0] != '#') {
                if (dist[y][0] < min && dist[y][0] != -1) {
                    min = dist[y][0];
                }
            }
            if (board[y][C - 1] != '#') {
                if (dist[y][C - 1] < min && dist[y][C - 1] != -1) {
                    min = dist[y][C - 1];
                }
            }
        }
        for (int x = 0; x < C; x++) { // 최소 탈출지점 탐색
            if (dist[0][x] < min && dist[0][x] != -1) {
                min = dist[0][x];
            }
            if (dist[R - 1][x] < min && dist[R - 1][x] != -1) {
                min = dist[R - 1][x];
            }
        }
        if(min == 99999) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(min);
        }
    }
}
