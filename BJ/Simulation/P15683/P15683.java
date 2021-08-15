package CodingTestMemory.BJ.Simulation.P15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P15683 {

    static int R, C, camera_cnt = 0, min = 99999; // 행, 열, 카메라 개수
    static int[][] board;
    static int[][] visited; // 현재 감시되는 영역 = 1 이상 / 사각지대 = 0
    static LinkedList<Node> cameraArr = new LinkedList<>();

    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void fill_Row_R(Node e) { // 현재 행의 우측방향을 탐색
        for(int x = e.x + 1; x < C; x++) {
            if(board[e.y][x] == 6) { // 벽을 만났으므로 종료.
                return;
            }
            visited[e.y][x] += 1;
        }
    }

    public static void unfill_Row_R(Node e) { // 되돌리기
        for(int x = e.x + 1; x < C; x++) {
            if(board[e.y][x] == 6) {
                return;
            }
            visited[e.y][x] -= 1;
        }
    }

    public static void fill_Row_L(Node e) { // 현재 행의 좌측방향 탐색
        for(int x = e.x - 1; x >= 0; x--) {
            if(board[e.y][x] == 6) {
                return;
            }
            visited[e.y][x] += 1;
        }
    }

    public static void unfill_Row_L(Node e) { // 되돌리기
        for(int x = e.x - 1; x >= 0; x--) {
            if(board[e.y][x] == 6) {
                return;
            }
            visited[e.y][x] -= 1;
        }
    }

    public static void fill_Col_U(Node e){ // 현재 열의 위쪽 탐색
        for(int y = e.y - 1; y >= 0; y--) {
            if(board[y][e.x] == 6) {
                return;
            }
            visited[y][e.x] += 1;
        }
    }

    public static void unfill_Col_U(Node e){ // 되돌리기
        for(int y = e.y - 1; y >= 0; y--) {
            if(board[y][e.x] == 6) {
                return;
            }
            visited[y][e.x] -= 1;
        }
    }

    public static void fill_Col_D(Node e) { // 현재 열의 아래쪽 탐색
        for(int y = e.y + 1; y < R; y++) {
            if(board[y][e.x] == 6) {
                return;
            }
            visited[y][e.x] += 1;
        }
    }

    public static void unfill_Col_D(Node e) { // 되돌리기
        for(int y = e.y + 1; y < R; y++) {
            if(board[y][e.x] == 6) {
                return;
            }
            visited[y][e.x] -= 1;
        }
    }

    public static int count() { // 사각지대의 개수 (visited가 0인 점)
        int cnt = 0;
        for(int y = 0; y < R; y++) {
            for(int x = 0; x < C; x++) {
                if(visited[y][x] == 0 && board[y][x] != 6) { // 벽이 아니면서 방문하지 않은 곳
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void func(int depth) {
        if(depth == camera_cnt) {
            int tmp = count();
            if(tmp < min) {
                min = tmp;
            }
            return;
        }
        Node e = cameraArr.get(depth);
        switch (board[e.y][e.x]) { // cctv 번호별로 분류
            case 1:
                fill_Row_R(e);
                func(depth + 1);
                unfill_Row_R(e);
                // 90도 회전
                fill_Col_D(e);
                func(depth + 1);
                unfill_Col_D(e);
                // 90도 회전
                fill_Row_L(e);
                func(depth + 1);
                unfill_Row_L(e);
                // 90도 회전
                fill_Col_U(e);
                func(depth + 1);
                unfill_Col_U(e);
                break;
            case 2:
                fill_Row_L(e);
                fill_Row_R(e);
                func(depth + 1);
                unfill_Row_L(e);
                unfill_Row_R(e);
                // 회전
                fill_Col_U(e);
                fill_Col_D(e);
                func(depth + 1);
                unfill_Col_U(e);
                unfill_Col_D(e);
                break;
            case 3:
                fill_Row_R(e);
                fill_Col_U(e);
                func(depth + 1);
                unfill_Row_R(e);
                unfill_Col_U(e);
                // 회전
                fill_Row_R(e);
                fill_Col_D(e);
                func(depth + 1);
                unfill_Row_R(e);
                unfill_Col_D(e);
                // 회전
                fill_Row_L(e);
                fill_Col_D(e);
                func(depth + 1);
                unfill_Row_L(e);
                unfill_Col_D(e);
                // 회전
                fill_Row_L(e);
                fill_Col_U(e);
                func(depth + 1);
                unfill_Row_L(e);
                unfill_Col_U(e);
                break;
            case 4:
                fill_Row_L(e);
                fill_Row_R(e);
                fill_Col_U(e);
                func(depth + 1);
                unfill_Row_L(e);
                unfill_Row_R(e);
                unfill_Col_U(e);
                // 회전
                fill_Col_U(e);
                fill_Col_D(e);
                fill_Row_L(e);
                func(depth + 1);
                unfill_Col_U(e);
                unfill_Col_D(e);
                unfill_Row_L(e);
                // 회전
                fill_Col_U(e);
                fill_Col_D(e);
                fill_Row_R(e);
                func(depth + 1);
                unfill_Col_U(e);
                unfill_Col_D(e);
                unfill_Row_R(e);
                // 회전
                fill_Col_D(e);
                fill_Row_L(e);
                fill_Row_R(e);
                func(depth + 1);
                unfill_Col_D(e);
                unfill_Row_L(e);
                unfill_Row_R(e);
                break;
            case 5:
                fill_Col_U(e);
                fill_Col_D(e);
                fill_Row_L(e);
                fill_Row_R(e);
                func(depth + 1);
                unfill_Col_U(e);
                unfill_Col_D(e);
                unfill_Row_L(e);
                unfill_Row_R(e);
                break;
            default:
                System.out.println("엥?");
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        board = new int[R][C];
        visited = new int[R][C];
        for(int y = 0; y < R; y++) { // 데이터 입력
            stk = new StringTokenizer(br.readLine());
            for(int x = 0; x < C; x++) {
                board[y][x] = Integer.parseInt(stk.nextToken());
                if(0 < board[y][x] && board[y][x] < 6) { // 카메라이면!
                    cameraArr.add(new Node(y, x)); // 카메라 위치 추가
                    visited[y][x] += 1; // cctv가 있는 자리는 감시가 된다
                    camera_cnt++;
                }
            }
        }
        func(0);
        System.out.println(min);
    }
}
