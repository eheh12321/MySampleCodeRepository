package CodingTestMemory.BJ.Silv4.P1120;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
/*
    백준 1120번 문제 - 문자열
    가만 생각해보니 실제로 A 문자열 앞뒤에 문자를 끼워넣을 필요 자체가 없는 문제였다.
    B 문자열은 냅두고 A 문자열을 한칸씩 이동해 가면서 diff값이 최소가 되는 값이 바로 정답이 된다.
 */
public class P1120 {
    public static int calcDiff(LinkedList<Integer> deq, String B, int offset) {
        int cnt = 0;
        for(int i=0; i<deq.size(); i++) {
            if((int)B.charAt(i + offset) != (int)deq.toArray()[i]) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Deque<Integer> Adeq = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int diff, len, tmp, offset;
        for(int i=0; i<A.length(); i++) {
            Adeq.addLast((int)A.charAt(i));
        }
        diff = B.length();
        offset = 0;
        len = B.length() - A.length();
        for(int i=0; i<=len; i++) {
            tmp = calcDiff((LinkedList<Integer>) Adeq, B, i);
            if(tmp < diff) {
                diff = tmp;
                offset = i;
            }
        }
       for(int i=0; i<offset; i++) { // 앞쪽부분 채워넣기
           Adeq.addFirst((int)B.charAt(offset - i - 1));
       }
       for(int i=0; i<B.length() - A.length() - offset; i++) { // 뒤쪽부분 채워넣기
           Adeq.addLast((int)B.charAt(A.length() + offset + i));
       }
        System.out.println(calcDiff((LinkedList<Integer>) Adeq, B, 0));
    }
}
