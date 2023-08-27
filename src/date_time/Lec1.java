package date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Lec1 {
    public static void main(String[] args) throws InterruptedException {
        // java 8 이전
        Date date = new Date();
        long time = date.getTime();

        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);
        // java.util.Date 클래스는 mutable 하기 때문에 thread safe하지 않다.

        Calendar calendar = new GregorianCalendar(1998, 01, 10);
        Calendar calendar2 = new GregorianCalendar(1998, Calendar.FEBRUARY, 10);
        // type safe 하지 않다.

        SimpleDateFormat dateFormat = new SimpleDateFormat();

    }

}
