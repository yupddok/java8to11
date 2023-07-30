package instanceChange;

public interface Foo {
    void printName();

    // 인터페이스에 메서드 추가 -> 기구현된 파일들 컴파일 오류 (추상메서드 미구현으로)
    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    // Default method 'toString' overrides a member of 'java.lang.Object'
//    default String toString() {
//
//    }

    static void printAnything() {
        System.out.println("FOO");
    }

    String getName();
}
