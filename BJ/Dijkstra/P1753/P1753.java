package CodingTestMemory.BJ.Dijkstra.P1753;

import java.io.*;
import java.util.*;

public class P1753 {

    static final int INF = 99999999;
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
        public int compareTo(Node o) { // 우선순위큐를 사용할때 정렬기준 -> 거리를 기준으로 오름차순
            return this.dist - o.dist;
        }
    }

    static void dijkstra(int start) {
        /*
            우선순위큐를 사용하는 이유
            - 현재 노드에서 가장 가까운 노드를 찾는 시간을 간소화하기 위해서!
            - 최단거리를 기준으로 오름차순 정렬하여 저장됨.
         */
        PriorityQueue<Node> queue = new PriorityQueue<>(); // 우선순위 큐
        distance[start] = 0;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            if(visited[e.idx]) { // 현재 노드를 이미 방문했다면 더 볼필요 없다. (그리디 알고리즘)
                continue;
            }
            visited[e.idx] = true; // 현재 노드 방문
            for(Node linkedNode : graph.get(e.idx)) {
                // 현재 노드를 거쳐서 다음 노드로 이동하는 값 < 현재까지 distance[]에 저장되있는 최단거리값
                if(e.dist + linkedNode.dist < distance[linkedNode.idx]) {
                    distance[linkedNode.idx] = e.dist + linkedNode.dist;
                    queue.add(new Node(linkedNode.idx, distance[linkedNode.idx])); // 갱신된 노드는 우선순위큐에 들어간다
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(stk.nextToken()); // 정점의 개수
        int E = Integer.parseInt(stk.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작점
        for(int i = 0; i < V; i++) {
            graph.add(new LinkedList<>()); // V개의 정점에 대해 연결리스트 생성
        }
        distance = new int[V];
        visited = new boolean[V];
        Arrays.fill(distance, INF); // INF로 배열 초기화
        int u, v, w;
        for(int i = 0; i < E; i++) { // 간선 데이터 입력
            stk = new StringTokenizer(br.readLine());
            u = Integer.parseInt(stk.nextToken()); // u 정점에서 출발해
            v = Integer.parseInt(stk.nextToken()); // v 정점으로 가는 간선의
            w = Integer.parseInt(stk.nextToken()); // 가중치가 w.
            graph.get(u - 1).add(new Node(v - 1, w));
        }
        dijkstra(K - 1);
        for(int i = 0; i < V; i++) {
            if(distance[i] == INF) {
                bw.write("INF");
                bw.newLine();
                continue;
            }
            bw.write(String.valueOf(distance[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

