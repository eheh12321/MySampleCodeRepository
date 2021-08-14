package CodingTestMemory.BJ.BackTracking.P14889;

import java.util.Scanner;

public class P14889 {
    static int N, min = 99999999;
    static int[][] board;
    static int[] team1, team2;
    static boolean[] visited;
    static int[] arr; // 팀 구분용도

    public static int calcSum(int[] list) {  // 해당 팀의 점수를 계산하는 역할
        int sum = 0;
        for(int j = 0; j < N / 2; j++) {
            for(int i = 0; i < N / 2; i++) {
                if(j == i) {
                    continue;
                }
                sum += board[list[j]][list[i]];
            }
        }
        return sum;
    }

    public static void func(int idx, int depth) {
        if(depth == N / 2) { // 팀이 정해졌다면
            int t1cnt = 0, t2cnt = 0;
            for(int i = 0; i < N; i++) { // 배열로 각각의 팀 구분하기
                if(arr[i] == 1) {
                    team1[t1cnt++] = i;
                } else {
                    team2[t2cnt++] = i;
                }
            }
            int team1_score = calcSum(team1);
            int team2_score = calcSum(team2);
            int diff = Math.abs(team2_score - team1_score); // 차이 = 절댓값
            if(diff < min) {
                min = diff;
            }
            return;
        }

        for(int i = idx; i < N; i++) { // 팀 나누기
            if(!visited[i]) {
                visited[i] = true;
                arr[i] = 1; // 1번 팀은 1, 2번 팀은 0으로서 구분
                func(i + 1, depth + 1);
                visited[i] = false;
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        visited = new boolean[N];
        arr = new int[N];
        team1 = new int[N / 2];
        team2 = new int[N / 2];
        for(int j = 0; j < N; j++) { // 데이터 입력
            for(int i = 0; i < N; i++) {
                board[j][i] = sc.nextInt();
            }
        }
        func(0, 0);
        System.out.println(min);
    }
}
