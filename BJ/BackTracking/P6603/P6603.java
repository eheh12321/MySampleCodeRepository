package CodingTestMemory.BJ.BackTracking.P6603;

import java.io.*;
import java.util.StringTokenizer;

public class P6603 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] numArr;
    static int[] selectedArr = new int[6];
    static boolean[] visited;
    static int N;

    public static void func(int depth, int idx) throws IOException {
        if(depth == 6) {
            for(int e : selectedArr) {
                bw.write(String.valueOf(e) + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selectedArr[depth] = numArr[i];
                func(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        while(true) {
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            if(N == 0) {
                break;
            }
            numArr = new int[N];
            visited = new boolean[N];
            for(int i = 0; i < N; i++) {
                numArr[i] = Integer.parseInt(stk.nextToken());
            }
            func(0, 0);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
