package CodingTestMemory.BJ.Simulation.P18808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P18808 {
    static class Sticker {
        int R, C;
        int[][] shape;
        Sticker(int R, int C, int[][] shape) {
            this.R = R;
            this.C = C;
            this.shape = shape;
        }
    }
    static int N, M, K;
    static LinkedList<Sticker> stickers = new LinkedList<>();
    static int[][] board;
    static int[][] visited;

    public static Sticker rotate(Sticker e) { // 시계방향 회전
        int[][] rotate_sticker = new int[e.C][e.R];
        for(int y = 0; y < e.C; y++) {
            for(int x = 0; x < e.R; x++) {
                rotate_sticker[y][x] = e.shape[e.R - 1 - x][y];
            }
        }
        return new Sticker(e.C, e.R, rotate_sticker);
    }

    public static Sticker rotate_R(Sticker e) { // 시계 반대방향 회전 (짜고보니 쓸데없음)
        int[][] rotate_sticker = new int[e.C][e.R];
        for(int y = 0; y < e.C; y++) {
            for(int x = 0; x < e.R; x++) {
                rotate_sticker[y][x] = e.shape[x][e.C - 1 - y];
            }
        }
        return new Sticker(e.C, e.R, rotate_sticker);
    }

    public static boolean checkAvailable(int y, int x, Sticker s) { // 스티커를 붙일 수 있는지 대보기
        for(int j = 0; j < s.R; j++) {
            for(int i = 0; i < s.C; i++) {
                if(i + x >= M || j + y >= N) { // outofBounds
                    return false;
                }
                if(s.shape[j][i] == 1 && board[j + y][i + x] == 1) {
                    return false; // 붙이고자 하는 위치에 이미 스티커가 붙어있다면
                }
            }
        }
        return true;
    }

    public static void attatchSticker(int y, int x, Sticker s) {
        for(int j = 0; j < s.R; j++) {
            for(int i = 0; i < s.C; i++) {
                if(s.shape[j][i] == 1) {
                    board[y + j][x + i] = 1;
                }
            }
        }
    }

    public static void printBoard() {
        for(int y = 0; y < board.length; y++) {
            System.out.println(Arrays.toString(board[y]));
        }
        System.out.println("----------");
    }

    public static void func(int depth) { // 탐색함수
        if(depth == stickers.size()) { // 모든 스티커를 다 붙였다면
            //printBoard();
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                for(int i = 0; i < M; i++) {
                    if(board[j][i] == 1) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            System.exit(0);
        }
        Sticker s = stickers.get(depth);
        for(int rotate = 0; rotate < 4; rotate++) {
            for(int y = 0; y < N; y++) { // 전체를 싹 훑으면서 부착 가능한 위치가 있는지 탐색
                for(int x = 0; x < M; x++) {
                    if(checkAvailable(y, x, s)) {
                        attatchSticker(y, x, s);
                        //printBoard();
                        func(depth + 1);
                    }
                }
            }
            s = rotate(s); // 90도 회전
        }
        func(depth + 1); // 부착 불가 - 붙이지 않고 넘어감
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        board = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());
            int[][] shape = new int[R][C];
            for(int y = 0; y < R; y++) {
                stk = new StringTokenizer(br.readLine());
                for(int x = 0; x < C; x++) {
                    shape[y][x] = Integer.parseInt(stk.nextToken());
                }
            }
            stickers.add(new Sticker(R, C, shape)); // 스티커 모양 저장
        }
        func(0);
    }
}
