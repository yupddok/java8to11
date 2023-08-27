package date_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Lec2_DateTimeFormatter {
    public static void main(String[] args) {
        // formatting
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime plus = now.plus(10, ChronoUnit.DAYS); // immutable -> 새 인스턴스 생성

        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy));

        // parsing
        LocalDate parse = LocalDate.parse("10/02/1998", MMddyyyy);
        System.out.println(parse);

        // legecy api 호환
        Date date = new Date();
        Instant instant = date.toInstant();
        Date newDate = Date.from(instant);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime zonedDateTime = gregorianCalendar.toZonedDateTime();
        LocalDateTime localDateTime = gregorianCalendar.toZonedDateTime().toLocalDateTime();
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);


    }
}
