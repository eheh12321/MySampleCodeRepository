package CodingTestMemory.BJ.Recur.P1074;

import java.io.*;
import java.util.StringTokenizer;

public class P1074 {

    public static int func(int n, int r, int c) { // r: 행, c: 열
        if(n == 0) { // base condition
            return 0;
        }
        int half = (int)Math.pow(2, n - 1); // 현재 길이의 절반
        if(r < half && c < half) { // 1번 테이블
            return func(n - 1, r, c);
        }
        if(r < half && c >= half) { // 2번 테이블
            return half * half + func(n - 1, r, c - half);
        }
        if(r >= half && c < half) { // 3번 테이블
            return 2 * half * half + func(n - 1, r - half, c);
        }
        return 3 * half * half + func(n - 1, r - half, c - half);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        System.out.println(func(N, r, c));
    }
}
