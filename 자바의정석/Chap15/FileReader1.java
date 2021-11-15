package CodingTestMemory.자바의정석.Chap15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReader1 {
    public static void main(String[] args) {
        try {
            String fileName = "./src/CodingTestMemory/자바의정석/Chap15/FileOutputStream1.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            /**
             * FileInputStream (바이트 스트림)
             */
            int data = 0;
            while((data = fis.read()) != -1 ) {
                System.out.print((char) data);
            }
            System.out.println("\n------------------------------");
            fis.close();

            /**
             * FileReader (문자 스트림)
             */
            while((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
