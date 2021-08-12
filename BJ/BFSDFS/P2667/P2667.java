package CodingTestMemory.BJ.BFSDFS.P2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {

    static class Node {
        int y, x;
        Node (int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;

    public static int bfs(int y, int x) {
        int cnt = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            Node e = queue.poll();
            cnt++;
            for(int i = 0; i < 4; i++) {
                int nx = e.x + dx[i];
                int ny = e.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if(visited[ny][nx] || graph[ny][nx] == 0) {
                    continue;
                }
                visited[ny][nx] = true;
                queue.add(new Node(ny, nx));
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String input;

        graph = new int[N][N];
        visited = new boolean[N][N];
        List list = new LinkedList();

        for(int j = 0; j < N; j++) { // 데이터 입력
            input = br.readLine();
            for(int i = 0; i < input.length(); i++) {
                graph[j][i] = (int) input.charAt(i) - 48;
            }
        }
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < N; i++) { // 시작점 탐색 후 bfs
                if(graph[j][i] == 1 && !visited[j][i]) {
                    list.add(bfs(j, i));
                }
            }
        }
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int)o1 - (int) o2;
            }
        });
        //Collections.sort(list); // 연결리스트를 정렬하기 위해서는 Collections.sort 를 사용하면 더 편리

        System.out.println(list.size()); // 결과 출력부분
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
