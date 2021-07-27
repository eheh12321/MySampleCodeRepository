package CodingTestMemory.BJ.Silv5.P4673;

import java.util.Arrays;

public class P4673 {
    static int calc(int num) {
        int sum = num;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[10001];
        int num;
        for(int i=1; i<=10000; i++) {
            if(arr[i]==1) {
                continue;
            }
            System.out.println(i);
            num = calc(i);
            while(num <= 10000) {
                arr[num] = 1;
                num = calc(num);
            }
        }
    }
}
