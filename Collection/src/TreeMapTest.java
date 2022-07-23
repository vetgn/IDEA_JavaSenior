import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author ZJJ
 * #Description TreeMapTest
 * #Date: 2022/7/18 17:00
 */
public class TreeMapTest {

    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    // 因为要按照key进行排序:自然排序、定制排序

    //自然排序
    @Test
    public void test1() {
        TreeMap map = new TreeMap();
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 23);
        User u3 = new User("Jack", 23);
        User u4 = new User("Rose", 23);

        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 78);
        map.put(u4, 100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //定制排序
    @Test
    public void test2() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("传入的数据类型不符");
            }
        });
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 23);
        User u3 = new User("Jack", 23);
        User u4 = new User("Rose", 23);

        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 78);
        map.put(u4, 100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
