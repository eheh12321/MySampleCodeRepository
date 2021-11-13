package CodingTestMemory.자바의정석.Chap14;

import java.io.File;
import java.util.stream.Stream;

public class Stream2 {
    public static void main(String[] args) {
        File[] fileArr = {new File("Ex1.java"), new File("Ex2.bak"), new File("Ex2.java"),
                new File("Ex1"), new File("Ex1.txt")};

        Stream<File> fileStream = Stream.of(fileArr);

        // map()을 통해 Stream<File>을 Stream<String>으로 변환 (중간연산)
        Stream<String> fileNameStream = fileStream.map(File::getName);
        fileNameStream.forEach(System.out::println);

        // 스트림 재생성 (1회용)
        fileStream = Stream.of(fileArr);

        /**
         * map() 연산.
         * 스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할 때 사용.
         * 매개변수로 T 타입을 R 타입으로 변환해서 반환하는 함수 지정.
         */
        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1) // 확장자 ('.')이 없는 것을 제외
             //   .peek(s -> System.out.printf("FileName = %s\n", s)) // 중간 연산 엿보기(스트림의 연산을 소모하지 않음)
                .map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
                .map(String::toUpperCase) // 대문자로 변환
                .distinct() // 중복제거
                //.peek(s -> System.out.printf("Extension = %s\n", s))
                .forEach(System.out::print);
    }
}
