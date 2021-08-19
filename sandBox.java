package CodingTestMemory;

import java.io.*;
import java.util.StringTokenizer;

public class sandBox {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int Asize = Integer.parseInt(stk.nextToken());
        int Bsize = Integer.parseInt(stk.nextToken());
        int[] A = new int[Asize];
        int[] B = new int[Bsize];
        int[] C = new int[Asize + Bsize];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < Asize; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < Bsize; i++) {
            B[i] = Integer.parseInt(stk.nextToken());
        }
        int Aidx = 0, Bidx = 0, cnt = 0;
        while(Aidx != Asize && Bidx != Bsize) {
            if(A[Aidx] < B[Bidx]) {
                C[cnt++] = A[Aidx++];
            } else {
                C[cnt++] = B[Bidx++];
            }
        }
        while(Aidx != Asize) {
            C[cnt++] = A[Aidx++];
        }
        while(Bidx != Bsize) {
            C[cnt++] = B[Bidx++];
        }
        for(int e : C) {
            bw.write(String.valueOf(e) + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}