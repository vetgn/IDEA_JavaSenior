import org.junit.Test;

import java.util.*;

/**
 * @author ZJJ
 * #Description CollectionsTest
 * #Date: 2022/7/18 20:06
 */

/*
 * Collections:操作Collection、Map的工具类
 *
 *
 * 面试题：Collection 和 Collections 的区别
 *
 * */
public class CollectionsTest {
//    reverse(List):反转List 中元素的顺序
//    shuffle(List):对List 集合元素进行随机排序
//    sort(List):根据元素的自然顺序对指定List集合元素按升序排序
//    sort(List, Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
//    swap(List, int, int):将指定list 集合中的i处元素和j处元素进行交换
    /*
     * Object max(Collection):根据元素的自然顺序,返回给定集合中的最大元素
     * Object max(Collection, Comparator):根据 Comparator 指定的顺序,返回给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection, Comparator)
     * int frequency(Collection, Object):返回指定集合中指定元素的出现次数
     * void copy(List dest,List src):将src中的内容复制到dest中
     * boolean replaceAll(List list, Object oldVal, Object newVal): 使用新值替换List对象的所有旧值
     * */

    @Test
    public void test1() {
        List list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);
        //
        Collections.reverse(list);
        System.out.println(list);
        //
        Collections.shuffle(list);
        System.out.println(list);
        //
        Collections.swap(list, 1, 2);
        System.out.println(list);
    }

    @Test
    public void test2() {
        List list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(765);
        list.add(-97);
        list.add(0);

        //错误的，报异常 Source does not fit in dest
//        List dest = new ArrayList();
//        Collections.copy(dest, list);
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);

        System.out.println(list);
    }


}
