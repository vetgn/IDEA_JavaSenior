import java.util.List;
import java.util.stream.Stream;

/**
 * @author ZJJ
 * #Description StreamAPITest1
 * #Date: 2022/8/2 14:59
 */

/*
 * 测试Stream的中间操作
 *
 * */
public class StreamAPITest1 {

    //1-筛选与切片
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
//        filter(Predicate p) 接收Lambda ,从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        //练习:查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

//        limit(n) 截断流,使其元素不超过给定数量。


//        skip(n)-跳过元素,返回一个扔掉了前n个元素的流。若流中元素不足n个,则返回一个空流。与limit(n)互补
//        distinct()--筛选,通过流所生成元素的hashCode()和 equals()去除重复元素
    }

    public void test2() {
    }

    public void test3() {
    }

    public void test4() {
    }

    public void test5() {
    }
}
