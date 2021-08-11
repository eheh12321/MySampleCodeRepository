package CodingTestMemory.BJ.Silv1.BFSDFS.P1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697 {
    static int[] visited = new int[200000];
    static int K;
    public static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        while(!queue.isEmpty()) {
            int e = queue.poll();
            if(e - 1 >= 0 && visited[e - 1] == 0) { // x - 1 인 경우
                visited[e - 1] = visited[e] + 1;
                queue.add(e - 1);
            }
            if(e + 1 < 200000 && visited[e + 1] == 0) { // x + 1 인 경우
                visited[e + 1] = visited[e] + 1;
                queue.add(e + 1);
            }
            if(2 * e < 200000 && visited[2 * e] == 0) { // 2 * x 인 경우
                visited[2 * e] = visited[e] + 1;
                queue.add(2 * e);
            }
            if(visited[K] != 0) {
                System.out.println(visited[K] - 1);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();
        visited[N] = 1;
        bfs(N);
    }
}
