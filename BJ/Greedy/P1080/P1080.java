package CodingTestMemory.BJ.Greedy.P1080;

import java.util.Arrays;
import java.util.Scanner;

public class P1080 {

    static int N, M;
    static int[][] A;
    static int[][] B;

    public static boolean flip(int y, int x) {
        if(y + 2 >= N || x + 2 >= M) {
            return false; // OutOfBounds
        }

        for(int j = 0; j < 3; j++) {
            for(int i = 0; i < 3; i++) {
                if(A[y + j][x + i] == 0) {
                    A[y + j][x + i] = 1;
                } else {
                    A[y + j][x + i] = 0;
                }
            }
        }
        return true;
    }

    public static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        System.out.println("------");
    }

    public static int func() {
        int cnt = 0;
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                if(A[j][i] != B[j][i]) {
                    boolean chk = flip(j, i);
                    if(chk == true) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        A = new int[N][M];
        B = new int[N][M];
        for(int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for(int j = 0; j < M; j++) {
                int val = (int)input.charAt(j) - 48;
                A[i][j] = val;
            }
        }
        for(int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for(int j = 0; j < M; j++) {
                int val = (int)input.charAt(j) - 48;
                B[i][j] = val;
            }
        }

        int val = func();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(val);
    }
}
