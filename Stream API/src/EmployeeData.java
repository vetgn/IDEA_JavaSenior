import java.util.ArrayList;
import java.util.List;

/**
 * @author ZJJ
 * #Description EmployeeData
 * #Date: 2022/8/2 14:32
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "D化腾", 34, 6000.38));
        list.add(new Employee(1002, "D", 12, 9876.12));
        list.add(new Employee(1003, "g", 33, 3000.82));
        list.add(new Employee(1004, "", 26, 7657.37));
        list.add(new Employee(1005, "李", 65, 5555.32));
        list.add(new Employee(1006, "H盖", 42, 9500.43));
        list.add(new Employee(1007, "任E", 26, 4333.32));
        list.add(new Employee(1008, "1克伯格", 35, 2500.32));

        return list;
    }
}
