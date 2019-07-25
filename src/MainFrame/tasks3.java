
package MainFrame;

public class tasks3 {
    private String product;
    private int qty;
    private int costperunit;
    private int total;
    private int profit;
    
    public tasks3(String product, int qty, int costperunit, int total, int profit) {
        this.product = product;
        this.qty = qty;
        this.costperunit = costperunit;
        this.total = total;
        this.profit = profit;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }
    
    public void setCostperunit(int costperunit) {
        this.costperunit = costperunit;
    }

    public int getCostperunit() {
        return costperunit;
    }
    
    public void setTotal(int Date) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getProfit() {
        return profit;
    }
}
