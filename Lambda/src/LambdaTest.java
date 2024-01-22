import org.junit.Test;

import java.util.Comparator;

/**
 * @author ZJJ
 * #Description LambdaTest
 * #Date: 2022/8/1 14:43
 */

/*
 * Lambda表达式的使用举例
 * */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("北京");
            }
        };

        r1.run();

        System.out.println("*************");

        Runnable r2 = () -> System.out.println("故宫");

        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(com1.compare(12, 21));


        System.out.println("*************");
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        System.out.println(com2.compare(12, 21));


        System.out.println("*************");
        Comparator<Integer> com3 = Integer::compare;

        System.out.println(com3.compare(12, 21));
    }
}
