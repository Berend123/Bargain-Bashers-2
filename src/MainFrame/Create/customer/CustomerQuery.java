
package MainFrame.Create.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerQuery {
    public ArrayList<customer> customerList() throws SQLException{
        
        ArrayList<customer> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT `ID`, `Name`, `Balance`, `Contact` FROM `Customers`");
            
            customer pt;
            
            while(rs.next()){
                pt = new customer(rs.getInt("ID"),
                                rs.getString("Name"),
                                rs.getString("Balance"),
                                rs.getString("Contact"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}
