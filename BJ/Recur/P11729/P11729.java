package CodingTestMemory.BJ.Recur.P11729;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P11729 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void hanoi(int start, int dest, int N) throws IOException {
        if(N == 1) { // base case
            bw.write(String.valueOf(start) + " " + String.valueOf(dest));
            bw.newLine();
            return;
        }
        int mid = 6 - start - dest;
        hanoi(start, mid, N - 1);
        bw.write(String.valueOf(start) + " " + String.valueOf(dest));
        bw.newLine();
        hanoi(mid, dest, N - 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        bw.write(String.valueOf((int)Math.pow(2, N) - 1));
        bw.newLine();
        hanoi(1, 3, N);
        bw.flush();
        bw.close();
    }
}
