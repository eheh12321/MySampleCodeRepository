package CodingTestMemory.BJ.Greedy.P11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
    <동전 0> 문제에서 그리디 알고리즘이 사용될 수 있는 이유
    - 각 동전들이 서로 배수관계에 있기 때문
    (배수관계에 있지 않으면 그리디 방식으로 풀 수 없음)
 */
public class P11047 {

    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int idx = N - 1, cnt = 0;
        price = new int[N];
        for(int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(br.readLine());
            if(price[i] > K && idx == N - 1) { // K원보다 큰 동전은 사용할 수 없음.
                idx = i - 1;
            }
        }
        while(K > 0) {
            while(price[idx] <= K) {
                K -= price[idx];
                cnt++;
            }
            idx--;
        }
        System.out.println(cnt);
    }
}
