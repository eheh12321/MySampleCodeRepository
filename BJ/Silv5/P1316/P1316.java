package CodingTestMemory.BJ.Silv5.P1316;

import java.util.Scanner;

public class P1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int len = (int)'z' - (int)'a';
        int[] arr;
        int flag, cnt = 0;
        String word;
        for(int t=0; t<T; t++) {
            arr = new int[len+1];
            word = sc.nextLine();
            flag = 0;
            for(int i=0; i<word.length(); i++) {
                int idx = (int)word.charAt(i) - (int)'a';
                if(arr[idx] != 0) {
                    flag = 1;
                    break;
                } else {
                    arr[idx] = 1;
                    while(true) {
                        if(i+1 >= word.length() || (word.charAt(i) != word.charAt(i+1))) {
                            break;
                        } else {
                            i += 1;
                        }
                    }
                }
            }
            if(flag == 0) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
