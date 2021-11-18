package CodingTestMemory.자바의정석.Chap15;

import java.nio.charset.StandardCharsets;

public class Korean {
    public static void main(String[] args) {
        String test = "테스트";
        System.out.println(test.getBytes(StandardCharsets.UTF_8).length);
    }
}
