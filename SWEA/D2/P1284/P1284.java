package CodingTestMemory.SWEA.D2.P1284;

import java.util.Scanner;

public class P1284 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int P, Q, R, S, W;
        int priceA, priceB;
        for(int t=1; t<=T; t++) {
            P = sc.nextInt();
            Q = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            W = sc.nextInt();
            priceA = P * W;
            if (W <= R) {
                priceB = Q;
            } else {
                priceB = Q + (W - R) * S;
            }
            System.out.printf("#%d %d\n", t, Math.min(priceA, priceB));
        }
    }
}