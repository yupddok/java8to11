import java.util.function.*;

public class Lec3 {
    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;

        BinaryOperator<Integer> sum = (Integer a, Integer b) -> a + b;
        BinaryOperator<Integer> sum2 = (a, b) -> a + b;

        Lec3 lec3 = new Lec3();
        lec3.run();
    }

    private void run() {
//        자바 8 전 : 익명클래스, 내부클래스 에서 final이 붙어야만 사용가능했음
//        자바 8 후 : final 키워드 생략할 수 있는 경우가 있음
//         - effective final인 경우 : 이 변수가 사실상 final 인 경우 (어디서도 변경점이 없을경우 )

        int baseNumber = 10;


        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                // 쉐도잉 O
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                // 쉐도잉 O
                System.out.println(baseNumber);
            }
        };

        // 람다
//        IntConsumer printInt = (baseNumber) -> { // error : Variable 'baseNumber' is already defined in the scope
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber); // @ Variable used in lambda expression should be final or effectively final
        };

        printInt.accept(10);
//        baseNumber++; // @
    }


}
