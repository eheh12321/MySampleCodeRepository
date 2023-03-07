// 문제 - https://www.acmicpc.net/problem/1260

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, M, V;
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        int[][] graph = new int[N + 1][N + 1]; // 인접 행렬
        int from, to;
        for(int i = 0; i < M; i++) {
            from = sc.nextInt() - 1;
            to = sc.nextInt() - 1;
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        dfs(graph, new boolean[N + 1], V - 1);
        System.out.println();
        bfs(graph, new boolean[N + 1], V - 1);
    }

    private static void bfs(int[][] graph, boolean[] visited, int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        while(!queue.isEmpty()) {
            Integer e = queue.poll();
            System.out.printf("%d ", e + 1);
            for(int i = 0; i < visited.length; i++) {
                if(!visited[i] && graph[e][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int[][] graph, boolean[] visited, int V) {
        System.out.printf("%d ", V + 1);
        visited[V] = true;
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i] && graph[V][i] == 1) {
                visited[i] = true;
                dfs(graph, visited, i);
            }
        }
    }
}
