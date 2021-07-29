package CodingTestMemory.BJ.Silv5.P1934;

import java.util.Scanner;
/*
    최소공배수 문제
    - 항상 A < B가 되도록 세팅
    - B에서부터 A*B까지 B씩 증가시켜가며 A, B 모두 나눠떨어지는 값이 있는지 체크
 */
public class P1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A, B, ans, swap;
        for(int t=0; t<T; t++) {
            A = sc.nextInt();
            B = sc.nextInt();
            if(A > B) { // 항상 A < B가 되도록 세팅
                swap = B;
                B = A;
                A = swap;
            }
            for(int i=B; i<=A*B; i+=B) {
                if(i % B == 0 && i % A == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
