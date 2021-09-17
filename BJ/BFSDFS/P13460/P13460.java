package CodingTestMemory.BJ.BFSDFS.P13460;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class P13460 {

    public static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            Node e = (Node) o;
            if(this.x == e.x && this.y == e.y) {
                return true;
            } else {
                return false;
            }
        }
    }

    static int min = 99;
    static int N, M;
    static int[] arr = new int[10];
    static char[][] map;
    static char[][] cpmap;
    static Node red, blue;
    static Node save_red, save_blue;

    public static int sliding_west() {
        cpmap[blue.y][blue.x] = '.';
        cpmap[red.y][red.x] = '.';
        int flag = 0;
        if(blue.x < red.x) { // 파랑이 먼저 움직인다
            for(int x = blue.x; x >= 1; x--) {
                if(cpmap[blue.y][x - 1] == '#') {
                    break;
                } else if (cpmap[blue.y][x - 1] == 'O') {
                    blue.x = 0;
                    blue.y = 0; // 공 없애기
                    flag = -1;
                    break;
                } else {
                    blue.x -= 1;
                }
            }
            for(int x = red.x; x >= 1; x--) {
                if(cpmap[red.y][x - 1] == '#' || ((blue.y == red.y) && (x - 1 == blue.x))) {
                    break;
                } else if (cpmap[red.y][x - 1] == 'O') {
                    if(flag == -1) {
                        break;
                    }
                    flag = 1;
                    break;
                } else {
                    red.x -= 1;
                }
            }
        }
        else { // 빨강이 먼저 움직인다
            for(int x = red.x; x >= 1; x--) {
                if(cpmap[red.y][x - 1] == '#') {
                    break;
                } else if (cpmap[red.y][x - 1] == 'O') {
                    red.x = 0;
                    red.y = 0; // 공 없애기
                    flag = 1;
                    break;
                } else {
                    red.x -= 1;
                }
            }
            // 파랑이 다음으로 움직인다
            for(int x = blue.x; x >= 1; x--) {
                if(cpmap[blue.y][x - 1] == '#' || ((blue.y == red.y) && (x - 1 == red.x))) {
                    break;
                } else if (cpmap[blue.y][x - 1] == 'O') {
                    flag = -1;
                    break;
                } else {
                    blue.x -= 1;
                }
            }
        }
        return flag;
    }

    public static int sliding_east() {
        cpmap[blue.y][blue.x] = '.';
        cpmap[red.y][red.x] = '.';
        int flag = 0;

        if(blue.x < red.x) { // 빨강이 먼저 움직인다
            for(int x = red.x; x < M; x++) {
                if(cpmap[red.y][x + 1] == '#') {
                    break;
                } else if (cpmap[red.y][x + 1] == 'O') {
                    red.x = 0;
                    red.y = 0; // 공 없애기
                    flag = 1;
                    break;
                } else {
                    red.x += 1;
                }
            }
            for(int x = blue.x; x < M; x++) {
                if (cpmap[blue.y][x + 1] == '#' || ((blue.y == red.y) && (x + 1 == red.x))) {
                    break;
                } else if (cpmap[blue.y][x + 1] == 'O') {
                    flag = -1;
                    break;
                } else {
                    blue.x += 1;
                }
            }
        }
        else { // 파랑이 먼저 움직인다
            for(int x = blue.x; x < M; x++) {
                if (cpmap[blue.y][x + 1] == '#') {
                    break;
                } else if (cpmap[blue.y][x + 1] == 'O') {
                    blue.x = 0;
                    blue.y = 0; // 공 없애기
                    flag = -1;
                    break;
                } else {
                    blue.x += 1;
                }
            }
            for(int x = red.x; x < M; x++) {
                if(cpmap[red.y][x + 1] == '#' || ((blue.y == red.y) && (x + 1 == blue.x))) {
                    break;
                } else if (cpmap[red.y][x + 1] == 'O') {
                    if(flag == -1) {
                        break;
                    }
                    flag = 1;
                    break;
                } else {
                    red.x += 1;
                }
            }
        }
        return flag;
    }

    public static int sliding_north() {
        cpmap[blue.y][blue.x] = '.';
        cpmap[red.y][red.x] = '.';
        int flag = 0;
        if(blue.y > red.y) { // 빨강이 먼저 움직인다
            for(int y = red.y; y > 0; y--) {
                if(cpmap[y - 1][red.x] == '#') {
                    break;
                } else if (cpmap[y - 1][red.x] == 'O') {
                    red.x = 0;
                    red.y = 0; // 공 없애기
                    flag = 1;
                    break;
                } else {
                    red.y -= 1;
                }
            }
            for(int y = blue.y; y > 0; y--) {
                if(cpmap[y - 1][blue.x] == '#' || ((blue.x == red.x) && (y - 1 == red.y))) {
                    break;
                } else if (cpmap[y - 1][blue.x] == 'O') {
                    flag = -1;
                    break;
                } else {
                    blue.y -= 1;
                }
            }
        }
        else {
            for(int y = blue.y; y > 0; y--) {
                if(cpmap[y - 1][blue.x] == '#') {
                    break;
                } else if (cpmap[y - 1][blue.x] == 'O') {
                    blue.x = 0;
                    blue.y = 0; // 공 없애기
                    flag = -1;
                    break;
                } else {
                    blue.y -= 1;
                }
            }
            for(int y = red.y; y > 0; y--) {
                if(cpmap[y - 1][red.x] == '#' || ((blue.x == red.x) && (y - 1 == blue.y))) {
                    break;
                } else if (cpmap[y - 1][red.x] == 'O') {
                    if(flag == -1) {
                        break;
                    }
                    flag = 1;
                    break;
                } else {
                    red.y -= 1;
                }
            }
        }
        return flag;
    }

    public static int sliding_south() {
        cpmap[blue.y][blue.x] = '.';
        cpmap[red.y][red.x] = '.';
        int flag = 0;
        if(blue.y < red.y) { // 빨강이 먼저 움직인다
            for(int y = red.y; y < N; y++) {
                if(cpmap[y + 1][red.x] == '#') {
                    break;
                } else if (cpmap[y + 1][red.x] == 'O') {
                    red.x = 0;
                    red.y = 0; // 공 없애기
                    flag = 1;
                    break;
                } else {
                    red.y += 1;
                }
            }
            for(int y = blue.y; y < N; y++) {
                if(cpmap[y + 1][blue.x] == '#' || ((blue.x == red.x) && (y + 1 == red.y))) {
                    break;
                } else if (cpmap[y + 1][blue.x] == 'O') {
                    flag = -1;
                    break;
                } else {
                    blue.y += 1;
                }
            }
        }
        else {
            for(int y = blue.y; y < N; y++) {
                if(cpmap[y + 1][blue.x] == '#') {
                    break;
                } else if (cpmap[y + 1][blue.x] == 'O') {
                    blue.x = 0;
                    blue.y = 0; // 공 없애기
                    flag = -1;
                    break;
                } else {
                    blue.y += 1;
                }
            }
            for(int y = red.y; y < N; y++) {
                if(cpmap[y + 1][red.x] == '#' || ((blue.x == red.x) && (y + 1 == blue.y))) {
                    break;
                } else if (cpmap[y + 1][red.x] == 'O') {
                    if(flag == -1) {
                        break;
                    }
                    flag = 1;
                    break;
                } else {
                    red.y += 1;
                }
            }
        }
        return flag;
    }

    public static void print(char[][] map) {
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                if(red.x == i && red.y == j) {
                    System.out.printf("%s", "R");
                } else if (blue.x == i && blue.y == j) {
                    System.out.printf("%s", "B");
                } else {
                    System.out.printf("%s", map[j][i]);
                }
            }
            System.out.println();
        }
        System.out.println("--------");
    }

    public static void copyMap(char[][] map1, char[][] map2) {
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                map1[j][i] = map2[j][i];
            }
        }
    }

    public static void func(int depth, int prev) {
        if(depth >= 10) {
            int val, cnt = 0;
            blue = new Node(save_blue.y, save_blue.x);
            red = new Node(save_red.y, save_red.x);
            copyMap(cpmap, map);
            for (int e : arr) {
                cnt++;
                switch (e) {
                    case 0:
                        val = sliding_north();
                        break;
                    case 1:
                        val = sliding_south();
                        break;
                    case 2:
                        val = sliding_east();
                        break;
                    default:
                        val = sliding_west();
                        break;
                }
                if(val == 1) {
                    min = Math.min(min, cnt);
                    return;
                } else if (val == -1) {
                    return;
                }
            }
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(i == prev) {
                continue;
            }
            arr[depth] = i;
            func(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new char[N][M];
        cpmap = new char[N][M];
        for(int j = 0; j < N; j++) {
            String input = br.readLine();
            for(int i = 0; i < M; i++) {
                char tmp = input.charAt(i);
                if(tmp == 'B') {
                    save_blue = new Node(j, i);
                    blue = new Node(j, i);
                } else if (tmp == 'R') {
                    save_red = new Node(j, i);
                    red = new Node(j, i);
                } else {
                    map[j][i] = input.charAt(i);
                }
            }
        }
        func(0, -1);
        if(min == 99) min = -1;
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}
