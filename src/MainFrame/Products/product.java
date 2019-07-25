
package MainFrame.Products;

public class product {
    private int cid;
    private String productname;
    private String category;
    private int instock;
    private int costperunit;
    private int sellingprice;
    private int LIQUIDATEATMINIMUM;
   

    public product(int cid, String productname, String category, int instock, int costperunit, int sellingprice, int LIQUIDATEATMINIMUM) {
        this.cid = cid;
        this.productname = productname;
        this.category = category;
        this.instock = instock;
        this.costperunit = costperunit;
        this.sellingprice = sellingprice;
        this.LIQUIDATEATMINIMUM = LIQUIDATEATMINIMUM;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInstock() {
        return instock;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    public int getCostperunit() {
        return costperunit;
    }

    public void setCostperunit(int costperunit) {
        this.costperunit = costperunit;
    }
    
    public int getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(int sellingprice) {
        this.sellingprice = sellingprice;
    }

    public int getLIQUIDATEATMINIMUM() {
        return LIQUIDATEATMINIMUM;
    }

    public void setLIQUIDATEATMINIMUM(int LIQUIDATEATMINIMUM) {
        this.LIQUIDATEATMINIMUM = LIQUIDATEATMINIMUM;
    }
    
    
    
}
