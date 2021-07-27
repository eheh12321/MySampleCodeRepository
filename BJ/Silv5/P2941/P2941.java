package CodingTestMemory.BJ.Silv5.P2941;

import java.util.Arrays;
import java.util.Scanner;

public class P2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] list_2 = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
        String[] list_3 = {"dz="};
        String word = sc.nextLine();
        String part_2;
        String part_3;
        int cnt = 0;
        int idx = 0;
        while(idx < word.length()) {
            if(idx + 3 <= word.length()) {
                part_3 = word.substring(idx, idx + 3);
                if(Arrays.asList(list_3).contains(part_3)) {
                    cnt += 1;
                    idx += 3;
                    continue;
                }
            }
            if (idx + 2 <= word.length()) {
                part_2 = word.substring(idx, idx + 2);
                if (Arrays.asList(list_2).contains(part_2)) {
                    cnt += 1;
                    idx += 2;
                    continue;
                }
            }
            cnt += 1;
            idx += 1;
        }
        System.out.println(cnt);
    }
}
