package CodingTestMemory.BJ.Sliv3.P15650;

import java.io.*;
import java.util.StringTokenizer;

public class P15650 {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

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
            for(int i = 0; i < M - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    return;
                }
            }
            for(int e : arr) {
                bw.write(String.valueOf(e) + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) { // 아직 방문한 적이 없으면
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
