import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ZJJ
 * #Description ConstructorRefTest
 * #Date: 2022/8/1 20:13
 */

/*
 * 1.构造器引用
 *      和方法引用类似,函数式接口的抽象方法的形参列表和构造器的形参列表一致。抽象方法的返回值类型即为构造器所属的类的类型
 * 2.数组引用
 *      大家可以把数组看做是一个特殊的类,则写法与构造器引用一致。
 * */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    //Employee空参构造器: Employee()
    @Test
    public void test1() {
        Supplier<Employee> sup1 = () -> new Employee();

        System.out.println("*************");

        Supplier<Employee> sup2 = Employee::new;
    }

    //Function 中的R apply(T t)
    @Test
    public void test2() {
        Function<Integer, Employee> function = id -> new Employee(id);
        Employee employee = function.apply(1001);
        System.out.println(employee);

        System.out.println("*************");

        Function<Integer, Employee> function1 = Employee::new;
        Employee employee1 = function.apply(1002);
        System.out.println(employee1);

    }

    //BiFunction PR apply(T t,U u)
    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> biFunction = (id, name) -> new Employee(id, name);
        System.out.println(biFunction.apply(1001, "Tom"));

        System.out.println("******************");

        BiFunction<Integer, String, Employee> biFunction1 = Employee::new;
        System.out.println(biFunction1.apply(1002, "Tom"));


    }

    //数组引用
    // Function中的R apply(T t)
    @Test
    public void test4() {
        Function<Integer, String[]> function = length -> new String[length];
        String[] arr1 = function.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("******************");

        Function<Integer, String[]> function1 = String[]::new;
        String[] arr2 = function.apply(10);
        System.out.println(Arrays.toString(arr2));
    }


}
