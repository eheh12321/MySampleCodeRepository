package CodingTestMemory.BJ.BackTracking.P1759;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, C;
    static char[] wordArr;
    static char[] selected;
    static boolean[] visited;

    public static boolean checkPw(char[] list) {
        char[] mother = {'a', 'e', 'i', 'o', 'u'};
        int mcnt = 0, cnt = 0;
        for(int i = 0; i < L; i++) {
            for(int j = 0; j < 5; j++) {
                if(mother[j] == list[i]) {
                    mcnt++;
                }
            }
        }
        cnt = L - mcnt;
        if(mcnt >= 1 && cnt >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void func(int idx, int depth) throws IOException {
        if(depth == L) {
            if(!checkPw(selected)) {
                return;
            }
            for(char e : selected) {
                bw.write(String.valueOf(e));
            }
            bw.newLine();
            return;
        }
        for(int i = idx; i < C; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[depth] = wordArr[i];
                func(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        L = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        wordArr = new char[C];
        visited = new boolean[C];
        selected = new char[L];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            wordArr[i] = stk.nextToken().charAt(0);
        }
        Arrays.sort(wordArr);
        func(0, 0);
        bw.flush();
        bw.close();
    }
}
