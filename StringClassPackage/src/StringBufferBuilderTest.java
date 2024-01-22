import org.junit.Test;

/**
 * 关于StringBuffer 和StringBuilder的使用
 *
 * @author ZJJ
 * #Description StringBufferBuilderTest
 * #Date: 2022/5/14 13:56
 */
public class StringBufferBuilderTest {
    /*String、StringBuffer、StringBuilder三者的异同
     * String:不可变的字符序列；底层使用char[]存储
     * StringBuffer:可变的字符序列；线程安全，效率较低；底层使用char[]存储
     * StringBuilder:可变的字符序列；jdk5.0新增，线程不安全，效率高；底层使用char[]存储
     *
     * 源码分析：
     * String str = new String();//char[] value = new char[0];![](img_1.png)
     * String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};
     *
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组
     * sb1.append('a');//va;ue[0]  = 'a';
     * sb1.append('b');//value[1] = 'b';
     *
     * StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];
     *
     * 问题1.System.out.println(sb2.length());//3
     * 问题2.扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
     *      默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中。
     *
     *      指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)
     *
     * String --> StringBuilder : new StringBuilder(String string);
     * StringBuilder --> String : StringBuilder.toString(String string);
     * */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0
    }
}
