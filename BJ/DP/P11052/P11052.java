package CodingTestMemory.BJ.DP.P11052;

import java.util.Scanner;

public class P11052 {

    static int[] price; // 카드팩 가격
    static int[] dp; // 카드 N개를 살 때 최댓값을 저장할 배열

    public static int func(int N) {
        dp[1] = price[1];
        int max;
        for(int i = 2; i <= N; i++) {
            max = dp[i];
            for(int j = 1; j <= i; j++) { // 반복문을 돌면서 모든 경우를 체크해봐야함
                max = Math.max(max, dp[i - j] + price[j]); // 현재값 vs (i - j)개에서 j짜리 카드팩을 사는 경우
            }
            dp[i] = max; // 최댓값을 저장함
        }
        return dp[N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1];
        price = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            price[i] = sc.nextInt();
        }
        System.out.println(func(N));
    }
}
