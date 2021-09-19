package CodingTestMemory.BJ.BFSDFS.P14502;

import java.io.*;
import java.util.*;

public class P14502 {

    public static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, max, max_area = 0;
    static int[][] map;
    static boolean[][] visited;
    static Node[] walls = new Node[3];
    static List<Node> virus = new ArrayList<>();
    static int[] arr = new int[3];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void init_wall() {
        int cnt = 0;
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                if(map[j][i] == 0) {
                    walls[cnt++] = new Node(j, i);
                    map[j][i] = 3; // 임의로 지은 벽은 3으로 표시
                    if(cnt == 3) {
                        return;
                    }
                }
            }
        }
    }
    
    // 총 이동가능 횟수.
    public static int calc_time() {
        int x = walls[2].x;
        int y = walls[2].y;
        int cnt = 0;
        while(true) {
            x += 1;
            if(x >= M) {
                x = 0;
                y += 1;
                if(y >= N) {
                    return cnt;
                }
            }
            if(map[y][x] == 0) {
                cnt += 1;
            }
        }
    }

    // 벽 움직이기
    public static void move_walls(int cnt) {
        int x = walls[cnt].x;
        int y = walls[cnt].y;
        while(map[y][x] != 0) {
            x += 1;
            if(x >= M) {
                x = 0;
                y += 1;
                if(y >= N) {
                    return;
                }
            }
        }
        map[walls[cnt].y][walls[cnt].x] = 0; // 기존 벽 부수고
        walls[cnt] = new Node(y, x);
        map[y][x] = 3; // 새로 이동함.
    }

    public static void bfs(Node start) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        while(!queue.isEmpty()) {
            Node e = queue.poll();
            visited[e.y][e.x] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + e.x;
                int ny = dy[i] + e.y;
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue; // OutOfBounds
                }
                if(map[ny][nx] != 0) {
                    continue; // 벽은 지나갈 수 없음. + 바이러스끼리 못뚫음
                }
                if(visited[ny][nx]) {
                    continue; // 이미 지나간데도 갈 수 없음
                }
                queue.add(new Node(ny, nx));
                visited[ny][nx] = true;
            }
        }
    }

    public static int calc_safeArea() {
        int cnt = 0;
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                if(!visited[j][i] && map[j][i] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void backtracking(int depth) {
        if(depth == 3) {
            // 벽 움직이고
            for(int i = 2; i >= 0; i--) {
                for(int j = 0; j < arr[i]; j++) {
                    move_walls(i);
                }
            }
            // BFS 찍고
            visited = new boolean[N][M];
            for (Node node : virus) {
                bfs(node);
            }
            max_area =  Math.max(max_area, calc_safeArea());
            // 다음을 위해 벽 초기화
            for(int i = 0; i < 3; i++) {
                map[walls[i].y][walls[i].x] = 0;
            }
            init_wall();
            return;
        }
        for(int i = 0; i <= max; i++) {
            arr[depth] = i;
            backtracking(depth + 1);
        }
    }

    public static void print() {
        for(int j = 0; j < N; j++) {
            System.out.println(Arrays.toString(map[j]));
        }
        System.out.println("-------");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }
        init_wall();
        max = calc_time();
        backtracking(0);

        bw.write(max_area + "\n");
        bw.flush();
        bw.close();
    }
}
