package CodingTestMemory.BJ.Math.P9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9613 {

    public static int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            long sum = 0;
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(stk.nextToken()); // 데이터 입력
            }
            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++) {
                    if(arr[i] < arr[j]) {
                        sum += getGCD(arr[j], arr[i]);
                    } else {
                        sum += getGCD(arr[i], arr[j]);
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
