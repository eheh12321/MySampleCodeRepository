package CodingTestMemory.자료구조.Stack;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while(true) {
            System.out.printf("현재 데이터 수 : %d / %d\n", s.size(), s.capacity());
            System.out.println("(1)푸시  (2)팝  (3)피크  (4)출력  (0)종료");

            int menu = sc.nextInt();
            int tmp;
            switch (menu) {
                case 0:
                    return;
                case 1:
                    System.out.print("데이터 입력 : ");
                    tmp = sc.nextInt();
                    try {
                        s.push(tmp);
                    } catch (IntStack.OverflowStackException e) {
                        System.out.println("스택이 가득찼습니다");
                    }
                    break;
                case 2:
                    try {
                        tmp = s.pop();
                        System.out.printf("[%d] 데이터 제거\n", tmp);
                    } catch (IntStack.EmptyStackException e) {
                        System.out.println("스택이 비었어용 ㅠ");
                    }
                    break;
                case 3:
                    try {
                        tmp = s.peek();
                        System.out.printf("[%d] 데이터 peek\n", tmp);
                    } catch (IntStack.EmptyStackException e) {
                        System.out.println("스택이 비었어용 ㅠㅠ");
                    }
                    break;
                case 4:
                    s.printStack();
                    break;
            }
        }
    }
}