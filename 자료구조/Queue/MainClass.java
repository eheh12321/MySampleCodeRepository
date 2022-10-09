package CodingTestMemory.자료구조.Queue;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        int menu, tmp;

        while(true) {
            System.out.print("(1) 삽입  (2) 삭제  (3) peek  (4) 출력  (0) 종료 | ");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("데이터 입력: ");
                    tmp = sc.nextInt();
                    arrayQueue.offer(tmp);
                    break;
                case 2:
                    tmp = arrayQueue.poll();
                    System.out.printf("[%d] 데이터 제거\n", tmp);
                    break;
                case 3:
                    tmp = arrayQueue.peek();
                    System.out.printf("[%d] 데이터 peek\n", tmp);
                    break;
                case 4:
                    System.out.println(Arrays.toString(arrayQueue.toArray()));
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    break;
            }
        }

    }
}
