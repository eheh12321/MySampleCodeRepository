package CodingTestMemory.BJ.BFSDFS.P1707;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707 {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 인접리스트
    static int[] color; // 정점의 색 정보 담을 배열
    static boolean checkBip; // 이분 그래프 유무 체크

    public static boolean bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        color[idx] = 1;
        while(!queue.isEmpty()) {
            int e = queue.poll();
            for(int adjV : list.get(e)) {
                // 방문하지 않은 정점이면
                if(color[adjV] == 0) {
                    color[adjV] = color[e] * -1;
                    queue.add(adjV);
                }
                // 방문한 정점인데, 겹치는 색이 있는 경우는 이분그래프가 아니다
                // (-1 + 1 == 0)이 되어야 정상.
                else if(color[adjV] + color[e] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            // 데이터 입력 및 인접리스트 생성
            list.clear(); // 초기화 필수!
            checkBip = true; // 초기화
            stk = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(stk.nextToken());
            int E = Integer.parseInt(stk.nextToken());
            color = new int[V + 1]; // 1번부터 시작하게
            for(int i = 0; i <= V; i++) {
                list.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++) {
                stk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }
            for(int i = 1; i <= V; i++) {
                if(color[i] == 0) {
                    checkBip = bfs(i);
                }
                if(!checkBip) {
                    break;
                }
            }
            bw.write(checkBip ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}