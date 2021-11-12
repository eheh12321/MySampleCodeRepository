package CodingTestMemory.자바의정석.Chap12;

import java.lang.annotation.*;

enum TestType {FIRST, FINAL}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
    /** 애너테이션 내에 선언된 메소드를 "에너테이션의 요소(element)"라고 한다.
     * 반환값이 있고 매개변수는 없는 추상 메서드의 형태이며, 상속을 통해 구현할 필요는 없다.
     * 애너테이션 적용 시 이 요소들의 값을 빠짐없이 채워줘야한다. (기본값이 세팅되어 있는 경우는 기본값이 적용된다)
     **/
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FINAL;
    DateTime testDate();
}

@interface DateTime {
    String yymmdd();
    String hhmmss();
}

/**
 * 값을 지정할 필요 없는 경우 애네테이션의 요소를 하나도 정의하지 않을 수 있다.
 * 이를 마커 애너테이션이라고 한다.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface MarkerAnnotation {}

@Deprecated
@SuppressWarnings("unchecked")
@TestInfo(
        count=3, testedBy = "Kim",
        testTools = {"Junit", "AutoTester"},
        testType = TestType.FIRST,
        testDate = @DateTime(yymmdd="211112", hhmmss="105404")
)
public class Annotation1 {
    public static void main(String[] args) {
        Class<Annotation1> cls = Annotation1.class;
        TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testedDate() = " + anno.testDate().yymmdd() + "/" + anno.testDate().hhmmss());
        for (String str : anno.testTools()) {
            System.out.println("testTools=" + str);
        }
        System.out.println();

        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
