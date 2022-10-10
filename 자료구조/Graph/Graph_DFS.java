package CodingTestMemory.자료구조.Graph;

import java.util.LinkedList;
import java.util.Stack;

public class Graph_DFS {

    public static void dfs_recursive(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int w : adjList[v]) {
            if (!visited[w]) {
                dfs_recursive(w, adjList, visited);
            }
        }
    }

    public static void dfs_stack(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        visited[v] = true;
        stack.push(v);

        while (!stack.isEmpty()) {
            int w = stack.pop();
            System.out.print(w + " ");

            for (int e : adjList[w]) {
                if (!visited[e]) {
                    visited[e] = true;
                    stack.push(e);
                }
            }
        }
    }
}
