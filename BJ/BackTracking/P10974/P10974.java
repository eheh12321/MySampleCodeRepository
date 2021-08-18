package CodingTestMemory.BJ.BackTracking.P10974;

import java.io.*;

public class P10974 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void func(int depth) throws IOException {
        if(depth == N) {
            for(int e : arr) {
                bw.write(String.valueOf(e) + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                func(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        func(0);
        bw.flush();
        bw.close();
    }
}
