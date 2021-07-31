package CodingTestMemory.BJ.Silv4.P10815;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class P10815 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int[] sangArr = new int[N];
        for(int i=0; i<N; i++) {
            sangArr[i] = sc.nextInt();
        }
        Arrays.sort(sangArr);
        int M = sc.nextInt();
        int num;
        for(int i=0; i<M; i++) {
            num = sc.nextInt();
            if(Arrays.binarySearch(sangArr, num) >= 0) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
    }
}
