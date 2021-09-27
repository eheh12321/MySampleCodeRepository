package CodingTestMemory.BJ.DP.P2565;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2565 {

    static int N;
    static class Node {
        int a, b;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static Node[] node;
    static int[] arr;

    public static void func() {
        for(int i = 0; i < N; i++) {
            arr[i] = 1;
            for(int j = 0; j < i; j++) {
                if(node[i].b > node[j].b) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        node = new Node[N];
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            node[i] = new Node(a, b);
        }

        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a - o2.a;
            }
        });

        func();
        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, arr[i]);
        }
        bw.write(N - max + "\n");
        bw.flush();
        bw.close();
    }
}
