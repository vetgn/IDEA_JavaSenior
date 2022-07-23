import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZJJ
 * #Description ListTest
 * #Date: 2022/7/15 19:35
 */

/*
 * |------Collection接口：单列集合，用来存储一个一个的对象
 *           |------List接口：存储有序的、可重复的数组。 --->“动态”数组
 *              |------ArrayList：作为List接口的主要实现类；线程不安全，效率高；底层使用Object[] elementData储存
 *              |------LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表储存
 *              |------Vector：作为List接口的古老实现类；线程安全，效率不高；底层使用Object[] elementData储存
 *
 *      2. ArrayList源码分析
 *      2.1 jbk 7情况下
 *          ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 *          List.add(123);//elementData[9] = new Integer(123);
 *          ...
 *          List.add(11);/如果此次的添加导致底层elementData数组容量不够,则扩容。
 *          默认情况下,扩容为原来的容量的1.5倍,同时需要将原有数组中的数据复制到新的数组中。
 *
 *          结论:建议开发中使用带参的构造器: ArrayList list = new ArrayList(int capacity)
 *
 *      2.2 jbk 8中ArrayList的变化：
 *          ArrayList list = new ArrayList();//底层Object[] elementData初始化为{} .并没有创建长度为10的数组
 *
 *
 *          List.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData
 *          ...
 *          后续的添加和扩容操作与jdk 7 无界
 *
 *      2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式,而jdk8中的ArrayList的对象的创建类似于单例的懒汉式,延迟了数组的创建,节省内存。
 *
 *      3.Linked1List源码分析
 *          LinkedList list = new LinkedList();内部声明了Node类型的first和Last属性,默认值为null;
 *          list.add(123);//将123封装到Node中，创建了Node对象
 *
 *          其中，Node定义为：体现了LinkedList的双向链表的说法
 * private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
 *
 * 面试题：ArrayList、LinkedList、Vector三者的异同
 * 同:三个类都是实现了List接口,存储数据的特点相同:存储有序的、可重复的数据
 * 不同:见上
 *
 * 5.List中的常用方法
 *
 *
 * */
public class ListTest {

    /*
    * void add(int index, Object ele):在index位置插入ele元素
    * boolean addALL(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
    * Object get(int index):获取指定index位置的元素
    * int indexof(Object obj):返回obj在集合中首次出现的位置
    * int LastIndexof(Object obj):返回obj在当前集合中末次出现的位置
    * Object remove (int index) :移除指定index位置的元素,并返回此元素
    * Object set(int index, Object ele) :设置指定index位置的元素为ele
    * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
    * */

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person(  "Tom",  12));
        list.add(456);

        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add (1,"BB");
        System.out.println(list);

        //boolean addALL(int index, Collection eles):Mindex位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        //  list.addAll(list1);//9
        list.add(list1);//7
        System.out.println(list.size());//9

    }
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(2);//[1,2]
        list.remove(new Integer(2));//[1,3]
    }

}
