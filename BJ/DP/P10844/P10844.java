package CodingTestMemory.BJ.DP.P10844;

import java.util.Scanner;

public class P10844 {

    static long[][] dp = new long[101][10];

    public static long func(int N) {
        // dp배열 초기화
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1L;
        }
        dp[2][0] = 1L; // 예외 - 01은 불가능함.
        dp[2][9] = 1L; // 예외 - 9는 8로밖에 못감.
        for(int i = 1; i <= 8; i++) {
            dp[2][i] = 2L;
        }
        // 메인
        for(int j = 3; j <= N; j++) {
            for(int i = 1; i <= 8; i++) {
                dp[j][i] = (dp[j - 1][i - 1] + dp[j - 1][i + 1]) % 1000000000;
            }
            dp[j][0] = dp[j - 1][1] % 1000000000; // 1로만 갈 수 있다
            dp[j][9] = dp[j - 1][8] % 1000000000; // 8로만 갈 수 있다
        }
        // 출력
        long sum = 0;
        for(int i = 1; i <= 9; i++) {
            sum += dp[N][i];
            sum %= 1000000000;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(func(N));
    }
}
