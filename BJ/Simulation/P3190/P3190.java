package CodingTestMemory.BJ.Simulation.P3190;

import java.io.*;
import java.util.*;

public class P3190 {

    public static class Direction_info {
        int cnt;
        String direction;

        public Direction_info(int cnt, String direction) {
            this.cnt = cnt;
            this.direction = direction;
        }
    }

    public static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int apples; // 사과 남은 개수
    static int time; // 총 진행 시간
    static int[][] map;
    static Queue<Direction_info> queue = new LinkedList<>(); // 방향 변환 시점 쌓아놓는 큐
    static Deque<Node> snake = new LinkedList<>(); // 뱀의 모양 구현(덱) - 머리(addFirst) / 꼬리(pollLast)

    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    public static void func() {
        // 0. 초기 뱀의 정보
        int direction = RIGHT;
        snake.addFirst(new Node(0, 0));
        Direction_info change_direction = queue.poll();

        while(true) {
            // 1. 뱀은 몸 길이를 늘려 머리를 다음칸에 위치시킨다.
            Node head = snake.peekFirst();
            // 2. 방향 전환시점에는 방향을 전환한다
            if(change_direction.cnt == time) {
                if(change_direction.direction.equals("D")) { // 시계방향 회전
                    direction = (direction + 1) % 4;
                } else { // 반시계방향 회전
                    direction = (direction + 3) % 4;
                }
                if(!queue.isEmpty()) { // 큐가 비었을때 poll 하면 에러 터짐.
                    change_direction = queue.poll();
                }
            }
            int nx = head.x, ny = head.y;
            switch (direction) {
                case UP:
                    ny -= 1;
                    break;
                case DOWN:
                    ny += 1;
                    break;
                case LEFT:
                    nx -= 1;
                    break;
                default: // Right
                    nx += 1;
                    break;
            }
            if(ny < 0 || nx < 0 || ny >= N || nx >= N) {
                return; // OutOfBounds
            }
            if(map[ny][nx] == 5) {
                return; // 뱀에 부딛힌 경우 Out
            }
            if(map[ny][nx] == 1) { // 사과가 있을 경우
                map[ny][nx] = 5; // 사과 먹고 끝
            } else { // 사과가 없는 경우
                Node tail = snake.pollLast();
                map[ny][nx] = 5; // 머리도 찍고
                map[tail.y][tail.x] = 0; // 꼬리를 한칸 줄인다.
            }
            snake.addFirst(new Node(ny, nx));
            time++;
//            for(int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println("-----");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        map[0][0] = 5; // 뱀이 있는 위치는 '5'로 찍는다

        apples = Integer.parseInt(br.readLine());
        for(int i = 0; i < apples; i++) { // 사과 위치 찍기
            stk = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            map[y - 1][x - 1] = 1; // 1 - index -> 0 - index
        }

        int tmp = Integer.parseInt(br.readLine());
        for(int i = 0; i < tmp; i++) { // 방향 전환 정보 담기
            stk = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(stk.nextToken());
            String dir = stk.nextToken();
            queue.add(new Direction_info(cnt, dir));
        }

        func();
        
        bw.write((time + 1) + "\n");
        bw.flush();
        bw.close();
    }
}
