package CodingTestMemory.BJ.Math.P13458;

import java.io.*;
import java.util.StringTokenizer;

public class P13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        long cnt = 0;
        // 메인
        for(int i = 0; i < N; i++) {
            nums[i] -= B; // 한 방에 총감독 1명은 반드시 있어야함
            cnt += 1;
            if(nums[i] <= 0) { // 총감독으로 충분하면 더 볼필요 없음
                continue;
            }
            cnt += (int)Math.ceil((double)nums[i] / C); // 나누기-올림으로 합 계산
        }
        
        // 출력
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
