package CodingTestMemory.BJ.BackTracking.P15651;

import java.io.*;
import java.util.StringTokenizer;

public class P15651 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        func(0);

        bw.flush();
        bw.close();
    }

    public static void func(int depth) throws IOException {
        if(M == depth) {
            for(int e : arr) {
                bw.write(String.valueOf(e) + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            func(depth + 1);
        }
    }
}
