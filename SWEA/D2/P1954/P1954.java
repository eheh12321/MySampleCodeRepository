package CodingTestMemory.SWEA.D2.P1954;

import java.util.Scanner;

public class P1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n, chk, y, x;
        int[][] arr;
        for(int t=1; t<=T; t++) {
            n = sc.nextInt();
            arr = new int[n][n];
            chk = 0;
            y = 0;
            x = -1;
            for(int i=1; i<=n*n; ) {
                // 1. 가로방향으로 n칸
                for(int k=0; k<n-chk; k++) {
                    arr[y][++x] = i++;
                }
                chk += 1;
                // 2. 세로방향으로 n - 1칸
                for(int k=0; k<n-chk; k++) {
                    arr[++y][x] = i++;
                }
                // 3. 가로방향으로 n - 1칸
                for(int k=0; k<n-chk; k++) {
                    arr[y][--x] = i++;
                }
                chk += 1;
                // 4. 세로방향으로 n - 2칸 {
                for(int k=0; k<n-chk; k++) {
                    arr[--y][x] = i++;
                }
            }
            // 출력
            System.out.printf("#%d\n", t);
            for(y=0; y<n; y++) {
                for(x=0; x<n; x++) {
                    System.out.printf("%2d ", arr[y][x]);
                }
                System.out.println();
            }
        }
    }
}
