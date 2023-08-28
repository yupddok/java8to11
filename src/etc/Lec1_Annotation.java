package etc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;


@Chicken("양념")
@Chicken("마늘간장")
public class Lec1_Annotation {
//    public static void main(@Chicken String[] args) throws @Chicken RuntimeException {
//        List<@Chicken String> names = Arrays.asList("bae");
//    }

//    @Target(ElementType.TYPE_PARAMETER)
//    static class FeelsLikeChicken<@Chicken T> {
//
//        // <C> : 타입 파라미터
//        // (C) : 타입
//        public static <@Chicken C> void  print(C c) {
//            System.out.println(c);
//        }

//    }

    public static void main(String[] args) {
        Chicken[] chickens = Lec1_Annotation.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });
        ChickenContainer chickenContainer = Lec1_Annotation.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });


    }

}
