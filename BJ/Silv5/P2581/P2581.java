package CodingTestMemory.BJ.Silv5.P2581;

import java.util.Scanner;
/*
    P2581번. 소수 문제!
    - 에라토스테네스의 채를 이용, 배열에 소수를 모두 구하는 방식으로 해결
 */
public class P2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] primeArr = new int[N + 1];
        int sum = 0;
        int min = N;
        // 1. 배열에 값 채우기 (1은 소수가 아님으로 2부터 시작
        for(int i=2; i<=N; i++) {
            primeArr[i] = i;
        }
        for(int i=2; i<=N; i++) {
            if(primeArr[i] == 0) { // 소수가 아니면 0, continue
                continue;
            }
            for(int j=i+i; j<=N; j+=i) { // i의 배수는 모두 0으로 처리
                primeArr[j] = 0;
            }
        }
        for(int i=M; i<=N; i++) {
            if(primeArr[i] != 0) {
                if(primeArr[i] < min) {
                    min = primeArr[i];
                }
                sum += primeArr[i];
            }
        }
        if(sum == 0) {
            System.out.println("-1");
        } else {
            System.out.printf("%d\n%d\n", sum, min);
        }
    }
}
