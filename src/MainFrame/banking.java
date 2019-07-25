package MainFrame;

public class banking {
    private int cid;
    private String Date;
    private String Description;
    private String InOut;
    private String Type;
    private String Balance;
    private String value;
    
    public banking(int cid, String Date, String Description, String InOut, String Type, String Balance, String value) {
        this.cid = cid;
        this.Date = Date;
        this.Description = Description;
        this.InOut = InOut;
        this.Type = Type;
        this.Balance = Balance;
        this.value = value;
    }
    
    public int getCid() {
        return cid;
    }

    public void setCid(int Cid) {
        this.cid = Cid;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getInOut() {
        return InOut;
    }

    public void setInOut(String InOut) {
        this.InOut = InOut;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String Balance) {
        this.Balance = Balance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
