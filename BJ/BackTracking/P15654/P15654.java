package CodingTestMemory.BJ.BackTracking.P15654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15654 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] num;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer stk = new StringTokenizer(input);
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[M];
        num = new int[N];
        visited = new boolean[N];

        input = br.readLine();
        stk = new StringTokenizer(input);
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(num);
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
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = num[i];
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
