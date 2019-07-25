
package MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceQuery2 {
    public ArrayList<invoice> invoiceList() throws SQLException{
        
        ArrayList<invoice> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT DISTINCT `ReferenceNumber`, `CustomerName`, "
                    + "`BillingAddress`, `ShippingAddress`, `product`, `qty`, `amount`,"
                    + " `total`, `status` FROM `Invoices`");
            
            invoice pt;
            
            while(rs.next()){
                pt = new invoice(rs.getInt("ReferenceNumber"),
                                rs.getString("CustomerName"),
                                rs.getString("BillingAddress"),
                                rs.getString("ShippingAddress"),
                                rs.getString("product"),
                                rs.getInt("qty"),
                                rs.getInt("amount"),
                                rs.getInt("total"),
                                rs.getString("status"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}