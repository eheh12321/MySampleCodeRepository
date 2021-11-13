package CodingTestMemory.자바의정석.Chap14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda2 {

    public static void main(String[] args) {
        // Supplier -> 매개변수 X, 반환값 O, 랜덤 숫자를 생성한다
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        // Consumer -> 매개변수 O, 반환값 X, 변수 값을 출력한다
        Consumer<Integer> c = (i) -> System.out.print(i + ", ");
        // Predicate -> 매개변수 O, 반환타입 Boolean, i가 짝수인지 판별한다.
        Predicate<Integer> p = (i) -> i % 2 == 0;
        // Function -> 매개변수 T, 반환타입 R, i의 1의자리 숫자를 제거한다(input: i, output:1의자리가 제거된 i)
        Function<Integer, Integer> f = (i) -> i/10*10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());
        for (T t : list) {
            newList.add(f.apply(t));
        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T t : list) {
            if(p.test(t))
                c.accept(t);
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s , List<T> list) {
        for(int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
