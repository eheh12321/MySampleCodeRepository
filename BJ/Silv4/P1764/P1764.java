package CodingTestMemory.BJ.Silv4.P1764;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;
        sc.nextLine(); // 버퍼 비우기
        Stack<String> stack = new Stack<>();
        String[] notHear = new String[N];
        String notSee;
        for(int i=0; i<N; i++) {
            notHear[i] = sc.nextLine();
        }
        Arrays.sort(notHear);
        for(int i=0; i<M; i++) {
            notSee = sc.nextLine();
            if (Arrays.binarySearch(notHear, notSee) >= 0) {
                stack.add(notSee);
            }
        }
        cnt = stack.size();
        System.out.println(cnt);
        String[] notHearAndSee = new String[cnt];
        for(int i=0; i<cnt; i++) {
            notHearAndSee[i] = stack.pop();
        }
        Arrays.sort(notHearAndSee);
        for(int i=0; i<cnt; i++) {
            System.out.println(notHearAndSee[i]);
        }
    }
}
