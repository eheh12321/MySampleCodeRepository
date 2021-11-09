package CodingTestMemory.자바의정석.Chap10;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Prob2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat df2 = new SimpleDateFormat("입력하신 날짜는 E요일입니다.");
        Date date;

        while(true) {
            System.out.println("날짜를 yyyy/MM/dd의 형태로 입력해주세요");
            try {
                String str = sc.nextLine();
                date = df.parse(str);
                break;
            } catch (Exception e) {
                System.out.println("형식에 맞춰 입력해주세요");
            }
        }

        System.out.println(df2.format(date));
    }
}
