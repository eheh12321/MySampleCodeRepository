package CodingTestMemory.자료구조.Graph.AdjList;

import java.io.*;
import java.util.ArrayList;

public class MainClass { // 가중치가 없는 그래프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 노드의 개수
        int m = Integer.parseInt(str[1]); // 간선의 개수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) { // 1번 노드부터 시작함
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int n1 = Integer.parseInt(str[0]);
            int n2 = Integer.parseInt(str[1]);

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        for(int i = 1; i <= n; i++) {
            bw.write(graph.get(i).toString());
        }
        bw.flush();
        bw.close();
    }
}
