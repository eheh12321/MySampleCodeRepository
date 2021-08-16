package CodingTestMemory.BJ.Simulation.P12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12100 {

    static int N, max = 0;
    static int[][] board;
    static int[][] save;
    static int[] arr = new int[5];

    public static void shift_up() { // 빈칸 땡기기
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                if(board[y][x] == 0) {
                    for(int t = 1; t + y < N; t++) {
                        if(board[t + y][x] != 0) {
                            board[y][x] = board[t + y][x];
                            board[t + y][x] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void move_up() { // 합치기 (위 우선)
        shift_up();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N - 1; y++) {
                if (board[y][x] == board[y + 1][x]) {
                    board[y][x] += board[y + 1][x];
                    board[y + 1][x] = 0;
                }
            }
        }
        shift_up();
    }

    public static void shift_down() { // 빈칸 땡기기
        for(int x = 0; x < N; x++) {
            for(int y = N - 1; y >= 0; y--) {
                if(board[y][x] == 0) {
                    for(int t = -1; y + t >= 0; t--) {
                        if(board[y + t][x] != 0) {
                            board[y][x] = board[y + t][x];
                            board[y + t][x] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void move_down() { // 합치기 (아래 우선)
        shift_down();
        for (int x = 0; x < N; x++) {
            for (int y = N - 1; y > 0; y--) {
                if(board[y][x] == board[y - 1][x]) {
                    board[y][x] += board[y - 1][x];
                    board[y - 1][x] = 0;
                }
            }
        }
        shift_down();
    }

    public static void shift_left() { // 빈칸 땡기기
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(board[y][x] == 0) {
                    for(int t = 1; t + x < N; t++) {
                        if(board[y][t + x] != 0) {
                            board[y][x] = board[y][t + x];
                            board[y][t + x] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void move_left() { // 합치기 (왼쪽 우선)
        shift_left();
        for(int x = 0; x < N - 1; x++) {
            for(int y = 0; y < N; y++) {
                if(board[y][x] == board[y][x + 1]) {
                    board[y][x] += board[y][x + 1];
                    board[y][x + 1] = 0;
                }
            }
        }
        shift_left();
    }

    public static void shift_right() { // 빈칸 땡기기
        for(int y = 0; y < N; y++) {
            for(int x = N - 1; x >= 0 ; x--) {
                if(board[y][x] == 0) {
                    for(int t = -1; t + x >= 0; t--) {
                        if(board[y][t + x] != 0) {
                            board[y][x] = board[y][t + x];
                            board[y][t + x] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void move_right() { // 합치기 (왼쪽 우선)
        shift_right();
        for(int x = N - 1; x > 0; x--) {
            for(int y = 0; y < N; y++) {
                if(board[y][x] == board[y][x - 1]) {
                    board[y][x] += board[y][x - 1];
                    board[y][x - 1] = 0;
                }
            }
        }
        shift_right();
    }

    public static void print() {
        for(int y = 0; y < N; y++) {
            System.out.println(Arrays.toString(board[y]));
        }
        System.out.println("----------");
    }
    public static int findMax() {
        int max = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(max < board[y][x]) {
                    max = board[y][x];
                }
            }
        }
        return max;
    }
    public static void copyArr() { // 덮어쓰기
        for(int y = 0; y < N; y++) {
            System.arraycopy(save[y], 0, board[y], 0, N);
        }
    }

    public static void func(int depth) {
        if(depth == 5) {
            copyArr(); // 새로 덮어쓰기
            for(int i = 0; i < 5; i++) {
                switch (arr[i]) {
                    case 0:
                        move_up();
                        break;
                    case 1:
                        move_down();
                        break;
                    case 2:
                        move_right();
                        break;
                    case 3:
                        move_left();
                        break;
                }
            }
            int tmp = findMax();
            if(max < tmp) {
                max = tmp;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            arr[depth] = i;
            func(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        board = new int[N][N]; // 이동용
        save = new int[N][N]; // 저장용
        for(int j = 0; j < N; j++) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                board[j][i] = Integer.parseInt(stk.nextToken());
                save[j][i] = board[j][i];
            }
        }
        func(0);
        System.out.println(max);
    }
}
