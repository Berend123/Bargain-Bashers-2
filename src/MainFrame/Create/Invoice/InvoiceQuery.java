
package MainFrame.Create.Invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceQuery {
    public ArrayList<invoicegetter> invoiceList() throws SQLException{
        
        ArrayList<invoicegetter> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM `products` WHERE `productname`");
            
            invoicegetter pt;
            
            while(rs.next()){
                pt = new invoicegetter(rs.getInt("sellingprice"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}
