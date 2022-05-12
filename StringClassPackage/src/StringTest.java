import org.junit.Test;

/**
 * String 的使用
 *
 * @author ZJJ
 * #Description StringTest
 * #Date: 2022/5/2 19:49
 */
public class StringTest {

    /*
     * String :字符串，使用一对""引起来表示
     * 1.String声明为final，不可被继承
     * 2.String实现了Serializable接口：表示字符串是支持序列化的。
     *         实现了Comparable接口：表示String可以比较大小
     * 3.String内部定义了·final char[] value用于存储字符串大小
     * 4.String：代表不可变的字符序列。简称：不可变性。（简而言之，无论String类进行任何的修改都会重新造）
     *      体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有
     * 的value进行赋值
     *           2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有
     * 的value进行赋值
     *           3.当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值
     * 5.通过字面量的方式(区别于new)给一个字符串赋值，此时的字符串声明在字符串
     * 常量池中
     * 6.字符串常量池中是不会存储相同内容的字符串的。
     * */

    @Test
    public void test1() {
        String s1 = "abc";// 字面量的定义方式
        String s2 = "abc";
//        s1 = "hello";

        System.out.println(s1 == s2);//比较s1 和 s2 的地址值

        System.out.println(s1);// hello
        System.out.println(s2);// abc

        System.out.println("**************");

        String s3 = "abc";
        s3 += "def";// 这时 s2 与 s3 不会通同用一个地址值
        System.out.println(s3);//abcdef
        System.out.println(s2);//abc

        System.out.println("**************");

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc

    }

    /*
     * String的实例化方式：
     * 方式一：通过字面量定义的方式
     * 方式二：通过new + 构造器的方式
     *
     * 面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
     *      两个： 一个是堆空间中new 结构，另一个是char[]对应的常量池中的数据："abc"
     * */
    @Test
    public void test2() {
//        方式一：通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";
//        方式二：通过new + 构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

        System.out.println("*************");

        Person person1 = new Person("Tom", 12);
        Person person2 = new Person("Tom", 12);
        System.out.println(person1.name.equals(person2.name));//true
        System.out.println(person1.name == person2.name);//true

        person1.name = "mike";
        System.out.println(person2.name);//Tom  String 的不可变性
    }


    /*结论:
    1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
    2.只要其中有一个是变量,结果就在堆中。
    3.如果拼接的结果调用intern()方法,返回值就在常量池中
    */
    @Test
    public void test4() {
        String s1 = "JavaEE";
        String s2 = "hadoop";
        String s3 = "JavaEEhadoop";
        String s4 = s1 + "hadoop";
        System.out.println(s3 == s4);//false
        final String s5 = "JavaEE";// 此时声明的s5 是一个常量
        String s6 = s5 + "hadoop";
        System.out.println(s3 == s6);//true
    }

    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//像这种的拼接，如果在常量池中有相同的，就会调用常量池中的
        String s5 = s1 + "hadoop";//而这种有 s1 这种变量的出现，则相当于会 new 一个对象，会先指向 value 再指向 char[]
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        /*intern()方法会强制调用常量池中的数*/
        String s8 = s5.intern();
        System.out.println(s3 == s8);//true
    }
}

