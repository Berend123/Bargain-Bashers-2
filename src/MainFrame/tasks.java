
package MainFrame;

public class tasks {
    private String Date;
    private String Task;
    private String Status;
    
    public tasks(String Date, String Task, String Status) {
        this.Date = Date;
        this.Task = Task;
        this.Status = Status;
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
