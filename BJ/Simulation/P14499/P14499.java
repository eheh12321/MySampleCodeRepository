package CodingTestMemory.BJ.Simulation.P14499;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14499 {

    public static class Dice {
        int x, y;
        int[][] dice_val;

        public Dice(int x, int y, int[][] dice_val) {
            this.x = x;
            this.y = y;
            this.dice_val = dice_val;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, K;
    static int[][] map;
    static int[] arr;
    static int[] tmp = new int[4];
    static Dice dice;

    public static void rolling_north() {
        for(int i = 0; i < 4; i++) {
            tmp[i] = dice.dice_val[(i + 1) % 4][1];
        }
        for(int i = 0; i < 4; i++) {
            dice.dice_val[i][1] = tmp[i];
        }
    }
    public static void rolling_south() {
        for(int i = 0; i < 4; i++) {
            tmp[i] = dice.dice_val[(i + 3) % 4][1];
        }
        for(int i = 0; i < 4; i++) {
            dice.dice_val[i][1] = tmp[i];
        }
    }
    public static void rolling_east() {
        int save = dice.dice_val[1][2];
        for(int i = 0; i < 2; i++) {
            dice.dice_val[1][2 - i] = dice.dice_val[1][1 - i];
        }
        dice.dice_val[1][0] = dice.dice_val[3][1];
        dice.dice_val[3][1] = save;
    }
    public static void rolling_west() {
        int save = dice.dice_val[1][0];
        for(int i = 0; i < 2; i++) {
            dice.dice_val[1][i] = dice.dice_val[1][i + 1];
        }
        dice.dice_val[1][2] = dice.dice_val[3][1];
        dice.dice_val[3][1] = save;
    }

    public static void print() {
        for(int j = 0; j < 4; j++) {
            System.out.println(Arrays.toString(dice.dice_val[j]));
        }
        System.out.println("----");
    }

    public static void func() throws IOException {
        for(int k = 0; k < K; k++) {
            int nx = dice.x, ny = dice.y;
            int dir = arr[k];
            switch (dir) {
                case 1: // 동
                    nx += 1;
                    if(nx >= M) {
                        continue;
                    }
                    rolling_east();
                    break;
                case 2: // 서
                    nx -= 1;
                    if(nx < 0) {
                        continue;
                    }
                    rolling_west();
                    break;
                case 3: // 북
                    ny -= 1;
                    if(ny < 0) {
                        continue;
                    }
                    rolling_north();
                    break;
                default: // 남
                    ny += 1;
                    if(ny >= N) {
                        continue;
                    }
                    rolling_south();
                    break;
            }
            dice.x = nx;
            dice.y = ny;
            if(map[ny][nx] == 0) { // 주사위 바닥에 쓰인 값이 바닥에 복사된다
                map[ny][nx] = dice.dice_val[3][1];
            } else { // 바닥에 쓰인 값이 주사위 바닥에 복사된다 + 바닥은 0이된다
                dice.dice_val[3][1] = map[ny][nx];
                map[ny][nx] = 0;
            }
            bw.write(dice.dice_val[1][1] + "\n"); // 주사위 윗면 출력.
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        int y = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        dice = new Dice(x, y, new int[4][3]); // 주시위 객체 생성
        K = Integer.parseInt(stk.nextToken());
        arr = new int[K];

        for(int j = 0; j < N; j++) { // 지도 그리기
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                map[j][i] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(br.readLine()); // 이동방향 입력
        for(int k = 0; k < K; k++) {
            arr[k] = Integer.parseInt(stk.nextToken());
        }

        func();

        bw.flush();
        bw.close();
    }
}
