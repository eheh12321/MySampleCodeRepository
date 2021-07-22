package CodingTestMemory.SWEA.D2.P1970;

import java.util.Scanner;

public class P1970 {
    public static void main(String[] args) {
        final int[] units = {50000,10000,5000,1000,500,100,50,10};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int n = sc.nextInt();
            System.out.format("#%d\n", t);
            for(int u: units) {
                System.out.format("%d ", n/u);
                n %= u;
            }
            System.out.format("\n");
        }
    }
}
