package CodingTestMemory.BJ.Greedy.P2138;

import java.util.Arrays;
import java.util.Scanner;

public class P2138 {

    static int N;
    static int[] A;
    static int[] B;
    static int[] tmp;

    public static void push_lamp(int idx) {
        if(idx - 1 >= 0) {
            A[idx - 1] = (A[idx - 1] + 1) % 2;
        }
        if(idx + 1 < N) {
            A[idx + 1] = (A[idx + 1] + 1) % 2;
        }
        A[idx] = (A[idx] + 1) % 2;
    }

    public static int func_PushNo1() {
        int cnt = 1;
        for(int i = 1; i < N; i++) {
            if(A[i - 1] != B[i - 1]) {
                push_lamp(i);
                cnt++;
            }
        }
        return cnt;
    }

    public static int func_NotPushNo1() {
        int cnt = 0;
        for(int i = 1; i < N; i++) {
            if(A[i - 1] != B[i - 1]) {
                push_lamp(i);
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean chk() {
        for(int i = 0; i < N; i++) {
            if(A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        System.out.println(Arrays.toString(A));
        System.out.println("----");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        A = new int[N];
        B = new int[N];
        tmp = new int[N];
        String input = sc.nextLine();
        for(int i = 0; i < N; i++) {
            A[i] = (int)input.charAt(i) - 48;
            tmp[i] = A[i];
        }
        input = sc.nextLine();
        for(int i = 0; i < N; i++) {
            B[i] = (int)input.charAt(i) - 48;
        }
        int min = 10000000;
        // 1. 1번 스위치를 누른 경우
        push_lamp(0);
        int val1 = func_PushNo1();
        if(chk()) {
            min = Math.min(min, val1);
        }

        // 1-2. 초기화
        for(int i = 0; i < N; i++) {
            A[i] = tmp[i];
        }

        // 2. 1번 스위치를 누르지 않은 경우
        int val2 = func_NotPushNo1();
        if(chk()) {
            min = Math.min(min, val2);
        }

        if(min == 10000000) {
            System.out.println("-1");
        } else {
            System.out.println(min);
        }
    }
}
