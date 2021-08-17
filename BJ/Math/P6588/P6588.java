package CodingTestMemory.BJ.Math.P6588;

import java.io.*;
import java.util.Scanner;

public class P6588 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt = 0;
    static int[] numArr = new int[1000001];
    static int[] primeArr = new int[1000001];

    public static void findPrimenumber() {
        for(int i = 2; i <= 1000000; i++) { // 0: 소수 1: 소수 아님
            if(numArr[i] == 1) { // 소수가 아니면 패스
                continue;
            }
            primeArr[cnt++] = i;
            for(int j = i + i; j <= 1000000; j += i) { // 현 위치가 소수이면 해당 값의 배수를 모두 처리
                numArr[j] = 1;
            }
        }
    } // 에라토스테네스의 채

    public static void func(int N) throws IOException {
        int tmp, tailidx = cnt - 1;
        for(int i = 0; i < cnt; i++) {
            if(primeArr[i] > N) { // N보다 한칸 작은
                tailidx = i - 1;
                break;
            }
        }
        int i = 0;
        while(i <= tailidx) {
            tmp = primeArr[i] + primeArr[tailidx];
            if(tmp > N) {
                i = 0;
                tailidx -= 1;
                continue;
            }
            if(tmp == N) {
                bw.write(String.valueOf(N) + " = " + String.valueOf(primeArr[i])
                        + " + " +String.valueOf(primeArr[tailidx]));
                bw.newLine();
                return;
            }
            i += 1;
        }
        bw.write("Goldbach's conjecture is wrong.");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        findPrimenumber();
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            func(N);
        }
        bw.flush();
        bw.close();
    }
}

