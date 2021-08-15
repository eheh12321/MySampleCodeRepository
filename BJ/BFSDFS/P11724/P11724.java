package CodingTestMemory.BJ.BFSDFS.P11724;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11724 {

    static int[][] adjgraph;
    static boolean[] visited;

    public static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;
        while(!queue.isEmpty()) {
            int e = queue.remove();
            for(int i = 1; i < visited.length; i++) {
                if(!visited[i] && adjgraph[e][i] != 0) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        adjgraph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        int a, b, cnt = 0;
        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            adjgraph[a][b] = 1;
            adjgraph[b][a] = 1;
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
