package CodingTestMemory.자바의정석.Chap15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class BufferedOutputStream1 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("./src/CodingTestMemory/자바의정석/Chap15/123.txt");
            BufferedOutputStream bos = new java.io.BufferedOutputStream(fos, 5); // 버퍼의 크기는 5바이트.
            for(int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }
            fos.close(); // 버퍼에 있는 내용을 비우고 (flush) 모든 자원을 반환하면서 종료한다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
