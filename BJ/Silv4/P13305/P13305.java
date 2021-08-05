package CodingTestMemory.BJ.Silv4.P13305;

import java.io.*;

public class P13305 {
    public static void main(String[] args) throws IOException {
        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] gasPrices = new long[N];
        long[] dist = new long[N-1];
        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<tmp.length; i++) {
            dist[i] = Long.parseLong(tmp[i]);
        }
        tmp = br.readLine().split(" ");
        for(int i=0; i<tmp.length; i++) {
            gasPrices[i] = Long.parseLong(tmp[i]);
        }

        // 로직 부분
        long totalPrice = 0;
        long minCost = gasPrices[0];

        for(int i=0; i<N-1; i++) {
            if(gasPrices[i] < minCost) {
                minCost = gasPrices[i];
            }
            totalPrice += (minCost * dist[i]);
        }

        // 출력 부분
        bw.write(String.valueOf(totalPrice));
        bw.flush();
        bw.close();
    }
}
