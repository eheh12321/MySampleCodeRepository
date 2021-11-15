package CodingTestMemory.자바의정석.Chap15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class InputStream2 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        System.out.println("Input Source: " + Arrays.toString(inSrc));

        try {
            while(input.available() > 0) {

                // temp에 담긴 내용은 비우지 않고 그냥 그 위에 덮어쓴다.
                int len = input.read(temp);
                output.write(temp, 0, len); // 읽어온 만큼만 출력하자.

                outSrc = output.toByteArray();
                printArrays(temp, outSrc);
            }
        } catch (IOException e) {}

    }

    private static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp: " + Arrays.toString(temp));
        System.out.println("Output Source: " + Arrays.toString(outSrc));
    }
}
