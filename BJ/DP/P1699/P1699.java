package CodingTestMemory.BJ.DP.P1699;


import java.util.Scanner;

public class P1699 {

    static int N;
    static int[] dp = new int[100001];

    public static int func() {

        dp[1] = 1;
        dp[2] = 2; // 1^2 + 1^2
        dp[3] = 3; // 1^2 + 1^2 + 1^2
        
        for(int i = 2; i <= (int)Math.sqrt(N); i++) {
            dp[i*i] = 1; // 제곱수는 모두 1로 처리
        }
        
        for(int i = 4; i <= N; i++) {
            if(dp[i] == 1) {
                continue;
            }
            dp[i] = 99999999; // 대충 큰값
            for(int j = i - 1; j >= i / 2; j--) {
                int val = dp[j] + dp[i - j];  // ex) 7+1, 6+2, 5+3, 4+4 | 3+5부터는 중복이라 볼 필요 X
                dp[i] = Math.min(dp[i], val); // 제일 작은 경우의 수를 저장
            }
        }
        return dp[N];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        System.out.println(func());
    }
}
