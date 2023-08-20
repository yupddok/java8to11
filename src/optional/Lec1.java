package optional;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lec1 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass springBoot = new OnlineClass(1, "spring boot", false);
//        Duration studyDuration = springBoot.getProgress().getStudyDuration();

        
        // 기존에 사용하던 방법
        // 에러를 만들기 좋은 코드
        // null 체크를 잊을 수 있기 때문
        // null return 자체가 문제다
//        Progress progress = springBoot.getProgress();
//        if (progress != null) {
//            System.out.println(progress.getStudyDuration());
//        }

        Optional<Progress> progress = springBoot.getProgress();
        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));


    }
}
