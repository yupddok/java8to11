import java.util.function.*;

/**
 * Java가 기본으로 제공하는 함수형 인터페이스
 */
public class Lec2 {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        // 1. Function<T, R> : T타입을 받아서 R타입을 리턴하는 함수 인터페이스
        Function<Integer, Integer> plus20 = (i) -> i + 20;
        System.out.println(plus20.apply(1));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(multiply2.apply(1));

        
        // 함수 조합용 메소드
        // (1) compose : 매개변수 함수 실행한 결과값으로 함수실행
        // 2 * 2 = 4
        // 4 + 20 = 24
        Function<Integer, Integer> multiply2AndPlus20 = plus20.compose(multiply2);
        System.out.println(multiply2AndPlus20.apply(2));

        // (2) andThen : 함수 실행한 결과값으로 매개변수 함수 실행
        // 2 + 20 = 22
        // 22 * 2 = 44
        plus20.andThen(multiply2).apply(2);

        // 2. Consumer<T> : T타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // 3. Supplier<T> : T타입의 값을 제공하는 함수 인터페이스
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        // 4. Predicate<T> : T타입을 받아서 boolean을 리턴하는 함수 인터페이스
        Predicate<String> startsWithBae = (s) -> s.startsWith("bae");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        // 5. UnaryOperator<T> : Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
        UnaryOperator<Integer> plus30 = (i) -> i + 30;
        System.out.println(plus30.apply(1));

        // 6. BinaryOperator<T> : BiFucntion<T,U,R>의 특수한 형태로, 동일한 타입의 입력값 두개를 받아 리턴하는 함수 인터페이스
    }
}
