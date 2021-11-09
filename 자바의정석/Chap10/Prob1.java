package CodingTestMemory.자바의정석.Chap10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prob1 {

    public static void main(String[] args) {

        int year = 2020;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        for(int month = 0; month < 12; month++) {
            cal.set(year, month, 1);
            int e = cal.get(Calendar.DAY_OF_WEEK); // 일요일 = 1
            if(e == 1) { // 첫 날이 일요일인 경우 - 7일을 더하면 된다
                cal.add(Calendar.DATE, 7);
            } else { // 이외의 경우 (7 + (8 - e))
                cal.add(Calendar.DATE, 15 - e);
            }
            Date date = new Date(cal.getTimeInMillis());
            System.out.println(df.format(date));
        }
    }
}
