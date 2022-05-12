package StringMethod;

import org.junit.Test;

/**
 * int length():返回字符的长度: return value.length<p>
 * char charAt(int index):返回某索引处的字符return value[index]<p>
 * boolean isEmpty():判断是否是空字符: return value.length == 0<p>
 * String toLowerCase():使用默认语言环境,将 String 中的所有字符转换为小写<p>
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

    /**
     * String replace(char oldChar, char newChar):返回一个新的字符串,它是通过用newChar替换此字符串中出现的所有oldChar得到的。<p>
     * String replace(CharSequence target, CharSequence replacement):使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。<p>
     * String replaceAll(String regex, String replacement): 使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串。<p>
     * String replaceFirst(String regex, String replacement) :使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串。<p>
     * boolean matches(String regex):知此字符串是否匹配给定的正则表达式。<p>
     * String[] split(String regex):根据给定正则表达式的匹配拆分此字符串。<p>
     * String[] split(String regex, int limit):根据匹配给定的正则表达式来拆分此字符串,最多不超过limit个,如果超过了,剩下的全部都放到最后一个元素中<p>
     */
    @Test
    public void Test4() {
        String str1 = "北京尚硅谷教育北京";
        /*replace()*/
        String str2 = str1.replace("北", "东");
        System.out.println(str1);//北京尚硅谷教育北京
        System.out.println(str2);//东京尚硅谷教育东京

        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);//上海尚硅谷教育上海
        System.out.println("*************");

        /*replaceAll()*/
        String str = "12hello34world5java7891mysq1456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有,的话去掉
        //"\\d":去掉数字  "^,|,$":将开头和结尾的,去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);//hello,world,java,mysq

        /*replaceFirst()*/
        String a = str1.replaceFirst("北", "wc");//wc京尚硅谷教育北京
        System.out.println(a);

        /*matches()*/
        str = "12345";
        //判断str字符串中是否全部有数字组成,即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);//true
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");//是否是7-8位的数字
        System.out.println(result);//true

        /*split()*/
        System.out.println("*****************");
        System.out.println("|的");
        str = "hello|world|java";
        String[] strs = str.split("\\|");//将|作为切割的
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        System.out.println(".的");
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");//将.作为切割
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
}
