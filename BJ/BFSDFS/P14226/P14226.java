package CodingTestMemory.BJ.BFSDFS.P14226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14226 {

    static int S;
    static boolean[][] visited = new boolean[2001][2001]; // [화면][클립보드]

    public static class Node {
        int screen; // 화면에 있는 이모티콘 개수
        int cb; // 클립보드에 복사된 이모티콘 개수
        int time; // 현재 소요시간
        Node(int screen, int cb, int time) {
            this.screen = screen;
            this.cb = cb;
            this.time = time;
        }
    }

    public static void bfs(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0, 0));
        visited[n][0] = true;
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            if(e.screen == S) {
                System.out.println(e.time);
                System.exit(0);
            }
            // 1. 클립보드에 현재 이모티콘 개수 저장
            if(!visited[e.screen][e.screen]) {
                visited[e.screen][e.screen] = true;
                queue.add(new Node(e.screen, e.screen, e.time + 1));
            }

            // 2. 이모티콘 붙여넣기
            if(e.screen + e.cb <= 1000 && !visited[e.screen + e.cb][e.cb]) {
                queue.add(new Node(e.screen + e.cb, e.cb, e.time + 1));
                visited[e.screen + e.cb][e.cb] = true;
            }

            // 3. 화면에서 이모티콘 하나 삭제
            if(e.screen - 1 > 0 && !visited[e.screen - 1][e.cb]) {
                queue.add(new Node(e.screen - 1, e.cb, e.time + 1));
                visited[e.screen - 1][e.cb] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        bfs(1);
    }
}
