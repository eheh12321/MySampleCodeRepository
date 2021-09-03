package CodingTestMemory.BJ.Dijkstra.P5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5972 {

    static final int INF = 999999999;
    static int sum = 0;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int idx;
        int dist;

        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            if(visited[e.idx]) {
                continue;
            }
            visited[e.idx] = true;
            for (Node linkedNode : graph.get(e.idx)) {
                if(e.dist + linkedNode.dist < distance[linkedNode.idx]) {
                    distance[linkedNode.idx] = e.dist + linkedNode.dist;
                    queue.add(new Node(linkedNode.idx, distance[linkedNode.idx]));
                    sum += linkedNode.dist;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        for(int i = 0; i < N; i++) {
            graph.add(new LinkedList<>());
        }
        distance = new int[N];
        visited = new boolean[N];
        Arrays.fill(distance, INF);
        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            graph.get(u - 1).add(new Node(v - 1, w));
            graph.get(v - 1).add(new Node(u - 1, w));
        }
        dijkstra(0);
        for(int e : distance) {
            System.out.printf("%d " , e);
        }
        System.out.println();
        System.out.println(distance[N - 1]);
    }
}
