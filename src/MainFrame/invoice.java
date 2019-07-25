package MainFrame;

public class invoice {
    private int cid;
    private int ReferenceNumber;
    private String CustomerName;
    private String BillingAddress;
    private String ShippingAddress;
    private String product;
    private int qty;
    private int amount;
    private int total;
    private String status;
    
    public invoice(int cid, int ReferenceNumber, String CustomerName, String BillingAddress, String ShippingAddress, String product, int qty, int amount, int total, String status) {
        this.cid = cid;
        this.ReferenceNumber = ReferenceNumber;
        this.CustomerName = CustomerName;
        this.BillingAddress = BillingAddress;
        this.ShippingAddress = ShippingAddress;
        this.product = product;
        this.qty = qty;
        this.amount = amount;
        this.total = total;
        this.status = status;
    }

    invoice(int ReferenceNumber, String CustomerName, String product) {
        this.ReferenceNumber = ReferenceNumber;
        this.CustomerName = CustomerName;
        this.product = product;
    }

    invoice(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    
    invoice(int ReferenceNumber, String CustomerName, String BillingAddress, String ShippingAddress, String product, int qty, int amount, int total, String status) {
        this.ReferenceNumber = ReferenceNumber;
        this.CustomerName = CustomerName;
        this.product = product;
        this.qty = qty;
        this.amount = amount;
        this.total = total;
        this.status = status;
    }

    invoice(int ReferenceNumber, String CustomerName, String product, String status, int qty) {
        this.ReferenceNumber = ReferenceNumber;
        this.CustomerName = CustomerName;
        this.product = product;
        this.status = status;
        this.qty = qty;
    }
    
    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getReferenceNumber() {
        return ReferenceNumber;
    }

    public void setReferenceNumber(int ReferenceNumber) {
        this.ReferenceNumber = ReferenceNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(String BillingAddress) {
        this.BillingAddress = BillingAddress;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String ShippingAddress) {
        this.ShippingAddress = ShippingAddress;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
