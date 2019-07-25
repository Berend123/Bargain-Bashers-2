package MainFrame.Create.customer;

public class customer {
    private int cid;
    private String Name;
    private String Balance;
    private String Contact;
    
    public customer(int cid, String Name, String Balance, String Contact) {
        this.cid = cid;
        this.Name = Name;
        this.Balance = Balance;
        this.Contact = Contact;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String Balance) {
        this.Balance = Balance;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }
    


}
