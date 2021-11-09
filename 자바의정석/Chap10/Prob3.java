package CodingTestMemory.자바의정석.Chap10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prob3 {

    static int paycheckCount(Calendar from, Calendar to) {
        int monthDiff;
        if(from == null || to == null) {
            return 0;
        }
        if(from.get(Calendar.DATE) == to.get(Calendar.DATE) && to.get(Calendar.DATE) == 21) {
            return 1;
        }
        monthDiff = to.get(Calendar.MONTH) - from.get(Calendar.MONTH);
        if(monthDiff < 0) {
            return 0;
        }
        if(from.get(Calendar.DAY_OF_MONTH) <= 21 && to.get(Calendar.DAY_OF_MONTH) > 21) {
            monthDiff++;
        }
        if (from.get(Calendar.DAY_OF_MONTH) > 21 && to.get(Calendar.DAY_OF_MONTH) < 21) {
            monthDiff--;
        }
        return monthDiff;
    }

    static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime();
        Date toDate = to.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print(sdf.format(fromDate) + " ~ " + sdf.format(toDate) + ":");
        System.out.println(paycheckCount(from, to));
    }

    public static void main(String[] args) {
        Calendar fromCal = Calendar.getInstance();
        Calendar toCal = Calendar.getInstance();

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 0, 1);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 2, 1);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 2, 23);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 23);
        toCal.set(2020, 2, 21);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 22);
        toCal.set(2020, 2, 21);
        printResult(fromCal, toCal);
    }
}
