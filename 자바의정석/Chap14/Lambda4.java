package CodingTestMemory.자바의정석.Chap14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lambda4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }

        // List의 모든 요소 출력
        list.forEach(i -> System.out.print(i + ", "));
        System.out.println();

        // List에서 2 또는 3의 배수 제거
        list.removeIf(x -> (x % 2 == 0) || (x % 3 == 0));
        System.out.println(list);

        // List의 각 요소에 10을 곱한다
        list.replaceAll(i -> i * 10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        map.forEach((k, v) -> System.out.print("{" + k + ", " + v + "} "));
        System.out.println();
    }
}
