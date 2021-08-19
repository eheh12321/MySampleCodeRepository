package CodingTestMemory.BJ.Dijkstra.P1916;

import java.io.*;
import java.util.*;

public class P1916 {

    static final int INF = 999999999;
    static int[] distance;
    static boolean[] visited;
    static List<List<Node>> graph = new LinkedList<>();
    static class Node implements Comparable<Node> {
        int idx;
        int weight;
        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            if(visited[e.idx]) {
                continue; // 방문했던 노드면 더 볼필요 없음
            }
            visited[e.idx] = true; // 현재노드 방문
            for(Node linkedNode : graph.get(e.idx)) {
                int a = e.weight + linkedNode.weight; // 현재 가중치 + 이동 가중치
                int b = distance[linkedNode.idx]; // 현재 저장되어있는 가중치값
                if(a < b) {
                    distance[linkedNode.idx] = a;
                    queue.add(new Node(linkedNode.idx, distance[linkedNode.idx]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) { // 정점의 개수만큼 연결리스트 추가
            graph.add(new LinkedList());
        }
        distance = new int[N]; // 최단거리 정보를 담을 배열
        visited = new boolean[N]; // 방문여부를 저장할 배열
        Arrays.fill(distance, INF); // distance 배열 초기화
        int v1, v2, w;
        for(int i = 0; i < M; i++) { // 데이터 입력
            stk = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(stk.nextToken());
            v2 = Integer.parseInt(stk.nextToken());
            w = Integer.parseInt(stk.nextToken());
            graph.get(v1 - 1).add(new Node(v2 - 1, w));
        }
        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        dijkstra(start - 1);
        bw.write(String.valueOf(distance[end - 1]));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
