/**
 * @author ZJJ
 * #Description SeasonTest
 * #Date: 2022/6/27 15:16
 */

/*
使用enum关键字
说明定义的枚举类继承的是java.lang.Enum类

*/
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;

        //toString():
        System.out.println(summer);

        System.out.println("****************");
//        System.out.println(Season1.class.getSuperclass());

        //value():
        Season1[] value = Season1.values();
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
            value[i].show();
        }
        System.out.println("****************");

        //valueOf(String objName)
//        如果没有写的objName参数，则会报IllegalArgumentException异常
//        Season1 winter = Season1.valueOf("WINTER1");
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}

interface Info {
    void show();
}

//使用enum关键字枚举类
enum Season1 implements Info {
    //1.提供当前枚举类的多个对象，多个对象之间用“,”隔开，末尾对象“;”结束
    SPRING("春天", "春暖花开"){
        public void show(){
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        public void show(){
            System.out.println("夏天在哪里");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        public void show(){
            System.out.println("秋天在哪里");
        }
    },
    WINTER("冬天", "冰天雪地"){
        public void show(){
            System.out.println("冬天在哪里");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象属性赋值
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.其他诉求1:获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    /*如果没有重写，那么继承的就不是java.lang.Enum类*/
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

    @Override//这样四个季节调用的时候就会这一个
    public void show() {
        System.out.println("这是一个季节!");
    }
}
