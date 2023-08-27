package date_time;

import java.time.*;

public class Lec2_Instant_LocalDateTime {
    public static void main(String[] args) {
        // 기계용
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        // 휴먼용
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime birthDay = LocalDateTime.of(1998, Month.FEBRUARY, 10, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);
    }
}
