package CodingTestMemory.자료구조.Graph;

import java.util.LinkedList;

public class weightedDirectedAdjListGraph {
    private class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("From [%d] -> To [%d] (Weight:[%d])", from, to, weight);
        }
    }

    private LinkedList<Edge>[] graph;
    private int size;

    public weightedDirectedAdjListGraph(int size) {
        graph = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new LinkedList<>();
        }
        this.size = size;
    }

    public void addEdge(int from, int to, int weight) {
        if (from < 0 || to < 0 || from >= size || to >= size) {
            return;
        }
        Edge edge = new Edge(from, to, weight);
        graph[from].add(edge);
    }

    public boolean containsEdge(int from, int to) {
        if (from < 0 || to < 0 || from >= size || to >= size) {
            return false;
        }
        LinkedList<Edge> fromList = graph[from];
        for (Edge edge : fromList) {
            if (edge.to == to) {
                return true;
            }
        }
        return false;
    }

    public void removeEdge(int from, int to) {
        if (from < 0 || to < 0 || from >= size || to >= size) {
            return;
        }
        LinkedList<Edge> fromList = graph[from];
        for (int i = 0; i < fromList.size(); i++) {
            if (fromList.get(i).to == to) {
                fromList.remove(i);
                break;
            }
        }
    }

    public void print() {
        for (LinkedList<Edge> list : graph) {
            System.out.println(list);
        }
    }
}
