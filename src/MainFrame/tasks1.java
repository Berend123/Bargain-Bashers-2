
package MainFrame;

public class tasks1 {
    private int id;
    private String customerName;
    private String Date;
    private String Task;
    private String Status;
    
    public tasks1(int id, String customerName, String Date, String Task, String Status) {
        this.id = id;
        this.customerName = customerName;
        this.Date = Date;
        this.Task = Task;
        this.Status = Status;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDate() {
        return Date;
    }

    public void setTask(String Task) {
        this.Task = Task;
    }

    public String getTask() {
        return Task;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getStatus() {
        return Status;
    }
}
