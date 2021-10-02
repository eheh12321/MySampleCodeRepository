package CodingTestMemory.BJ.Greedy.P1541;

import java.util.Arrays;
import java.util.Scanner;

public class P1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = new int[51];
        int[] op = new int[51];

        // 숫자와 연산자 분리해서 저장
        int num, sum = 0, cnt = 0;
        for(int i = 0; i < input.length(); i++) {
            num = (int)input.charAt(i) - 48;
            if(num < 0) {
                op[1 + cnt] = num; // -3: minus, -5: plus.
                nums[cnt++] = sum;
                sum = 0;
                continue;
            }
            sum = sum * 10 + num;
        }
        nums[cnt++] = sum;

        int flag = 0;
        sum = nums[0];
        for(int i = 1; i < cnt; i++) {
            if(op[i] == -3) {
                flag = 1;
            }
            if(flag == 1) {
                sum -= nums[i];
            } else {
                sum += nums[i];
            }
        }
        System.out.println(sum);
    }
}
