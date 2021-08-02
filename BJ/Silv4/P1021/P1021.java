package CodingTestMemory.BJ.Silv4.P1021;

import java.util.*;

public class P1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> deque = new LinkedList<>();
        int cnt = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();
        for(int i=1; i<=N; i++) {
            deque.offer(i);
        }
        int[] seq = new int[M];
        for(int i=0; i<M; i++) {
            seq[i] = sc.nextInt();
        }
        for(int i=0; i<M; i++) {
            int idx = deque.indexOf(seq[i]);
            int half_idx;
            if(deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            } else {
                half_idx = deque.size() / 2;
            }
            if(idx <= half_idx) { // 절반보다 앞에있는 경우
                for(int j=0; j<idx; j++) {
                    int tmp = deque.removeFirst();
                    deque.offerLast(tmp);
                    cnt++;
                }
            } else { // 절반보다 뒤에있는 경우
                for(int j=0; j<deque.size() - idx; j++) {
                    int tmp = deque.removeLast();
                    deque.offerFirst(tmp);
                    cnt++;
                }
            }
            deque.removeFirst(); // 젤 앞에있는거 팝
        }
        System.out.println(cnt);
    }
}
