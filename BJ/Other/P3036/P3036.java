package CodingTestMemory.BJ.Other.P3036;

import java.util.Scanner;

public class P3036 {

    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 1; i < N; i++) {
            int e = gcd(arr[0], arr[i]);
            System.out.println(arr[0] / e + "/" + arr[i] / e);
        }
    }
}
