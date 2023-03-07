// https://www.acmicpc.net/problem/1260
// 인접 리스트 시간 복잡도 - O(V + E), V:노드, E: 간선

import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) {
        int N, M, V;
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>()); // 노드의 개수만큼 초기화
        }
        int from, to;
        for (int i = 0; i < M; i++) {
            from = sc.nextInt() - 1;
            to = sc.nextInt() - 1;
            // 양방향 연결
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        for (int i = 0; i < N; i++) {
            Collections.sort(adjList.get(i)); // 오름차순 정렬
        }
        dfs(new boolean[N + 1], V - 1);
        System.out.println();
        bfs(new boolean[N + 1], V - 1);
    }

    private static void bfs(boolean[] visited, int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        while (!queue.isEmpty()) {
            Integer e = queue.poll();
            System.out.printf("%d ", e + 1);
            for (Integer val : adjList.get(e)) {
                if (!visited[val]) {
                    queue.add(val);
                    visited[val] = true;
                }
            }
        }
    }

    private static void dfs(boolean[] visited, int V) {
        visited[V] = true;
        System.out.printf("%d ", V + 1);
        for (Integer val : adjList.get(V)) {
            if (!visited[val]) {
                dfs(visited, val);
            }
        }
    }
}
