package CodingTestMemory.BJ.Silv4.P11653;

import java.io.*;

public class P11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int div = 2;
        while(N >= div) {
            while(N % div != 0) {
                div += 1;
            }
            bw.write(String.valueOf(div) + "\n");
            N /= div;
        }
        bw.flush();
        bw.close();
    }
}
