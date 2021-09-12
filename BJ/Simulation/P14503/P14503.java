package CodingTestMemory.BJ.Simulation.P14503;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14503 {

    public static class Node {
        int x, y, dir;
        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int N, M;
    static int cnt;
    static int[][] map;
    static boolean[][] visited;

    public static void func(int st_x, int st_y, int st_dir) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(st_x, st_y, st_dir));
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            if(!visited[e.y][e.x]) { // 아직 청소를 하지 않은 점이라면
                visited[e.y][e.x] = true; // 1. 현재 위치를 청소한다
                cnt++;
            }
            int flag = 0; // 네 방향 중에 청소할 부분이 있는지 유무 체크용
            int dir = e.dir; // 현재 바라보고 있는 방향
            for(int i = 0; i < 4; i++) { // 4방향을 모두 돌아본다
                int nx = e.x, ny = e.y;
                dir = (dir + 3) % 4; // 현재 바라보는 방향에서 왼쪽방향부터 탐색 (북->서->남->동)

                switch (dir) { // 방향 잡기
                    case 0: // 북
                        ny -= 1;
                        break;
                    case 1: // 동
                        nx += 1;
                        break;
                    case 2: // 남
                        ny += 1;
                        break;
                    default: // 서
                        nx -= 1;
                        break;
                }
                if(map[ny][nx] == 1 || visited[ny][nx]) { // 벽이거나, 이미 청소를 했다면
                    continue;
                }
                queue.add(new Node(nx, ny, dir));
                flag = 1; // 청소할 곳이 있다
                break;
            }
            if(flag == 0) { // 4방향 모두 청소할 곳이 없으면
                int nx = e.x, ny = e.y;
                switch (e.dir) { // 방향을 유지한 채로 한칸 후진
                    case 0: // 북(-> 남)
                        ny += 1;
                        break;
                    case 1: // 동(-> 서)
                        nx -= 1;
                        break;
                    case 2: // 남
                        ny -= 1;
                        break;
                    default: // 서
                        nx += 1;
                        break;
                }
                if(map[ny][nx] == 1) { // 후진할 곳이 벽이면
                    return;
                }
                queue.add(new Node(nx, ny, e.dir));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        stk = new StringTokenizer(br.readLine()); // 로봇청소기 출발 위치정보
        int start_y = Integer.parseInt(stk.nextToken());
        int start_x = Integer.parseInt(stk.nextToken());
        int start_dir = Integer.parseInt(stk.nextToken());

        for(int j = 0; j < N; j++) { // 지도 정보
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                map[j][i] = Integer.parseInt(stk.nextToken());
            }
        }

        func(start_x, start_y, start_dir);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
