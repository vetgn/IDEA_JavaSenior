package Three;

/**
 * @author ZJJ
 * #Description SaleManager
 * #Date: 2022/5/31 11:12
 */
public class SaleManager extends Employee {
    private double salesRevenue;
    private double salesProfit;

    public double getSalesRevenue() {
        return salesRevenue;
    }

    public void setSalesRevenue(double salesRevenue) {
        this.salesRevenue = salesRevenue;
    }

    public double getSalesProfit() {
        return salesProfit;
    }

    public void setSalesProfit(double salesProfit) {
        this.salesProfit = salesProfit;
    }

    public void showMessage() {

    }
}
