package Exer;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author ZJJ
 * #Description HashExer
 * #Date: 2022/7/17 15:01
 */
public class HashExer {

    @Test
    public void test1() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.setName("CC");//此时p1 的哈希值已经改变，因此向后加
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001, "CC"));//这是1001与CC整个在一起的哈希值，与之前的不相同
        System.out.println(set);
        set.add(new Person(1001, "AA"));//这个哈希值与之前的是相同的，不过原来的位置上有了，并且改成CC因此又不相同
        System.out.println(set);
    }
}
