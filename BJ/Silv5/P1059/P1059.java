package CodingTestMemory.BJ.Silv5.P1059;

import java.util.Arrays;
import java.util.Scanner;

public class P1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int[] arr = new int[L];
        for(int i=0; i<L; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        Arrays.sort(arr);
        int min = 0, max = arr[0];
        for(int i=0; i<L-1; i++) {
            if(arr[i] == n) {
                System.out.println("0");
                System.exit(0);
            }
            if(arr[i] < n && min < arr[i]){
                min = arr[i];
                max = arr[i+1];
            }
        }
        max -= 1;
        min += 1;
        System.out.println((max - n + 1) * (n - min) + (max - n));
    }
}
