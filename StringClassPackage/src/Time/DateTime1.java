package Time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8 之前的日期时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date 和 子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @author ZJJ
 * #Description DateTime1
 * #Date: 2022/5/15 17:03
 */
public class DateTime1 {
    /*
     * 的使用：SimpleDateFormat对日期Date类的格式化和解析
     *
     * 1.两个操作：
     * 1.1格式化： 日期 ---> 字符串
     * 1.2 解析：格式化的逆过程，字符串 ---> 日期
     *
     * 2.SimpleDateFormat的实例化
     *
     * 总结：
     * 1.先实例化SimpleDateFormat，此时它有一个默认的构造器，自己也可对日期的格式进行修改
     * 2.new Date() 获得当前的日期 ---> 再使用format()进行格式化，转换成字符串
     * 3.解析时，使用parse()对字符串进行解析，注意：字符串的格式要与SimpleDateFormat的格式相同
     * 注意：format() 与 parse() 都是DateFormat类中的方法，使用时，是用SimpleDateFormat的对象
     * */

    @Test
    public void testSimpleDateFormat() throws ParseException {
//      实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

//        格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

//        解析：格式化的逆过程，字符串 ---> 日期
        String str = "22-5-15 下午5:17";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

//        **************按照指定的方式格式化和解析:调用带参的构造器****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2022-05-15 05:29:39
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式
        //否则，抛异常
        Date date2 = sdf1.parse("2022-05-15 05:29:39");
        System.out.println(date2);
    }

    /*
     * 练习一：字符串"2020-09-08"转换为java.sql.Date
     * */
    @Test
    public void testExer() throws ParseException {
        String brith = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(brith);

        java.sql.Date brithDate = new java.sql.Date(date.getTime());
        System.out.println(brithDate);
    }

    /*
     * 练习二："三天打渔两天晒网" 1990-01-01 XXXX-XX-XX 打渔？晒网？
     *
     * 举例：220-09-08 ？ 总天数
     *
     * 总天数 % 5 == 1,2,3 : 打渔
     * 总天数 % 5 == 4,0 : 晒网
     *
     * 总天数的计算？
     * 方式一：(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
     * 方式二：1990-01-01 --> 2019-12-31 + 2020-01-01 --> 2020-09-08
     * */

    /*
     * Calendar日历类（抽象类）的使用
     * */
    @Test
    public void testCalendar() {
//        1.实例化
//        方式一：创建其子类（GregorianCalendaer）的对象
//        方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

//        2.常用方法
//        get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.printf("*******");

//        set()  是void方法 对calendar本身进行了修改
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

//        add()  void方法
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
//        没有delete方法，加负数就行

//        getTime():日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date);

//        setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
