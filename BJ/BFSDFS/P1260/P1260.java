package CodingTestMemory.BJ.BFSDFS.P1260;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1260 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static int[][] graph;

    public static void bfs(int idx) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;
        while(!queue.isEmpty()) {
            int e = queue.remove();
            bw.write(String.valueOf(e) + " ");
            for(int i = 1; i < visited.length; i++) {
                if(!visited[i] && graph[e][i] != 0) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int idx) throws IOException {
       for(int i = 1; i < visited.length; i++) {
           if(visited[i] || graph[idx][i] == 0) {
               continue;
           }
           bw.write(String.valueOf(i) + " ");
           visited[i] = true;
           dfs(i);
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int V = Integer.parseInt(stk.nextToken());
        int a, b;

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited[V] = true;
        bw.write(String.valueOf(V) + " ");
        dfs(V);
        visited = new boolean[N + 1];
        bw.newLine();
        bfs(V);

        bw.flush();
        bw.close();
    }
}
