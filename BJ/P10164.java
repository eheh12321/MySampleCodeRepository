package CodingTestMemory.BJ;

import java.util.Arrays;
import java.util.Scanner;

public class P10164 {

    static int[][] map;

    public static void bfs() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, K, cnt = 1;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                map[j][i] = cnt++;
            }
        }
    }
}
