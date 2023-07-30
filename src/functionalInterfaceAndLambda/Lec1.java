package functionalInterfaceAndLambda;

public class Lec1 {
    public static void main(String[] args) {
        // 익명 내부 클래스 anonymous inner class
//        functionalInterfaceAndLambda.RunSomething runSomething = new functionalInterfaceAndLambda.RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("hello");
//            }
//        };

        // 구현체 1줄일 때
        // 함수형 인터페이스를 인라인으로 구현한 object
//        functionalInterfaceAndLambda.RunSomething runSomething = () -> System.out.println("hello");
//        runSomething.doIt();

        // 구현체 n줄일 때
//        functionalInterfaceAndLambda.RunSomething runSomething2 = () ->  {
//            System.out.println("hello");
//            System.out.println("Rambda");
//        };

//        functionalInterfaceAndLambda.RunSomething runSomething = (number) -> {
//            return number + 10;
//        };

//        functionalInterfaceAndLambda.RunSomething runSomething = (number) -> number + 10;

        int baseNumber2 = 10;
        RunSomething runSomething = new RunSomething() {
            // pure한 함수가 아님
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
//                baseNumber2++; //외부값변경 - 문법적으로 불가능 -> pure한 함수가아님
//                baseNumber++;  //외부값변경 - 문법적으로 가능  -> pure한 함수가아님
                return number + baseNumber;
            }

        };



        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));


    }
}
