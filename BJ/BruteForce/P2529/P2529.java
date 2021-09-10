package CodingTestMemory.BJ.BruteForce.P2529;

import java.util.Arrays;
import java.util.Scanner;

public class P2529 {

    static int N;
    static int cnt = 0;
    static String min, max;
    static char[] arr = new char[10];
    static int[] nums;
    static boolean[] visited = new boolean[10];

    public static void func(int depth) {
        if(depth == N + 1) { // 부등호의 개수가 N개이므로 depth는 N + 1까지 내려가야함
            if(cnt == 0) { // 제일 처음 나온 배열이 최솟값이 됨으로 String min에 저장
                min = Arrays.toString(nums);
            }
            cnt++;
            max = Arrays.toString(nums); // 제일 마지막에 나온 배열이 최댓값이 됨으로 Sting max에 저장
            return;
        }
        for(int i = 0; i <= 9; i++) { // 백트래킹
            if(!visited[i]) {
                if(depth > 0 && arr[depth - 1] == '<') { // 부등호에 따른 조건 체크
                    if(nums[depth - 1] > i) {
                        continue;
                    }
                } else if (depth > 0 && arr[depth - 1] == '>') { // 더 깔끔한 방법이 있을 것 같긴 한데 모르겠다
                    if(nums[depth - 1] < i) {
                        continue;
                    }
                 }
                visited[i] = true;
                nums[depth] = i;
                func(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N + 1];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.next().charAt(0);
        }

        // 메인
        func(0);

        // 출력
        String[] output = max.replace("[", "").replace("]", "").split(", ");
        for (String s : output) {
            System.out.printf("%s", s);
        }
        System.out.println();
        output = min.replace("[", "").replace("]", "").split(", ");
        for (String s : output) {
            System.out.printf("%s", s);
        }
    }
}
