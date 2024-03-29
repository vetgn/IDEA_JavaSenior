import java.io.Serializable;

/**
 * @author ZJJ
 * #Description Person
 * #Date: 2022/7/23 15:56
 */

/*
* Person需要满足如下的要求,方可序列化
* 1.需要实现的接口：Serializable
*
* 2.当前类提供一个全局常量: serialVersionUID
*
* 3.除了当前Person类需要实现Serializable接口之外,还必须保证其内部所有属性也必须是可序列化的。(默认情况下,基本数据类型可序列化)
*   相当于其他类继承了Person之后，它自身的属性也需要序列化
*
* 补充: ObjectOutputStream和objectInputStream不能序列化static和transient修饰的成员变量
* */

public class Person implements Serializable {
    private String name;
    private int age;

    public static final long serialVersionUID = 475463534532L;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
