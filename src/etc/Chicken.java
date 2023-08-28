package etc;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER) // 제네릭 타입파라미터
@Target(ElementType.TYPE_USE) // 제네릭 타입파라미터
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
