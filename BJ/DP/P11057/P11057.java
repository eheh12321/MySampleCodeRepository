package CodingTestMemory.BJ.DP.P11057;

import java.util.Scanner;

public class P11057 {

    static long[][] dp = new long[1001][10];

    public static long func(int N) {
        // dp배열 초기화
        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for(int i = 0; i <= 9; i++) {
            dp[2][i] = 9 - i + 1;
        }
        // 메인
        for(int j = 3; j <= N; j++) {
            for(int i = 0; i <= 9; i++) {
                long tmp = 0;
                for(int k = i; k <= 9; k++) {
                    tmp += dp[j - 1][k];
                    tmp %= 10007;
                }
                dp[j][i] = tmp;
            }
        }
        // 출력
        long sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum += dp[N][i];
            sum %= 10007;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(func(N));
    }
}
