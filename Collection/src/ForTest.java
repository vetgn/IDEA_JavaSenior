import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ZJJ
 * #Description ForTest
 * #Date: 2022/7/14 15:36
 */
public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素的类型 局部变量 ：集合对象)
        //内部仍然调用迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    //练习题
    @Test
    public void test2() {
        String[] arr = new String[]{"MM", "MM", "MM"};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = "GG";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
