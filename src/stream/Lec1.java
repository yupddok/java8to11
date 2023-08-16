package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lec1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("bae");
        names.add("jeong");
        names.add("yoon");

        // 중개 operator
        // terminal operator
        Stream<String> stringStream = names.stream()
                .map(s -> {
                    // 출력되지 않음
                    // 종료형 operator가 실행되기 전까지는 중개형 operator는 무의미하다.
                    // 정의만 되어있는 것.
                    System.out.println(s);
                    return s.toUpperCase();
                });

        System.out.println("=====");


        List<String> collect = names.stream()
            .map(s -> {
                // 종료형 operator collect가 있으니 실행됨
                System.out.println(s);
                return s.toUpperCase();
            }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("=====");

        names.forEach(System.out::println);

        System.out.println("=====");

        // 병렬처리

        // 어려움
//        for (String name : names) {
//            if (name.startsWith("b")) {
//                System.out.println(name.toUpperCase());
//            }
//        }

        List<String> collect1 = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);





    }
}
