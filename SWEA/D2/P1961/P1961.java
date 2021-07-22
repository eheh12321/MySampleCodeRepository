package CodingTestMemory.SWEA.D2.P1961;

import java.util.Scanner;

public class P1961 {

    static int[][] rotateArr(int[][] arr) {
        int n = arr.length;
        int[][] rotate = new int[n][n];
        for(int y=0; y<n; y++) {
            for(int x=0; x<n; x++) {
                rotate[y][x] = arr[n-x-1][y];
            }
        }
        return rotate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n, sum;
        int[][] arr;
        int[][] rotate90, rotate180, rotate270;

        for(int t=1; t<=T; t++) {
            n = sc.nextInt();
            arr = new int[n][n];
            // 1. 배열에 값 입력
            for(int y=0; y<n; y++) {
                for(int x=0; x<n; x++) {
                    arr[y][x] = sc.nextInt();
                }
            }
            // 2. 90씩 회전
            rotate90 = rotateArr(arr);
            rotate180 = rotateArr(rotate90);
            rotate270 = rotateArr(rotate180);
            // 3. 출력
            System.out.printf("#%d\n", t);
            for(int y=0; y<n; y++) {
                // 90
                for(int x=0; x<n; x++) {
                    System.out.printf("%d", rotate90[y][x]);
                }
                System.out.print(" ");
                // 180
                for(int x=0; x<n; x++) {
                    System.out.printf("%d", rotate180[y][x]);
                }
                System.out.print(" ");
                // 270
                for(int x=0; x<n; x++) {
                    System.out.printf("%d", rotate270[y][x]);
                }
                System.out.println();
            }
        }
    }
}
