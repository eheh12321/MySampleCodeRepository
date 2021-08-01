package CodingTestMemory.BJ.Silv4.P2217;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxWeight, W;
        Integer[] weight = new Integer[N];
        for(int i=0; i<N; i++) {
            weight[i] = sc.nextInt();
        }
        Arrays.sort(weight, Collections.reverseOrder());
        W = maxWeight = weight[0];
        for(int i=1; i<N; i++) {
            if(maxWeight < weight[i] * (i + 1)) {
                maxWeight = weight[i] * (i + 1);
            }
        }
        System.out.println(maxWeight);
    }
}
