package instanceChange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Lec2 {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("bae");
        name.add("jeong");
        name.add("yoon");

        // 1. Iterable의 기본 메소드 : forEach()
        name.forEach(System.out::println);

        for (String n : name) {
            System.out.println(n);
        }

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("====");
        while (spliterator1.tryAdvance(System.out::println));

        name.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("B"))
                .collect(Collectors.toSet());

        name.removeIf(s -> s.startsWith("b"));
        name.forEach(System.out::println);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase);
        name.sort(compareToIgnoreCase.reversed());



    }
}
