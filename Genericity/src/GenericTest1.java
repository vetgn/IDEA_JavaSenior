import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZJJ
 * #Description GenericTest1
 * #Date: 2022/7/19 21:11
 */

/*
 *
 * 如何自定义泛型结构:泛型类、泛型接口、泛型方法。
 *
 * 1.关于自定义泛型类、泛型接口:
 *
 * 异常类不能是泛型
 *
 * */
public class GenericTest1 {
    @Test
    public void test() {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求:如果大家定义了类是带泛型的,建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议:实例化时指明类的泛型
        Order<String> stringOrder = new Order<>("orderAA", 1001, "orderAA");

    }

    @Test
    public void test1() {
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时,指明了泛型类型。则实例化子类对象时,不再需要指明泛型。
        subOrder.setOrderT(1122);

        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("order2...");
    }

    @Test
    public void test2() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        //泛型不同的引用不能互相赋值
//        list1 = list2;

    }

    //测试泛型方法
    @Test
    public void test3() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        //泛型方法在调用时,指明泛型参数的类型。
        List<Integer> integers = order.copyFromArrayToList(arr);
        System.out.println(integers);
    }
}
