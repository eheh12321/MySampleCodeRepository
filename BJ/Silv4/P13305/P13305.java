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
        int minidx, idx;
        long sum, totalDistance, totalPrice = 0;
        int i = N - 1; // 뒤에서부터 탐색
        while(i > 0) {
            minidx = 0;
            sum = 0;
            idx = i - 1;
            totalDistance = 0;
            for (int j = i - 1; j >= 0; j--) { // 현 위치보다 앞에있는 원소 중 최솟값 인덱스를 탐색
                sum += dist[idx--];
                if (gasPrices[j] <= gasPrices[minidx]) {
                    minidx = j;
                    totalDistance = sum;
                }
            }
            totalPrice += (totalDistance * gasPrices[minidx]);
            i = minidx;
        }

        // 출력 부분
        bw.write(String.valueOf(totalPrice));
        bw.flush();
        bw.close();
    }
}
