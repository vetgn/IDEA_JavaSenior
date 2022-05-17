/*
 * @Author: vetgn
 * @Date: 2022-05-05 08:54:08
 * @LastEditors: vetgn
 * @LastEditTime: 2022-05-05 09:29:46
 * @FilePath: \vscode_Java_SanGuiGu\SCHOOL\src\Practice\SupermarketList.java
 * @Description:
 * 使之能提供以下功能：
 * 1、商品信息录入功能0
 * 2、商品信息文件读取功能 ----
 * 3、商品信息文件保存功能 ----
 * 4、商品信息浏览功能0
 * 5、查询功能：
 *       1）按商品名称查询
 *       2）按类别名称查询
 * 6、修改功能：0
 *     根据商品ID修改相应信息；
 * 7、删除商品功能：0
 *     删除指定ID的商品。
 * 8、排序功能（由用户指定按照名称或ＩＤ；指定升序或降序）
 *
 */
package Project_01;

public class SupermarketList {
    private Commodity[] commodities;
    private int total;// 记录商品的数量

    /**
     * 初始化商品信息
     *
     * @param totalcommodity
     */
    public SupermarketList(int totalcommodity) {
        commodities = new Commodity[totalcommodity];
    }

    /**
     * 商品信息录入功能
     */
    public boolean addCommodity(Commodity commodity) {
        if (total >= commodities.length) {
            return false;
        }

        commodities[total++] = commodity;
        return true;
    }

    //TODO:

    /**
     * 查看指定的商品信息
     */
    public Commodity[] lookCommodity() {
        Commodity[] com = new Commodity[total];
        for (int i = 0; i < total; i++) {
            com = commodities;
        }
        return com;
    }

    /**
     * 修改指定商品的信息
     */
    public void amendCommodity(int ID, Commodity commodity) {
        commodities[ID] = commodity;
    }

    /**
     * 删除指定商品
     *
     * @param ID
     */
    public void deleteCommodity(int ID) {
        for (int i = ID; i < commodities.length; i++) {
            commodities[i] = commodities[i++];
        }
        commodities[--total] = null;
    }

    /*得到指定id的商品*/
    public Commodity getcommodity(int id) {
        return commodities[id - 1];
    }

    /*
     * 得到商品的数量
     * */
    public int getTotal() {
        return total;
    }
}