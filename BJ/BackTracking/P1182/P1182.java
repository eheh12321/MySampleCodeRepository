package CodingTestMemory.BJ.BackTracking.P1182;

import java.util.Arrays;
import java.util.Scanner;

public class P1182 {

    static int N, S, cnt = 0, ans = 0;
    static int[] elements;
    static int[] arr;
    static boolean[] visited;

    public static int total(int[] calc) {
        int sum = 0;
        for(int i = 0; i < cnt; i++) {
            sum += calc[i];
        }
        return sum;
    }

    public static void func(int idx) {
        if(idx == N || cnt == N) {
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i])
            {
                visited[i] = true;
                arr[cnt++] = elements[i];
                if(total(arr) == S) {
                    ans++;
                }
                func(i + 1);
                visited[i] = false;
                arr[--cnt] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        elements = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            elements[i] = sc.nextInt();
        }
        func(0);
        System.out.println(ans);
    }
}
