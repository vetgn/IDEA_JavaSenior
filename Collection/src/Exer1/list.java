package Exer1;

import org.junit.Test;

import java.util.*;

/**
 * @author ZJJ
 * #Description list
 * #Date: 2022/7/19 13:35
 */
public class list {

    /*1.请从键盘随机输入10个整数保存到List中,并按倒序、从大到小的顺序显示出来*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list;
        String[] arr = new String[10];
        System.out.println("请输入");
        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.next();
        }
        list = Arrays.asList(arr);
        Collections.reverse(list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return s1.compareTo(s2);
                }
                throw new RuntimeException("传入数据类型不一致");
            }
        });
        System.out.println(list);
    }

    /*2.请把学生名与考试分数录入到集合中,并按分数显示前三名成绩学员的名字。TreeSet(Student(name,score,id));*/
    @Test
    public void test1() {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    Student student1 = (Student) o1;
                    Student student2 = (Student) o2;
                    return -Double.compare(student1.getScore(), student2.getScore());
                }
                throw new RuntimeException("错误");
            }
        });
        Student student1 = new Student("Tom", 23.2, 1);
        Student student2 = new Student("Jom", 34.3, 2);
        Student student3 = new Student("Aom", 54.4, 3);
        Student student4 = new Student("TSom", 78.2, 4);
        Student student5 = new Student("Som", 96.1, 5);

        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);
        set.add(student5);

        int i=1;
        Iterator iterator = set.iterator();
        while (iterator.hasNext() && i <= 3) {
            System.out.println(iterator.next());
            i++;
        }
    }
}

class Student {
    private String name;
    private double score;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, double score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.score, score) == 0 && id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }
}
