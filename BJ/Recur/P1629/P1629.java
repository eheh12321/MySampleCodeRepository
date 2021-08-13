package CodingTestMemory.BJ.Recur.P1629;

import java.io.*;
import java.util.StringTokenizer;

public class P1629 {

    public static long func(long a, long b, long c) {
        if(b == 1) { // base condition
            return a % c;
        }
        long e = func(a, b / 2, c); // ex) 10 = 5 + 5
        e = (e * e) % c;
        if(b % 2 == 0) { // 지수가 짝수이면
            return e;
        } else { // 지수가 홀수이면 (ex. 5 = 4 + 1)
            return (e * a) % c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(stk.nextToken());
        long B = Integer.parseInt(stk.nextToken());
        long C = Integer.parseInt(stk.nextToken());

        bw.write(String.valueOf(func(A, B, C)));
        bw.flush();
        bw.close();
    }
}
