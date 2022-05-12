package StringMethod.exer;

/**
 * @author ZJJ
 * #Description Trim
 * #Date: 2022/5/12 21:12
 */
public class Method {
    public static void main(String[] args) {
        System.out.println("trim方法");
        String str = "   he  ll e   ";
        System.out.println("---" + trim(str) + "---");
        System.out.println("反转方法");
        str = "abcdefg";
        System.out.println(Reversal(str,2,5) );
    }

    /*模拟一个trim方法，去除字符串两端的空格*/
    public static String trim(String str) {
        if (str != null) {
            int start = 0;
            int last = str.length();
//为什么不用 if 而用 while ？ ---> if语句只会执行一次
            while (start < last && str.charAt(start) == ' ') {
                start++;
            }

            while (start < last && str.charAt(last - 1) == ' ') {
                last--;
            }

            return str.substring(start, last);
        }
        return null;
    }

    /*将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg"反转为"abfedcg”*/
    public static String Reversal(String string, int start, int end) {
        if (string != null) {
            char[] chars = string.toCharArray();
            char t;
            for (int i = start, j = end; i < j; i++, j--) {
                t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
            }
            return new String(chars);
        }
        return null;
    }
    /*获取一个字符串在另一个字符串中出现的次数。比如:获取" ab"在"abkkcadkabkebfkabkskab”中出现的次数*/
    /*获取两个字符串中最大相同子串。比如:str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"提示:将短的那个串进行长度依次递减的子串与较长的串比较。*/
    /*对字符串中字符进行自然顺序排序。提示:1)字符串变成字符数组2)对数组排序,选择,冒泡, Arrays.sort();3)将排序后的数组变成字符串|*/
}
