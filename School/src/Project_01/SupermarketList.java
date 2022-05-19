package Project_01;

public class SupermarketList {
    private final Commodity[] commodities;
    private int total;// 记录商品的数量

    /**
     * 初始化商品信息
     *
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
    /*输出指定商品*/
    public void PrintCommodity(int i){
        System.out.println(commodities[i].getName()
                + "\t\t" + commodities[i].getID() + "\t\t" +
                commodities[i].getPrice() + "\t\t\t" +
                commodities[i].getCategory() + "\t\t\t" +
                commodities[i].getNumber() + "\t\t\t" +
                commodities[i].getDays());
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
        for (int i = ID; i < total-1; i++) {
            commodities[i] = commodities[i+1];
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