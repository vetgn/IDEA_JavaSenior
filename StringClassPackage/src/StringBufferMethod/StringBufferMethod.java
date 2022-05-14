package StringBufferMethod;

import org.junit.Test;

/**
 * StringBuffer的常用方法
 * StringBuffer append(xxx):提供了很多的append()方法,用于进行字符串拼接
 * StringBuffer delete(int start,int end):删除指定位置的内容
 * StringBuffer replace(int start, int end, String str):把[start, end)位置替换为str
 * StringBuffer insert(int offset, xxx):在指定位置插入xxx
 * StringBuffer reverse() :把当前字符序列逆转
 * public int indexof(String str)
 * public String substring(int start, int end)
 * public int Length()
 * public char charAt(int n )
 * public void setCharAt(int n , char ch):将字符串中指定的位置的字符替换成目标字符
 *
 * @author ZJJ
 * #Description StringBufferMethod
 * #Date: 2022/5/14 14:41
 */
public class StringBufferMethod {
    @Test
    public void test1() {
        /*append()*/
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);//abc11
        /*delete()*/
//        s1.delete(2,4);
//        System.out.println(s1);//ab1
        /*replace()*/
//        s1.replace(2,4,"hello");
//        System.out.println(s1);//abhello1
        /*insert()*/
//        s1.insert(2,"false");
//        System.out.println(s1);//abfalsec11
//        System.out.println(s1.length());//10
        /*reverse()*/
        s1.reverse();
        System.out.println(s1);//11cba
    }

    /*对比String、StringBuffer、StringBuilder三者的效率:
    * 从高到低排列：StringBuilder > StringBuffer > String*/
    @Test
    public void test2() {
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间: " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间: " + (endTime - startTime));
        startTime  =System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间: " + (endTime - startTime));
    }
}
