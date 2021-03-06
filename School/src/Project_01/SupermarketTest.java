/*
 * @Author: vetgn
 * @Date: 2022-05-05 08:54:27
 * @LastEditors: vetgn
 * @LastEditTime: 2022-05-05 08:54:28
 * @FilePath: \vscode_Java_SanGuiGu\SCHOOL\src\Practice\SupermarketTest.java
 * @Description:
 *
 */
package Project_01;

import java.util.Scanner;
//System.out.println("商品名称\t商品ID\t商品价格\t类别\t商品份数\t商品生产\t保质天数");

public class SupermarketTest {
    Scanner scanner = new Scanner(System.in);
    private final SupermarketList supermarketList = new SupermarketList(10);

    /*菜单功能*/
//    TODO:差文件的读入，存档
    public void Menu() {
        System.out.println("1-浏览商品");
        System.out.println("2-录入商品");
        System.out.println("3-修改商品");
        System.out.println("4-删除商品");
        System.out.println("5-商品排序");
        System.out.println("6-商品查询");
        System.out.println("7-退出");
        System.out.print("请输入数字(1-7):");

        int sign = 0;
        try {
            sign = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入错误!");
        }
        //TODO:希望输入错误以后能够再次输入

        if (sign >= 1 && sign <= 7) {
            switch (sign) {
                case 1:
                    LookCommodity();
                    break;
                case 2:
                    AddCommodity();
                    break;
                case 3:
                    AmendCommodity();
                    break;
                case 4:
                    try {
                        DeleteCommodity();
                        break;
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                case 5:
                    SortCommodity();
                    break;
                case 6:
                    InquireCommodity();
                    break;
                case 7:
                    System.out.print("是否确认退出(Y/N):");
                    String sign1 = scanner.next();
                    if (sign1.equalsIgnoreCase("Y")) {
                        break;
                    } else if (sign1.equalsIgnoreCase("N")) {
                        Menu();
                    } else {
                        System.out.println("输入错误！");
                        Menu();
                    }
            }
        }
    }

    /*添加商品*/
    public void AddCommodity() {
        System.out.println("----------添加商品----------");
        //商品名称
        System.out.print("请输入商品名称:");
        String name = scanner.next();
        //商品价格
        System.out.print("请输入商品价格:");
        double price = scanner.nextDouble();
        //类别
        System.out.print("请输入商品类别:");
        String category = scanner.next();
        //商品份数
        System.out.print("请输入商品份数:");
        int number = scanner.nextInt();
        //商品生产
        System.out.print("请输入商品生产厂家:");
        String factory = scanner.next();
        //保质天数
        System.out.print("请输入商品保质天数:");
        int days = scanner.nextInt();

        //封装到商品信息中
        Commodity commodity1 = new Commodity(name, price, category, number, factory, days, (supermarketList.getTotal() + 1));
        //添加商品
        boolean s = supermarketList.addCommodity(commodity1);
        if (s) {
            System.out.println("----------添加成功----------");
        } else {
            System.out.println("----------添加失败----------");
        }

        System.out.println();
        System.out.println();
        Menu();
    }

    /*修改商品*/
    public void AmendCommodity() {
        System.out.println("----------修改商品----------");
        if (supermarketList.getTotal() <= 0) {
            System.out.println("无商品!");
            System.out.println("----------------------------");
            Menu();
        }
        System.out.print("请输入商品的ID(-1退出):");
        for (; ; ) {
            int id = scanner.nextInt();
            if (id == -1) {
                break;
            } else if (id >= 1 && id <= supermarketList.getTotal()) {
                Commodity com = supermarketList.getcommodity(id);
                //重新输入商品名称
                System.out.print("商品名称(" + com.getName() + "):");
                String name = scanner.next();
                com.setName(name);
                //重新输入商品价格
                System.out.print("商品价格(" + com.getPrice() + "):");
                double price = scanner.nextDouble();
                com.setPrice(price);
                //重新输入商品类别
                System.out.print("商品类别(" + com.getCategory() + "):");
                String category = scanner.next();
                com.setCategory(category);
                //重新输入商品份数
                System.out.print("商品份数(" + com.getNumber() + "):");
                int number = scanner.nextInt();
                com.setPrice(number);
                //重新输入商品生产厂家
                System.out.print("商品生产厂家(" + com.getFactory() + "):");
                String factory = scanner.next();
                com.setFactory(factory);
                //重新输入商品保质天数
                System.out.print("商品保质天数:" + com.getDays() + "):");
                int days = scanner.nextInt();
                com.setDays(days);

                System.out.println();
                System.out.println();
                Menu();
            }
        }
    }

    /*删除商品*/
    public void DeleteCommodity() throws MyException {
        System.out.println("----------删除商品----------");
        if (supermarketList.getTotal() <= 0) {
            System.out.println("无商品!");
            System.out.println("----------------------------");
            Menu();
        }
        System.out.print("请输入指定商品的ID:");
        int id = scanner.nextInt();
        if (id > supermarketList.getTotal() + 1 || id <= 0) {
            throw new MyException("没有这个商品!");
        } else {
            //进行删除操作
            supermarketList.deleteCommodity(id - 1);
            System.out.println();
            System.out.println();

            Menu();
        }
    }

    /*商品排序（由用户指定按照名称或ＩＤ；指定升序或降序）*/
//    TODO:希望排序后不会改变商品原本的顺序
    public void SortCommodity() {
        Commodity[] commodities = supermarketList.lookCommodity();
        System.out.println("----------商品排序----------");
        if (supermarketList.getTotal() <= 0) {
            System.out.println("无商品!");
            System.out.println("----------------------------");
            Menu();
        }
        System.out.print("请问该用 名称(1)/ID(2) 排序？:");
        String flag = scanner.next();
        System.out.print("请问该使用 升序(1)/降序(2) ？:");
        String sign = scanner.next();
        if (flag.equals("名称") || flag.equals("1")) {
            if (sign.equals("升序") || sign.equals("1")) {
                System.out.println("商品名称" + "\t" + "商品ID" + "\t" +
                        "商品价格" + "\t" + "商品类别" + "\t" + "商品份数"
                        + "\t" + "商品天数");
                Commodity t;
                for (int i = 0; i < supermarketList.getTotal() - 1; i++) {
                    for (int j = i + 1; j < supermarketList.getTotal(); j++) {
                        if (commodities[j].getName().compareTo(commodities[i].getName()) > 0) {
                            t = commodities[j];
                            commodities[j] = commodities[i];
                            commodities[i] = t;
                        }
                    }
                }
                for (int i = supermarketList.getTotal() - 1; i >= 0; i--) {
                    supermarketList.PrintCommodity(i);
                }
                System.out.println("----------------------------");
                Menu();
            } else if (sign.equals("降序") || sign.equals("2")) {
                System.out.println("商品名称" + "\t" + "商品ID" + "\t" +
                        "商品价格" + "\t" + "商品类别" + "\t" + "商品份数"
                        + "\t" + "商品天数");
                Commodity t;
                for (int i = 0; i < supermarketList.getTotal() - 1; i++) {
                    for (int j = i + 1; j < supermarketList.getTotal(); j++) {
                        if (commodities[j].getName().compareTo(commodities[i].getName()) > 0) {
                            t = commodities[j];
                            commodities[j] = commodities[i];
                            commodities[i] = t;
                        }
                    }
                }
                for (int i = 0; i < supermarketList.getTotal(); i++) {
                    supermarketList.PrintCommodity(i);
                }
            }

            System.out.println("----------------------------");
            Menu();

        } else if (flag.equalsIgnoreCase("ID") || flag.equals("2")) {
            if (sign.equals("升序") || sign.equals("1")) {
                System.out.println("商品名称" + "\t" + "商品ID" + "\t" +
                        "商品价格" + "\t" + "商品类别" + "\t" + "商品份数"
                        + "\t" + "商品天数");
                for (int i = 0; i < supermarketList.getTotal(); i++) {
                    for (int j = 0; j < supermarketList.getTotal(); j++) {
                        if (commodities[j].getID() == (i + 1)) {
                            supermarketList.PrintCommodity(j);
                        }
                    }
                }
                System.out.println("----------------------------");
                System.out.println();
                System.out.println();
                Menu();
            } else if (sign.equals("降序") || sign.equals("2")) {
                System.out.println("商品名称" + "\t" + "商品ID" + "\t" +
                        "商品价格" + "\t" + "商品类别" + "\t" + "商品份数"
                        + "\t" + "商品天数");
                for (int i = supermarketList.getTotal(); i >= 0; i--) {
                    for (int j = 0; j < supermarketList.getTotal(); j++) {
                        if (commodities[j].getID() == (i + 1)) {
                            supermarketList.PrintCommodity(j);
                        }
                    }
                }
                System.out.println("----------------------------");
                System.out.println();
                System.out.println();
                Menu();
            }
        }
    }

    /*浏览商品*/
    public void LookCommodity() {
        System.out.println("----------浏览商品----------");
        if (supermarketList.getTotal() <= 0) {
            System.out.println("无商品!");
            System.out.println("----------------------------");
            Menu();
        } else {
            System.out.println("商品名称" + "\t" + "商品ID" + "\t" +
                    "商品价格" + "\t" + "商品类别" + "\t" + "商品份数"
                    + "\t" + "商品天数");
            for (int i = 0; i < supermarketList.getTotal(); i++) {
                supermarketList.PrintCommodity(i);
            }
        }

        System.out.println("----------------------------");
        Menu();
    }

    /*商品查询
     * 查询功能：
     * 1）按商品名称查询
     * 2）按类别名称查询*/
    public void InquireCommodity() {
        int number = 0;
        Commodity[] commodities = supermarketList.lookCommodity();
        System.out.println("----------商品查询----------");
        System.out.print("按照 商品名称(1)/类别名称(2) 查询?:");
        String flag1 = scanner.next();
        if (flag1.equals("1") || flag1.equals("商品名称")) {
            System.out.print("请输入商品名称");
            String name = scanner.next();
            for (int i = 0; i < supermarketList.getTotal(); i++) {
                if (name.equals(commodities[i].getName())) {
                    number++;
                }
            }
            if (number == 0) {
                System.out.println("没有此商品!");
            } else {
                System.out.println("商品名称" + "\t" + "商品ID" + "\t" +
                        "商品价格" + "\t" + "商品类别" + "\t" + "商品份数"
                        + "\t" + "商品天数");
                for (int j = 0; j < supermarketList.getTotal(); j++) {
                    if (name.equals(commodities[j].getName())) {
                        supermarketList.PrintCommodity(j);
                    }
                }

            }

            System.out.println("----------------------------");
            Menu();
        } else if (flag1.equals("2") || flag1.equals("类别名称")) {
            System.out.print("请输入商品的类别:");
            String category = scanner.next();
            for (int i = 0; i < supermarketList.getTotal(); i++) {
                if (category.equals(commodities[i].getCategory())) {
                    number++;
                }
            }
            if (number == 0) {
                System.out.println("没有此商品!");
            } else {
                System.out.println("商品名称" + "\t" + "商品ID" + "\t" +
                        "商品价格" + "\t" + "商品类别" + "\t" + "商品份数"
                        + "\t" + "商品天数");
                for (int j = 0; j < supermarketList.getTotal(); j++) {
                    if (category.equals(commodities[j].getCategory())) {
                        supermarketList.PrintCommodity(j);
                    }
                }
            }
        }
        System.out.println("----------------------------");

        Menu();

    }

    public static void main(String[] args) {
        SupermarketTest supermarketTest = new SupermarketTest();
        supermarketTest.Menu();
    }

}
