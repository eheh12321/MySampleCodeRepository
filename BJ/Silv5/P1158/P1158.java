package CodingTestMemory.BJ.Silv5.P1158;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 요세푸스 문제 요약
// ** 큐를 활용하자 **
// 1. 큐를 만들어 1부터 N까지 push
// 2. 제일 앞에서부터 pop 하고 다시 맨 뒤로 push하는 과정을 반복한다
// 3. 이 과정에서 cnt번에 한번씩 push과정을 안해주면 결국 큐가 비게 되면서 반복문 탈출 후 출력

public class P1158 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rep = sc.nextInt();
        int[] list = new int[n];
        int cnt = 0;
        int chk = 1;
        for(int i=1; i<=n; i++) { // 1부터 n까지 삽입
            queue.offer(i);
        }
        while(queue.peek()!=null)
        {
            if(chk==rep) {
                chk = 1;
                list[cnt++] = queue.poll();
            }
            else {
                queue.offer(queue.poll());
                chk += 1;
            }
        }
        System.out.println(Arrays.toString(list).replace('[', '<').replace(']', '>'));
    }
}
