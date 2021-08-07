package CodingTestMemory.BJ.Sliv3.P2193;

import java.util.Scanner;

public class P2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] numArr = new long[N + 1][2];
        numArr[0][1] = 1;
        numArr[1][0] = 1;
        for(int i = 2; i <= N; i++) {
            numArr[i][0] = (numArr[i - 1][1] + numArr[i - 1][0]);
            numArr[i][1] = numArr[i - 1][0];
        }
        System.out.println(numArr[N - 1][0] + numArr[N - 1][1]);
    }
}
