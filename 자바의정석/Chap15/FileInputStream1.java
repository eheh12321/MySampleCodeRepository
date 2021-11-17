package CodingTestMemory.자바의정석.Chap15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStream 은 바이트 기반 스트림이다.
 * 따라서, 1바이트로 표현 가능한 영문자나 숫자는 관계 없으나 한글의 경우 3바이트를 사용해야 하기 때문에 한글이 당연히! 깨져서 나온다
 * 이를 해결하기 위해서는 보조 스트림을 같이 사용하거나 문자열 스트림을 사용해야 한다. (Reader/Writer)
 */
class FileInputStream1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/CodingTestMemory/자바의정석/Chap15/FileInputStream1.java");
        FileOutputStream fos = new FileOutputStream("./src/CodingTestMemory/자바의정석/Chap15/FileOutputStream1.txt");
        int data = 0;

        /**
         * read() 메소드는 한번에 1byte씩 끊어서 읽어오나, 실제로는 1byte를 반환한다.
         * 그 이유는 0~255에 해당하는 바이트 문자 뿐만 아니라 더이상 입력값이 없음을 알리는 '-1'도 같이 반환해야 하기 때문이다.
         * 따라서 정수형 중에서 가장 효율적이고 빠른 int형을 반환한다.
         */
        while((data = fis.read())!= -1) {
            fos.write(data);
            char c = (char) data;
            System.out.print(c);
        }
        fis.close();
        fos.close();
    }
}
