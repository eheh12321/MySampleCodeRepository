package CodingTestMemory.BJ.Silv4.P1002;

import java.util.Scanner;

public class P1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int x1, y1, r1, x2, y2, r2, swap;
        double dist;
        for (int t = 0; t < T; t++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            r1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            r2 = sc.nextInt();
            if(r1 < r2) {
                swap = r2;
                r2 = r1;
                r1 = swap;
            }
            dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if(r1 + r2 == dist && dist != 0) { // 1. 한점에서 외접
                System.out.println("1");
            } else if (r1 - r2 == dist && dist != 0) { // 2. 한점에서 내접
                System.out.println("1");
            } else if (r1 - r2 < dist && dist < r1 + r2 && dist != 0) { // 3. 두점에서 만난다
                System.out.println("2");
            } else if (r1 == r2 && dist == 0) { // 4. 원이 겹치는 경우
                System.out.println("-1");
            } else {
                System.out.println("0");
            }
        }
    }
}
