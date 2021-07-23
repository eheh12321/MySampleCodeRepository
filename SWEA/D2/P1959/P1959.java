package CodingTestMemory.SWEA.D2.P1959;

import java.util.Scanner;

public class P1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a, b, tmp, sum, max;
        int[] aArr, bArr;
        for(int t=1; t<=T; t++) {
            a = sc.nextInt();
            b = sc.nextInt();
            aArr = new int[a];
            bArr = new int[b];
            for(int i=0; i<a; i++) {
                aArr[i] = sc.nextInt();
            }
            for(int i=0; i<b; i++) {
                bArr[i] = sc.nextInt();
            }
            max = 0;
            if(a<b) {
                for(int i=0; i<=b-a; i++) {
                    sum = 0;
                    for(int j=0; j<a; j++) {
                        sum = sum + (aArr[j] * bArr[i + j]);
                    }
                    if(max < sum) {
                        max = sum;
                    }
                }
            } else {
                for(int i=0; i<=a-b; i++) {
                    sum = 0;
                    for(int j=0; j<b; j++) {
                        sum = sum + (bArr[j] * aArr[i + j]);
                    }
                    if(max < sum) {
                        max = sum;
                    }
                }
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}
