import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author ZJJ
 * #Description MyAnnotations
 * #Date: 2022/6/29 14:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})//表明只能在指定的类、方法。。。上面使用这个@MyAnnotation

public @interface MyAnnotations {

    MyAnnotation[] value();
}
