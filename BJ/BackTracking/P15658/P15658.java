package CodingTestMemory.BJ.BackTracking.P15658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15658 {

    static int[] nums; // 계산 숫자 배열
    static int[] arr;
    static int[][] operators = new int[4][2]; // 연산자 개수 배열
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static int calc() { // 값을 구하는 메소드
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            switch (arr[i - 1]) {
                case 1:
                    sum += nums[i];
                    break;
                case 2:
                    sum -= nums[i];
                    break;
                case 3:
                    sum *= nums[i];
                    break;
                case 4:
                    sum /= nums[i];
                    break;
            }
        }
        return sum;
    }

    public static void func(int depth, int N) { // 백트래킹으로 모든 경우의 수 탐색
        if(depth == N) {
            int tmp = calc();
            if(tmp > max) { // 최대 / 최소값 체크
                max = tmp;
            }
            if(tmp < min) {
                min = tmp;
            }
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(operators[i][1] > 0) { // 연산자의 개수에 맞게끔 탐색
                arr[depth] = operators[i][0];
                operators[i][1] -= 1;
                func(depth + 1, N);
                operators[i][1] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        arr = new int[N - 1]; // 연산자는 N-1개만 필요하다
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operators[i][0] = i + 1; // 1 (+), 2 (-), 3 (*), 4 (/)
            operators[i][1] = Integer.parseInt(stk.nextToken());
        }
        func(0, N - 1);
        System.out.println(max);
        System.out.println(min);
    }
}
