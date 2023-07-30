package instanceChange;

public class DefaultFoo implements Foo, Bar {

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    // instanceChange.DefaultFoo inherits unrelated defaults for printNameUpperCase() from types instanceChange.Foo and instanceChange.Bar
    // 충돌하는 default method 가 있는경우
    // -> 컴파일오류
    // -> 재정의필요
    @Override
    public void printNameUpperCase() {
        // default method 재정의 가능
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
