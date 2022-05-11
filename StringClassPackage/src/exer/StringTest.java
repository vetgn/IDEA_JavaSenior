package exer;

/**
 * 一道面试题
 * @author ZJJ
 * #Description StringTest
 * #Date: 2022/5/11 20:05
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good  String的不可变性
        System.out.println(ex.ch);//best char数组不是不可变的
    }
}
