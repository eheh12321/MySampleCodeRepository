package CodingTestMemory.BJ.Greedy.P1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1931 {

    static class Node implements Comparable<Node> {
        long start, end;
        Node(long start, long end) {
            this.start = start;
            this.end = end;
        }

        // 1. 끝나는 시간이 빠른 순으로
        // 2. 끝나는 시간이 같다면 시작하는 시간이 빠른 순으로 정렬!
        @Override
        public int compareTo(Node o) {
            if(this.end == o.end) {
                return (int)(this.start - o.start);
            }
            return (int)(this.end - o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        Node[] schedule = new Node[N];
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            long st = Integer.parseInt(stk.nextToken());
            long ed = Integer.parseInt(stk.nextToken());
            schedule[i] = new Node(st, ed);
        }
        Arrays.sort(schedule);

        /* 정렬 함수 출력용
        for(Node e : schedule) {
            System.out.printf("[%d %d]\n", e.start, e.end);
        }*/

        int cnt = 0;
        long currTime = 0;
        for(int i = 0; i < N; i++) {
            if(schedule[i].start < currTime) {
                continue;
            }
            System.out.printf("[%d %d]\n", schedule[i].start, schedule[i].end);
            currTime = schedule[i].end;
            cnt++;
        }
        System.out.println(cnt);
    }
}
