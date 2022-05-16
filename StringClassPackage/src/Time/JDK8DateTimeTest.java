package Time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * 可变性:像日期和时间这样的类应该是不可变的。
 * 偏移性: Date中的年份是从1900开始的,而月份都从0开始。
 * 格式化:格式化只对Date有用, Calendar则不行。
 * 此外,它们也不是线程乘全的;不能处理闺秒等。
 *
 * @author ZJJ
 * #Description JDK8DateTimeTest
 * #Date: 2022/5/16 18:40
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate() {
//        偏移量
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);//看源代码
        System.out.println(date1);//Tue Sep 08 00:00:00 CST 2020

    }

    /*
     * LocalDate、LocalTime、LocalDateTime的使用
     * 1.LocalDateTime相较于LocalDate、LocalTime、LocalDateTime,使用频率较高
     * 2.类似于Calendar
     * */
    @Test
    public void test1() {
//        now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);//2022-05-16
        System.out.println(localTime);//18:49:26.880
        System.out.println(localDateTime);//2022-05-16T18:49:26.880

//        of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 10, 8, 12, 23, 8);
        System.out.println(localDateTime1);//2022-10-08T12:23:08

        //getXxx():获得相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        System.out.println("***********************");

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        System.out.println("**************");

        //
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusMonths(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /*
     * instant的使用
     * 类似于java.util.Date类
     * */
    @Test
    public void test2() {
//      now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2022-05-16T11:47:55.628Z

//        添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2022-05-16T19:47:55.628+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);//1652701921451

        Instant ofEpochMilli = Instant.ofEpochMilli(milli);
        System.out.println(ofEpochMilli);//2022-05-16T11:54:37.739Z
    }


    /*
     * DateTimeFormatter:格式化或解析日时间
     * 类似于SimpleDateFormat
     * */
    @Test
    public void test3() {
//     方式一：  预定义的标准格式。如: ISO_LOCAL_DATE_TIME; ISO_LOCAL_DATE; ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期--->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析：字符串 ---> 日期
        TemporalAccessor parse = formatter.parse(str1);
        System.out.println(parse);
//    方式二：
        //本地化相关的格式。如: ofLocalizedDateTime()
        // FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        String str3 = formatter2.format(localDateTime);
        System.out.println(str2);//22-5-16 下午8:12
        System.out.println(str3);//2022年5月16日 下午08时23分29秒

        // 本地化相关的格式。如: ofLocalizedDate()
        // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDate
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str4 = formatter3.format(LocalDate.now());
        System.out.println(str4);
//    重点：  方式三:   自定义的格式。如: ofPattern("yyyy-MM-dd hh:mm: ss")
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str5 = formatter4.format(LocalDateTime.now());
        System.out.println(str5);//2022-05-16 10:22:54

        //解析
        TemporalAccessor accessor = formatter4.parse("2022-05-16 10:22:54");
        System.out.println(accessor);
    }
}
