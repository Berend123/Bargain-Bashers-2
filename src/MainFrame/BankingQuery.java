
package MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankingQuery {
    public ArrayList<banking> bankingList() throws SQLException{
        
        ArrayList<banking> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id`, `Date`, `Description`, `InOut`, `Type`, `Balance`, `value` FROM `HannesReportBankAccount`");
            
            banking pt;
            
            while(rs.next()){
                pt = new banking(rs.getInt("id"),
                                rs.getString("Date"),
                                rs.getString("Description"),
                                rs.getString("InOut"),
                                rs.getString("Type"),
                                rs.getString("Balance"),
                                rs.getString("value"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BankingQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}
