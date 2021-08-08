package CodingTestMemory.BJ.Sliv3.P15649;

import java.io.*;
import java.util.StringTokenizer;

public class P15649 {

    public static int[] arr;
    public static boolean[] visited;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];
        dfs(N, M, 0);
        bw.flush();
        bw.close();
    }

    public static void dfs(int N, int M, int depth) throws IOException {
        if(depth == M) {
            for(int val : arr) {
                bw.write(String.valueOf(val) + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
