package CodingTestMemory.BJ.BruteForce.P1748;

import java.io.*;

public class P1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1, chk = 10;
        long len = 0;
        for(int i = 1; i <= N; i++) {
            if(i >= chk) {
                chk *= 10;
                cnt++;
            }
            len += cnt;
        }
        bw.write(String.valueOf(len));
        bw.flush();
        bw.close();
    }
}
