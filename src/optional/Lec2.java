package optional;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lec2 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

//        !isPresent() == isEmpty()
        boolean present = optional.isPresent();
        boolean empty = optional.isEmpty();
        System.out.println(present);
        System.out.println(empty);

//         java.util.NoSuchElementException: No value present
//        OnlineClass onlineClass = optional.get();
//        System.out.println(onlineClass.getTitle());

        // isPresent
        if (optional.isPresent()) {
            OnlineClass onlineClass1 = optional.get();
            System.out.println(onlineClass1.getTitle());
        }

        // ifPresent
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        // orElse
        OnlineClass onlineClass2 = optional.orElse(createNewClass());
        System.out.println(onlineClass2.getTitle());

        // orElseGet
        OnlineClass onlineClass3 = optional.orElseGet(Lec2::createNewClass);
        System.out.println(onlineClass3.getTitle());

        // orElseThrow
        OnlineClass onlineClass4 = optional.orElseThrow(IllegalArgumentException::new);
        System.out.println(onlineClass4.getTitle());

        // filter
        Optional<OnlineClass> onlineClass5 = optional.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass5.isEmpty());

        // map : return primitive type
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        // map : return optional
        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        Progress progress2 = progress1.orElseThrow();

        // flatMap : return optional
        Optional<Progress> progress3 = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        return new OnlineClass(10, "New class", false);
    }
}
