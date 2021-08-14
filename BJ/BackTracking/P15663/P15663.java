package CodingTestMemory.BJ.BackTracking.P15663;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15663 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static int[] numArr;
    static int[] ans;
    static int N, M, cnt = 0;

    public static void func(int depth) throws IOException {
        if(depth == M) {
            for(int e : ans) {
                bw.write(String.valueOf(e) + " ");
            }
            bw.newLine();
            return;
        }
        int prev = -1; // 이전값을 저장해두기 위한 변수
        for(int i = 0; i < cnt; i++) {
            if(!visited[i] && prev != numArr[i]) { // 이전값과 현재값이 같으면 건너뛴다
                visited[i] = true;
                ans[depth] = numArr[i];
                prev = ans[depth];
                func(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        ans = new int[M];
        numArr = new int[N];
        visited = new boolean[N];
        int tmp;

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) { // 데이터 입력
            tmp = Integer.parseInt(stk.nextToken());
            numArr[cnt++] = tmp;
        }
        Arrays.sort(numArr); // 데이터 배열 정렬

        func(0);

        bw.flush();
        bw.close();
    }
}
