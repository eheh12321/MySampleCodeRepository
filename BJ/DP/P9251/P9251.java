package CodingTestMemory.BJ.DP.P9251;

import java.io.*;

public class P9251 {

    static int N;
    static String a, b;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = br.readLine();
        b = br.readLine();
        dp = new int[b.length() + 1][a.length() + 1];

        func();

        bw.write(dp[b.length()][a.length()] + "\n");
        bw.flush();
        bw.close();
    }

    public static void func() {
        for(int j = 1; j <= b.length(); j++) {
            for(int i = 1; i <= a.length(); i++) {
                if(b.charAt(j - 1) != a.charAt(i - 1)) {
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j - 1][i]);
                } else {
                    dp[j][i] = dp[j - 1][i - 1] + 1;
                }
            }
        }
    }

}
