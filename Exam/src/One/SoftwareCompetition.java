package One;

import java.util.Scanner;

/**
 * @author ZJJ
 * #Description One.SoftwareCompetition
 * #Date: 2022/5/31 10:08
 */
public class SoftwareCompetition {
    public static void main(String[] args) {
        Team[] teams = new Team[5];
        Scanner scanner = new Scanner(System.in);
        String name, introduction;
        for (int i = 0; i < 5; i++) {
            System.out.print("请输入姓名:");
            name = scanner.next();
            System.out.print("请输入介绍:");
            introduction = scanner.next();
            teams[i] = new Team(name, (i + 1), introduction);
        }
        for (Team e : teams) {
            System.out.println(e.getName() + "\t" + e.getNumberofMember() + "\t" + e.getIntroduction());
        }
    }
}
