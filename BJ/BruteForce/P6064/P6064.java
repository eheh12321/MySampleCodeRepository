package CodingTestMemory.BJ.BruteForce.P6064;

import java.io.*;
import java.util.StringTokenizer;

public class P6064 {

    public static int gcd(int num1, int num2) {
        if(num1 < num2) { // num1 > num2로 맞춰줘야함
            int tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }

    public static int func(int M, int N, int x, int y) {
        int max_year = M * N / gcd(M, N); // 최대 년수는 최소공배수만큼
        int a = 0, b = 0;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            stk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stk.nextToken());
            int N = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            bw.write(String.valueOf(func(M, N, x, y)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
