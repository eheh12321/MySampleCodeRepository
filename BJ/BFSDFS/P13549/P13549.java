package CodingTestMemory.BJ.BFSDFS.P13549;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13549 {

    static int N, K;
    static int[] board = new int[200001];
    static boolean[] visited = new boolean[200001];

    /*
        주의사항
        - 순간이동을 하는게 시간상 더 유리하다
     */
    public static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;
        while(!queue.isEmpty()) {
            int e = queue.poll();
            if(e == K) {
                System.out.println(board[K]);
                System.exit(0);
            }
            if(e * 2 <= 100000 && !visited[e * 2]) { // 순간이동 케이스를 최우선으로 큐에 넣는다
                for(int i = e * 2; i <= 100000 && !visited[i]; i *= 2) { // "e의 배수" 아님!!
                    visited[i] = true;
                    board[i] = board[e];
                    queue.add(i);
                }
            }
            if(e - 1 >= 0 && !visited[e - 1]) {
                visited[e - 1] = true;
                board[e - 1] = board[e] + 1;
                queue.add(e - 1);
            }
            if(e + 1 <= 100000 && !visited[e + 1]) {
                visited[e + 1] = true;
                board[e + 1] = board[e] + 1;
                queue.add(e + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        bfs(N);
    }
}
