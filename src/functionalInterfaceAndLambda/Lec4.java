package functionalInterfaceAndLambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 메소드 레퍼런스 : 람다가 하는 일이 기존 메소드 또는 생성자를 호출하는거라면, 메소드 레퍼런스를 사용해서 매우 간결하게 표현할 수 있다.
 */
public class Lec4 {
    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";

        // 1. static 메소드
        UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> hi2 = Greeting::hi;

        // 2. 인스턴스 메소드
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        hello.apply("bae");

        // 3. noArgs 생성자
        // 이 코드 자체로는 아무일도 일어나지않음 (인스턴스 생성되지않음)
        Supplier<Greeting> newGreeting = Greeting::new;
        // 이 때 생성됨
        newGreeting.get();

        // 4. args 생성자
        Function<String, Greeting> baeGreeting = Greeting::new;
        Greeting bae = baeGreeting.apply("bae");
        System.out.println("bae = " + bae.getName());

        // 5. 임의의 객체 (특정 타입의 불특정 인스턴스 복수개) 의 인스턴스 메소드
        String[] names = {"bae", "nam"};
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
//        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println("s = " + Arrays.toString(names));


    }
}
