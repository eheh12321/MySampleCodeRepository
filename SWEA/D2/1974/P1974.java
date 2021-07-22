package D2;

import java.util.Arrays;
import java.util.Scanner;

public class P1974 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().trim());
        int[][] puzzle;
        int[] check;
        int[] ans = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int flag;

        for(int i=0; i<T; i++) {
            puzzle = new int[9][9];
            flag = 1;

            // 스도쿠 채우기
            for(int y=0; y<9; y++) {
                for(int x=0; x<9; x++) {
                    puzzle[y][x] = sc.nextInt();
                }
            }

            // 1. 3x3 내에 겹치는게 없는지 체크
            for(int y=0; y<9; y+=3) {
                if(flag == 0) {
                    break;
                }
                for(int x=0; x<9; x+=3) {
                    check = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
                    for(int a=0; a<3; a++) {
                        for(int b=0; b<3; b++) {
                            check[puzzle[y+a][x+b]-1] -= 1;
                        }
                    }
                    if(!Arrays.equals(check, ans)) {
                        flag = 0;
                        break;
                    }
                }
            }

            // 2. 가로 줄에 겹치는게 없는지 체크
            for(int y=0; y<9; y++) {
                if(flag == 0) {
                    break;
                }
                check = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
                for(int x=0; x<9; x++) {
                    check[puzzle[y][x]-1] -= 1;
                }
                if(!Arrays.equals(ans, check)) {
                    flag = 0;
                    break;
                }
            }

            // 3. 세로줄 체크
            for(int x=0; x<9; x++) {
                if(flag == 0) {
                    break;
                }
                check = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
                for(int y=0; y<9; y++) {
                    check[puzzle[y][x] - 1] -= 1;
                }
                if(!Arrays.equals(ans, check)) {
                    flag = 0;
                    break;
                }
            }

            System.out.printf("#%d %d\n", i+1, flag);
        }
    }
}
