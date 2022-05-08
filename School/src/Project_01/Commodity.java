/*
 * @Author: vetgn
 * @Date: 2022-05-05 08:46:06
 * @LastEditors: vetgn
 * @LastEditTime: 2022-05-08 22:40:05
 * @FilePath: \vscode_Java_SanGuiGu\SCHOOL\src\Practice\Commodity.java
 * @Description: 
 * 1.超市商品管理信息系统
 * 超市商品信息包括：商品名称、商品ID、商品价格、类别（食品、纸质、
 * 洗化、电器等）、商品份数、商品生产(生产厂家)、保质天数。试用面向对象程序设计思想，
 * 设计一食堂菜品管理信息系统，使之能提供以下功能：
 * 1、商品信息录入功能
 * 2、商品信息文件读取功能
 * 3、商品信息文件保存功能
 * 4、商品信息浏览功能
 * 5、查询功能：
 *       1）按商品名称查询
 *       2）按类别名称查询
 * 6、修改功能：
 *     根据商品ID修改相应信息；
 * 7、删除商品功能：
 *     删除指定ID的商品。
 * 8、排序功能（由用户指定按照名称或ＩＤ；指定升序或降序）
 * 9、退出
 * 
 */
package Project_01;

public class Commodity {
    private String name;// 商品名称
    private String ID;// 商品ID
    private double price;// 商品价格
    private String category;// 商品类别（食品、纸质、洗化、电器等）
    private int number;// 商品份数
    private String factory;// 商品生产
    private int days;// 商品天数

    private static final int FOOD = 0;
    private static final int PAPER = 1;
    private static final int CLEANING = 2;
    private static final int ELECTRIC = 3;

    public Commodity() {
    }

    public Commodity(String name, String ID, double price, String category, int number, String factory, int days) {
        this.name = name;
        this.ID = ID;
        this.price = price;
        this.category = category;
        this.number = number;
        this.factory = factory;
        this.days = days;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

}
