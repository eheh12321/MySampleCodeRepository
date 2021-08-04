package CodingTestMemory.BJ.Silv4.P11656;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] list = new String[text.length()];
        for(int i=0; i<text.length(); i++) {
            list[i] = text.substring(i, list.length);
        }
        Arrays.sort(list, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(String st : list) {
            System.out.println(st);
        }
    }
}
