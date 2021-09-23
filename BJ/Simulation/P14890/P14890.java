package CodingTestMemory.BJ.Simulation.P14890;

import java.io.*;
import java.util.StringTokenizer;

public class P14890 {

    static int N, L;
    static int[][] map;

    public static int func_garo() {
        int flag, cnt = 0;
        for(int y = 0; y < N; y++) {
            flag = 1;
            boolean[] slope = new boolean[N];
            for(int x = 1; x < N; x++) {
                if(flag == 0) break;
                // 높이 차가 있다 -> 경사로가 필요하다
                if(map[y][x - 1] != map[y][x]) {
                    // 높이차가 1칸 이상이면 불가능
                    if(Math.abs(map[y][x - 1] - map[y][x]) > 1) {
                        flag = 0;
                        break;
                    }
                    // 올라가는 경우 - 뒤쪽에 경사로가 있어야함
                    if(map[y][x - 1] < map[y][x]) {
                        // 경사로가 이미 있으면
                        if(slope[x - 1]) {
                            flag = 0;
                            break;
                        }
                        slope[x - 1] = true;
                        for(int k = 1; k < L; k++) {
                            // 경사로를 놓을 구간이 평평하지 않으면 or 길이가 없으면 or 이미 경사로가 있으면
                            if(x - 1 - k < 0 || map[y][x - 1] != map[y][x - 1 - k] || slope[x - 1 - k]) {
                                flag = 0;
                                break;
                            }
                            slope[x - 1 - k] = true;
                        }
                    }

                    // 내려가는 경우 - 앞쪽에 경사로가 있어야함
                    else {
                        // 경사로가 이미 있으면
                        if(slope[x]) {
                            flag = 0;
                            break;
                        }
                        slope[x] = true;
                        for(int k = 1; k < L; k++) {
                            // 경사로를 놓을 구간이 평평하지 않으면 or 길이가 없으면
                            if(x + k >= N || map[y][x] != map[y][x + k] || slope[x + k]) {
                                flag = 0;
                                break;
                            }
                            slope[x + k] = true;
                        }
                    }
                }
            }
            if(flag == 1) cnt++;
        }
        return cnt;
    }

    public static int func_sero() {
        int flag, cnt = 0;
        for(int x = 0; x < N; x++) {
            flag = 1;
            boolean[] slope = new boolean[N];
            for(int y = 1; y < N; y++) {
                if(flag == 0) break;
                // 높이차가 있는경우
                if(map[y - 1][x] != map[y][x]) {
                    // 높이차가 1칸 이상
                    if(Math.abs(map[y][x] - map[y - 1][x]) > 1) {
                        flag = 0;
                        break;
                    }
                    // 올라가는 경우 -- 뒤쪽에 경사로
                    if(map[y - 1][x] < map[y][x]) {
                        // 경사로가 이미 있으면?
                        if(slope[y - 1]) {
                            flag = 0;
                            break;
                        }
                        slope[y - 1] = true;
                        for(int k = 1; k < L; k++) {
                            if(y - 1 - k < 0 || map[y - 1][x] != map[y - 1 - k][x] || slope[y - 1 - k]) {
                                flag = 0;
                                break;
                            }
                            slope[y - 1 - k] = true;
                        }
                    }
                    // 내려가는 경우 -- 앞쪽에 경사로
                    else {
                        // 경사로가 이미 있으면
                        if(slope[y]) {
                            flag = 0;
                            break;
                        }
                        slope[y] = true;
                        for(int k = 1; k < L; k++) {
                            if(y + k >= N || map[y][x] != map[y + k][x] || slope[y + k]) {
                                flag = 0;
                                break;
                            }
                            slope[y + k] = true;
                        }
                    }
                }
            }
            if(flag == 1) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        map = new int[N][N];
        for(int j = 0; j < N; j++) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                map[j][i] = Integer.parseInt(stk.nextToken());
            }
        }
        int garo = func_garo();
        int sero = func_sero();
        bw.write(garo + sero + "\n");
        bw.flush();
        bw.close();
    }
}
