package CodingTestMemory.자바의정석.Chap10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Prob4 {

    public static void main(String[] args) {

        String birthday;
        Date date;
        Scanner sc = new Scanner(System.in);
        Calendar today = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Today: " + sdf.format(today.getTime()));

        while(true) {
            try {
                System.out.print("BirthDay: ");
                birthday = sc.nextLine();
                date = sdf.parse(birthday);
                break;
            } catch (Exception e) {
                System.out.println("형식에 맞춰 입력해주세요");
            }
        }
        birth.setTime(date);
        long diff = (today.getTimeInMillis() - birth.getTimeInMillis()) / (1000*60*60*24);
        System.out.println(diff + "일 지났습니다");
    }
}
