package CodingTestMemory.BJ.Silv4.P1676;

import java.util.Scanner;

public class P1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        long tmp = 1;
        for(int i=0; i<N; i++) {
            tmp *= (i + 1);
            if(tmp % 10 == 0) {
                while(tmp % 10 == 0) {
                    tmp /= 10;
                    cnt += 1;
                }
            } else {
                tmp %= 10000;
            }
        }
        System.out.println(cnt);
    }
}
