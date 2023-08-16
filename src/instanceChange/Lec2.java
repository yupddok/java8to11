package instanceChange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Lec2 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("bae");
        names.add("jeong");
        names.add("yoon");

        // 1. Iterable의 기본 메소드 : forEach()
        names.forEach(System.out::println);

        for (String n : names) {
            System.out.println(n);
        }

        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("====");
        while (spliterator1.tryAdvance(System.out::println));

        names.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("B"))
                .collect(Collectors.toSet());

        names.removeIf(s -> s.startsWith("b"));
        names.forEach(System.out::println);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase);
        names.sort(compareToIgnoreCase.reversed());



    }
}
