package date_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Lec2_Duration {
    public static void main(String[] args) {
        // 기간 - 기계용
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());
    }
}
