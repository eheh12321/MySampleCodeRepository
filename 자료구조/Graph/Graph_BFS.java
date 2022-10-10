package CodingTestMemory.자료구조.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFS {

    public static void bfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int w = queue.poll();
            System.out.print(w + " ");

            for (int e : adjList[w]) {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                }
            }
        }
    }
}
