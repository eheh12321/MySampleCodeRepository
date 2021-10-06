package CodingTestMemory.BJ.Other.P9375;

import java.util.HashMap;
import java.util.Scanner;

public class P9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                String name = sc.next();
                String category = sc.next();
                if(!map.containsKey(category)) {
                    map.put(category, 1);
                } else {
                    map.put(category, map.get(category) + 1);
                }
            }
            int result = 1;
            for (Integer val : map.values()) {
                result *= (val + 1);
            }
            System.out.println(result - 1);
        }
    }
}
