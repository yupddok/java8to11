package date_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Lec2_Period {
    public static void main(String[] args) {
        // 기간 - 휴먼용
        LocalDate today = LocalDate.now();
        LocalDate nextYearBirthday = LocalDate.of(2024, Month.FEBRUARY, 10);

        Period period = Period.between(today, nextYearBirthday);
        System.out.println(period.getDays());

        Period until = today.until(nextYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));
    }
}
