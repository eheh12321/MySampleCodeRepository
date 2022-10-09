package CodingTestMemory.자료구조.Graph.AdjList.Weight;

import java.util.ArrayList;
import java.util.Scanner;

class Edge<W, V> {
    private W weight;
    private V v;

    public void setEdge(W weight, V v) {
        this.weight = weight;
        this.v = v;
    }
}

public class MainClass { // 가중치가 존재하는 인접리스트
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Edge<Integer, Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new Edge<>());
        }
        for(int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int weight = sc.nextInt();

            graph.get(n1).setEdge(n2, weight);
            graph.get(n2).setEdge(n1, weight);
        }
    }
}
