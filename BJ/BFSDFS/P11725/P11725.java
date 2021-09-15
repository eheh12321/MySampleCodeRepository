package CodingTestMemory.BJ.BFSDFS.P11725;

import java.io.*;
import java.util.*;

public class P11725 {

    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parents;

    public static void init_graph() {
        for(int i = 0; i
                < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int e = queue.poll();
            for (int adjNode : graph[e]) {
                if(!visited[adjNode]) {
                    parents[adjNode] = e;
                    queue.add(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];
        init_graph(); // 인접그래프 초기화
        for(int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(1);

        for(int i = 2; i <= N; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
