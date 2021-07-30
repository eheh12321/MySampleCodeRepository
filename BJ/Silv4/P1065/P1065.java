package CodingTestMemory.BJ.Silv4.P1065;

import java.util.Scanner;

public class P1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 99;
        int[] split = new int[3];
        int tmp, t;
        if(N < 100) { // 100 미만의 수는 모두 한수이다
            System.out.println(N);
            return;
        }
        for(int i=100; i<=N && i < 1000; i++) {
            tmp = i;
            t = 2;
            while(tmp > 0) { // 자릿수 분리
                split[t--] = tmp % 10;
                tmp /= 10;
            }
            if(split[1] - split[0] == split[2] - split[1]) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
