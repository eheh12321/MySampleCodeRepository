package CodingTestMemory.BJ.Silv5.P1476;

import java.util.Scanner;
/*
    P1476. 날짜계산 문제
    - 나머지 연산만 잘하면 문제없이 풀 수 있었다.
 */
public class P1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int a, b, c;
        for(int i=1; i<=7980; i++) {
            a = b = c = i;
            a %= 15; if(a == 0) a = 15;
            b %= 28; if(b == 0) b = 28;
            c %= 19; if(c == 0) c = 19;
            if(a  == E) {
                if(b == S) {
                    if(c == M) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
}
