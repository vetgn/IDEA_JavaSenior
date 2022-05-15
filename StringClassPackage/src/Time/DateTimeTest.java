package Time;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * java.lang.System类System类提供的public static long currentTimeMillis()用来返回
 * 当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。此方法适于计算时间差。
 * @author ZJJ
 * #Description DateTimeTest
 * #Date: 2022/5/14 19:24
 */
public class DateTimeTest {
//    1.System类中的currentTimeMills()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
//        返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
//        称为时间戳
        System.out.println(time);
    }

    /*
    * java.util.Date类
    *        |---java.sql.Date类
    * 1.两个构造器的使用
    *       >构造器一：Date()：创建一个当前时间的Date对象
    *       >构造器二：创建指定豪秒数的Date对象
    * 2.两个方法的使用
    *   >toString():显示当前的年、月、时、日、分、秒
    *   >getTime():获取单前Date对象对应的毫秒数。（时间戳）
    *
    * 3.java.sql.Date对应着数据库中的日期类型的变量
    *   >如何实例化
    *   >如何将java.util.Date对象转换为java.sql.Date对象
    * */
    @Test
    public void test2(){
//        构造器一：Date()：创建一个当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1);// Sat May 14 19:34:13 CST 2022

        System.out.println(date1.getTime());//1652528201652

//        构造器二：创建指定豪秒数的Date对象
        Date date2 = new Date(1652528201652L);
        System.out.println(date2);

//        创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(4453534653453L);
        System.out.println(date3);//2111-02-16

//        如何将java.util.Date对象转换为java.sql.Date对象
//        情况一：
//            Date date4  =new java.sql.Date(23134232424234L);
//            java.sql.Date date5 = (java.sql.Date) date4;
//        情况二：
        Date date6 = new Date();
        java.sql.Date date7  =new java.sql.Date(date6.getTime());//使用强转会报错
    }
}
