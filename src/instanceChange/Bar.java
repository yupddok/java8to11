package instanceChange;

public interface Bar {
//    void printNameUpperCase();
    default void printNameUpperCase() {
        System.out.println("BAR");
    }
}
