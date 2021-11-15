package CodingTestMemory.자바의정석.Chap15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * ByteInput/OutputStream - 바이트 배열에 데이터를 입출력하는데 사용되는 함수
 * (1바이트씩 읽는다. - 문자 입출력에는 적합하지 않음. char:2byte 이기 때문)
 */
public class InputStream1 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        int data = 0;

        while((data = input.read()) != -1) { // 더이상 읽어올 데이터가 없으면 -1을 반환한다.
            output.write(data);
        }

        outSrc = output.toByteArray(); // 스트림의 내용을 바이트 배열로 반환.

        System.out.println("Input Source: " + Arrays.toString(inSrc));
        System.out.println("Output Source: " + Arrays.toString(outSrc));
    }
}
