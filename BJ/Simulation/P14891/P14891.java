package CodingTestMemory.BJ.Simulation.P14891;

import java.io.*;
import java.util.*;

public class P14891 {

    static List<Deque<Integer>> list = new ArrayList<>();

    // 2번 - 오른쪽과 마추보는 인덱스 && 6번 - 왼쪽과 마주보는 인덱스
    // 시계방향 회전
    public static void rotate_clock(int idx) {
        int tmp = list.get(idx).pollLast();
        list.get(idx).addFirst(tmp);
    }

    // 반시계방향 회전
    public static void rotate_reverse(int idx) {
        int tmp = list.get(idx).pollFirst();
        list.get(idx).addLast(tmp);
    }

    static boolean[] visited = new boolean[4];

    public static void func(int idx, int dir) {
        if(idx < 0 || idx > 4) {
            return;
        }
        if(visited[idx]) {
            return;
        }
        visited[idx] = true;
        // 양옆 체크
        Iterator<Integer> descIter = list.get(idx).descendingIterator();
        Iterator<Integer> iter = list.get(idx).iterator();
        iter.next();
        iter.next();
        int right = iter.next();
        descIter.next();
        int left = descIter.next();
        if(idx - 1 >= 0) { // left
            iter = list.get(idx - 1).iterator();
            iter.next();
            iter.next();
            int e = iter.next();
            if(e != left) { // 서로 달라야 움직인다
                func(idx - 1, dir * -1);
            }
        }
        if(idx + 1 < 4) { // right
            descIter = list.get(idx + 1).descendingIterator();
            descIter.next();
            int e = descIter.next();
            if(e != right) {
                func(idx + 1, dir * -1);
            }
        }
        if(dir == 1) {
            rotate_clock(idx);
        } else {
            rotate_reverse(idx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        for(int i = 0; i < 4; i++) {
            list.add(new ArrayDeque<>());
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                list.get(i).addLast(input.charAt(j) - 48);
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            stk = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(stk.nextToken());
            int dir = Integer.parseInt(stk.nextToken());
            func(idx - 1, dir);
            Arrays.fill(visited, false);
        }

        int sum = 0;
        if(list.get(0).peekFirst() == 1) sum += 1;
        if(list.get(1).peekFirst() == 1) sum += 2;
        if(list.get(2).peekFirst() == 1) sum += 4;
        if(list.get(3).peekFirst() == 1) sum += 8;

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
