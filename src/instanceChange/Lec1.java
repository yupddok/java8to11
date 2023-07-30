package instanceChange;

public class Lec1 {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("bae");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
