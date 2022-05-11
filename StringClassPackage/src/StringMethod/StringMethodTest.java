package StringMethod;

import org.junit.Test;

/**
 * int length():返回字符的长度: return value.length<p>
 * char charAt(int index):返回某索引处的字符return value[index]<p>
 * boolean isEmpty():判断是否是空字符: return value.length == 0<p>
 * String toLowerCasef):使用默认语言环境,将 String 中的所有字符转换为小写<p>
 * String toUpperCase():使用默认语言环境,将String 中的所有字符转换为大写<p>
 * String trim():返回字符串的副本,忽略前导空白和尾部空白<p>
 * boolean equals(Object obj):比较字符串的内容是否相同<p>
 * boolean equalslgnoreCase(String anotherString): 与equals方法类似,忽略大小写<p>
 * String concat(String str):将指定字符串连接到此字符串的结尾。等价于用“+”<p>
 * int compareTo(String anotherString):比较两个字符串的大小<p>
 * String substring(int beginlndex):返回一个新的字符串,它是此字符串的从beginlndex开始截取到最后的一个子字符串。<p>
 * String substring(int beginlndex, int endlndex) :返回一个新字符串,它是此字符串从beginlndex开始截取到endIndex(不包含)的一个子字符串,<p>
 * boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束<p>
 * boolean startsWith(String prefix):测试此字符串是否以指定的前缀开始<p>
 * boolean startsWith(String prefix, int toffset):测试此字符串从指定索引开始的子字符串是否以指定前缀开始<p>
 * boolean contains(CharSequence s):当且仅当此字符串包含指定的char值序列时,返回true<p>
 * int indexOf(String str):返回指定子字符串在此字符串中第一次出现处的索引<p>
 * int indexOf(String str, int fromlndex):返回指定子字符串在此字符串中第一次出现处的索引,从指定的索引开始<p>
 * int lastlndexOf(String str):返回指定子字符串在此字符串中最右边出现处的索引<p>
 * int lastIndexOf(String str, int fromlndex):返回指定子字符串在此字符串中最后一次出现处的索引,从指定的索引开始反向搜索<p>
 * 注：indexOf和lastIndexOf方法如果未找到都是返回-1<p>
 *
 * @author ZJJ
 * #Description StringMethodTest
 * #Date: 2022/5/11 20:20
 */
public class StringMethodTest {
    @Test
    public void Test1() {
        String s1 = "HelloWord";
        /*length()*/
        System.out.println(s1.length());
        /*charAt()*/
        System.out.println(s1.charAt(0));
//        System.out.println(s1.charAt(9));
        /*isEmpty()*/
        System.out.println(s1.isEmpty());//false if s1是""，即空的，则是true
        /*toLowerCase*/
        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1是不可变的，仍然为原来的字符串
        System.out.println(s2);//改成小写以后的字符串

        String s3 = "    he  llo    wor d   ";
        /*trim()*/
        String s4 = s3.trim();
        System.out.println("---" + s3 + "---");
        System.out.println("---" + s4 + "---");
    }

    @Test
    public void test2() {
        String s1 = "HelloWord";
        String s2 = "helloword";
        /*equals()*/
        System.out.println(s1.equals(s2));
        /*equalsIgnoreCase()*/
        System.out.println(s1.equalsIgnoreCase(s2));
        /*concat()*/
        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);
        /*compareTo()比较时，是不会在意字符的地址等等，只会在乎内容*/
        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//-2 涉及到字符串排序（如：手机联系人）
        /*substring 左闭右开*/
        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s8);//尚硅谷教育
        String s9 = s7.substring(2, 5);
        System.out.println(s9);//尚硅谷
    }

    @Test
    public void Test3() {
        String str1 = "helloworld";
        /*endsWith()*/
        boolean b1 = str1.endsWith("rld");
        System.out.println(b1);//true
        /*startsWith()*/
        boolean b2 = str1.startsWith("He");
        System.out.println(b2);//false

        boolean b3 = str1.startsWith("ll", 2);//从指定位置进行查找
        System.out.println(b3);//true

        /*contains()  （区分大小写）*/
        String str2 = "wor";
        System.out.println(str1.contains(str2));//true
        /*indexOf()*/
        System.out.println(str1.indexOf("lo"));//3
        System.out.println(str1.indexOf("lol"));//-1

        System.out.println(str1.indexOf("lo", 5));//-1

        String str3 = "hellorworld";
        /*lastIndexOf() 与 indexOf 相比 则是效果相反的*/
        System.out.println(str3.lastIndexOf("or"));//7
        System.out.println(str3.lastIndexOf("or", 6));//4
    }
}
