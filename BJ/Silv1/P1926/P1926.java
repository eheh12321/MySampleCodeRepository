package CodingTestMemory.BJ.Silv1.P1926;

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
    static int N, M;
    static Queue<Node> queue = new LinkedList<>();

    public static int bfs(int idx1, int idx2) {
        int size = 0;
        int x, y;
        queue.add(new Node(idx1, idx2));
        visited[idx1][idx2] = true;
        size++;
        while(!queue.isEmpty()) {
            Node r = queue.remove();
            x = r.x;
            y = r.y;
            if(x - 1 >= 0 && board[y][x - 1] == 1 && !visited[y][x - 1]) {
                queue.add(new Node(y, x - 1));
                visited[y][x - 1] = true;
                size++;
            }
            if(x + 1 < M && board[y][x + 1] == 1 && !visited[y][x + 1]) {
                queue.add(new Node(y, x + 1));
                visited[y][x + 1] = true;
                size++;
            }
            if(y + 1 < N && board[y + 1][x] == 1 && !visited[y + 1][x]) {
                queue.add(new Node(y + 1, x));
                visited[y + 1][x] = true;
                size++;
            }
            if(y - 1 >= 0 && board[y - 1][x] == 1 && !visited[y - 1][x]) {
                queue.add(new Node(y - 1, x));
                visited[y - 1][x] = true;
                size++;
            }
        }
        return size;
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
