package exer;

import java.util.List;

/**
 * @author ZJJ
 * #Description DAOTest
 * #Date: 2022/7/21 19:32
 */

/*创建DAO类的对象, 分别调用其save, get、update, list, delete方法来操作User对象,使用Junit单元测试类进行测试。*/
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001", new User(1001, 34, "周"));
        dao.save("1002", new User(1002, 44, "杰"));
        dao.save("1003", new User(1003, 54, "伦"));

        List<User> list = dao.list();

//        System.out.println(list);
        list.forEach(System.out::println);
    }
}
