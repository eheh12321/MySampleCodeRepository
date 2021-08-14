package CodingTestMemory.BJ.BackTracking.P14888;

import java.util.Scanner;

public class P14888 {
    static int N;
    static int[] numArr; // 계산할 숫자가 들어있는 배열
    static int[] operatorSet; // 1.덧셈 2.뻴샘 3.곱셈 4.나눗셈
    static int[] selectedSet; // 백트래킹으로 선택된 배열
    static boolean[] visited; // 백트래킹에 쓸 용도
    static long max = Integer.MIN_VALUE;
    static long min = Integer.MAX_VALUE;

    public static void func(int depth) {
        if(depth == N - 1) {
            int sum = numArr[0];
            int cnt = 1;
            for(int e : selectedSet) {
                if(e == 1) {
                    sum += numArr[cnt++];
                } else if(e == 2) {
                    sum -= numArr[cnt++];
                } else if(e == 3) {
                    sum *= numArr[cnt++];
                } else {
                    sum /= numArr[cnt++];
                }
            }
            if(max < sum) {
                max = sum;
            }
            if(min > sum) {
                min = sum;
            }
            return;
        }
        int prev = -1;
        for(int i = 0; i < N - 1; i++) {
            if(!visited[i] && prev != operatorSet[i]) {
                visited[i] = true;
                selectedSet[depth] = operatorSet[i];
                prev = operatorSet[i];
                func(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numArr = new int[N];
        visited = new boolean[N - 1];
        selectedSet = new int[N - 1];
        operatorSet = new int[N - 1];
        int operator[] = new int[4];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
            for(int j = 0; j < operator[i]; j++) {
                operatorSet[cnt++] = i + 1;
            }
        }
        func(0);
        System.out.println(max);
        System.out.println(min);
    }
}
