package CodingTestMemory.BJ.BackTracking.P2580;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P2580 {
    static class Node {
        int x, y;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[][] board = new int[9][9];
    static LinkedList<Node> blanklist = new LinkedList<>(); // 빈칸의 위치를 저장해두기 위한 배열
    static int blank_size = 0; // 빈칸이 몇개인지 세기위한 변수
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean check_garosero(Node e) {
        int[] sero = new int[10];
        int[] garo = new int[10];
        int tmp;
        for(int y = 0; y < 9; y++) { // 세로방향에 겹치는 수가 있는지 체크
            tmp = board[y][e.x];
            if(tmp == 0) { // 0이면 일단 넘어간다
                continue;
            }
            sero[tmp] += 1;
            if(sero[tmp] > 1) { // 겹치는 수가 있으면 false
                return false;
            }
        }
        for(int x = 0; x < 9; x++) { // 가로방향에 겹치는 수가 있는지 체크
            tmp = board[e.y][x];
            if(tmp == 0) { // 0이면 일단 넘어간다
                continue;
            }
            garo[tmp] += 1;
            if(garo[tmp] > 1) { // 겹치는 수가 있으면 false
                return false;
            }
        }
        return true;
    }

    public static boolean check_3by3(Node e) {
        int by = e.y / 3; // 0, 1, 2중 하나
        int bx = e.x / 3; // 0, 1, 2중 하나
        int tmp;
        int[] check = new int[10];
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
               tmp = board[by * 3 + y][bx * 3 + x];
               if(tmp == 0) {
                   continue;
               }
               check[tmp] += 1;
               if(check[tmp] > 1) {
                   return false;
               }
            }
        }
        return true;
    }

    public static void func(int idx, int depth) throws IOException {
        if(depth == blank_size) { // 빈칸을 모두 채웠다 = 출력 후 종료
            for(int y = 0; y < 9; y++) {
                for(int x = 0; x < 9; x++) {
                    bw.write(String.valueOf(board[y][x]) + " ");
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }
        Node now = blanklist.get(idx);
        for(int i = 1; i <= 9; i++) {
            board[now.y][now.x] = i; // 1부터 9까지 중에서 가능한 경우를 찾기
            if(!(check_3by3(now) && check_garosero(now))) { // true - 가능 / false - 불가능
                board[now.y][now.x] = 0; // 불가능한 경우임으로 다시 복구해놓고 continue
                continue;
            }
            func(idx + 1, depth + 1); // 가능한 경우를 찾았으므로 호출
            board[now.y][now.x] = 0; // 여기로 왔다는건 실패했다는 뜻이므로 다시 원점복귀
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        for(int j = 0; j < 9; j++) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; i++) {
                board[j][i] = Integer.parseInt(stk.nextToken());
                if(board[j][i] == 0) {
                    blanklist.add(new Node(j, i));
                    blank_size++;
                }
            }
        }
        func(0, 0);
        bw.flush();
        bw.close();
    }
}
