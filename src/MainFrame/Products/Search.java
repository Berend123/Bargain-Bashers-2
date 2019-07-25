
package MainFrame.Products;

public class Search {
    private int id;
    private String productname;
    private String category;
    private int instock;
    private int costperunit;
    private int sellingprice;
    private int LIQUIDATEATMINIMUM;
    private String Name;
    private String ProductName;
    
    public Search(int Id,String Productname,String Category,int Instock,int Costperunit,int Sellingprice,int LIQUIDATEATMINIMUM){
        this.id = Id;
        this.productname = Productname;
        this.category = Category;
        this.instock = Instock;
        this.costperunit = Costperunit;
        this.sellingprice = Sellingprice;
        this.LIQUIDATEATMINIMUM = LIQUIDATEATMINIMUM;
    }

    public Search(String Name) {
        this.Name = Name;
    }
    
    public String getName() {
        return Name;
    }

    public int getId() {
        return id;
    }

    public String getProductname() {
        return productname;
    }

    public String getCategory() {
        return category;
    }

    public int getInstock() {
        return instock;
    }

    public int getCostperunit() {
        return costperunit;
    }

    public int getSellingprice() {
        return sellingprice;
    }

    public int getLIQUIDATEATMINIMUM() {
        return LIQUIDATEATMINIMUM;
    }
    
    
}
