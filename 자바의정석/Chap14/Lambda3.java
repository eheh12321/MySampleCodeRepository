package CodingTestMemory.자바의정석.Chap14;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda3 {
    public static void main(String[] args) {
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16); // 문자열을 16진수 변환
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i); // 숫자를 2진수 문자열으로 변환

        Function<String, String> h = f.andThen(g); // = f 메소드 이후에 g 메소드 실행 (after)
        Function<Integer, Integer> h2 = f.compose(g); // = g 메소드 이후에 f 메소드 실행 (before)

        System.out.println(h.apply("FF")); // FF(문자열) -f-> 255(16진수 숫자) -g-> 11~11(2진수 문자열)
        System.out.println(h2.apply(2)); // 2(10진수 숫자) -g-> 10(문자열) -f-> 16(16진수 숫자)

        Function<String, String> f2 = x -> x; // 항등함수(Identity func) = 값을 그대로 출력함
        System.out.println(f2.apply("AAA"));

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i%2 == 0;
        Predicate<Integer> notP = p.negate(); // = not p = i >= 100;

        Predicate<Integer> all = notP.and(q.or(r)); // (i >= 100) && (i < 200 || i % 2 == 0)
        System.out.println(all.test(150));

        String str1 = "Abc";
        String str2 = "Abc";

        boolean result = Predicate.isEqual(str1).test(str2);
        System.out.println(result);
    }
}
