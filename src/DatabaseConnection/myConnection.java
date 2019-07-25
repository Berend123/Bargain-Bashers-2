package DatabaseConnection;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class myConnection {
    
    public static Connection getConnection(){
        
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase", "Berend", "kidcoltv6");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con; 
    }
}

