package CodingTestMemory.자료구조.Graph;

import java.util.Arrays;

public class AdjMatrix {
    private boolean[][] graph;
    private int size;

    public AdjMatrix(int size) {
        this.graph = new boolean[size][size];
        this.size = size;
    }

    public void addEdge(int from, int to) {
        if(from < 0 || to < 0 || from >= size || to >= size) {
            return;
        }
        graph[from][to] = true;
        graph[to][from] = true;
    }

    public boolean containsEdge(int from, int to) {
        if(from < 0 || to < 0 || from >= size || to >= size) {
            return false;
        }
        return graph[from][to];
    }

    public void removeEdge(int from, int to) {
        if(from < 0 || to < 0 || from >= size || to >= size) {
            return;
        }
        graph[from][to] = false;
        graph[to][from] = false;
    }

    public void print() {
        for (boolean[] arr : graph) {
            System.out.println(Arrays.toString(arr));
        }
    }
}