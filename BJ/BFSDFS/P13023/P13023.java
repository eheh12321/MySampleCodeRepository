package CodingTestMemory.BJ.BFSDFS.P13023;

import java.io.*;
import java.util.*;

public class P13023 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static LinkedList<LinkedList<Integer>> board = new LinkedList<>();
    static boolean[] visited;

    public static void dfs(int idx, int depth) throws IOException {
        if(depth == 4) {
            bw.write("1");
            bw.flush();
            bw.close();
            System.exit(0);
        }
        for(int e : board.get(idx)) {
            if(!visited[e]) {
                visited[e] = true;
                dfs(e, depth + 1);
                visited[e] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        for(int i = 0; i < N; i++) {
            board.add(new LinkedList<>());
        }
        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            board.get(a).add(b);
            board.get(b).add(a);
        }
        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 0);
        }
        bw.write("0");
        bw.flush();
        bw.close();
    }
}
