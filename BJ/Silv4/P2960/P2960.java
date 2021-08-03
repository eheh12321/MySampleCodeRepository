package CodingTestMemory.BJ.Silv4.P2960;

import java.io.*;

public class P2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int cnt = 0;
        int[] numArr = new int[N + 1];
        for(int i=2; i<=N; i++) {
            if(numArr[i] != 0) {
                continue;
            }
            for(int j=i; j<=N; j+=i) {
                if(numArr[j] == 0) {
                    numArr[j] = 1;
                    cnt += 1;
                    if(cnt == K) {
                        bw.write(String.valueOf(j));
                        bw.flush();
                        bw.close();
                        return;
                    }
                }
            }
        }
    }
}
