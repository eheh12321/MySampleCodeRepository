package CodingTestMemory.BJ.BackTracking.P15651;

import java.io.*;
import java.util.StringTokenizer;

public class P15651 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 0);

        bw.flush();
        bw.close();
    }
    public static void dfs(int N, int M, int depth) throws IOException {
        if(M == depth) {
            for(int e : arr) {
                bw.write(String.valueOf(e) + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1);
        }
    }
}
