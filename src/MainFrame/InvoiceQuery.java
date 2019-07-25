
package MainFrame;

import MainFrame.Create.RecievePayments.RecievePayments;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceQuery {
    public ArrayList<invoice> invoiceList() throws SQLException{
        
        ArrayList<invoice> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT DISTINCT `ReferenceNumber`, `CustomerName`, `product` FROM `Invoices`");
            
            invoice pt;
            
            while(rs.next()){
                pt = new invoice(rs.getInt("ReferenceNumber"),
                                rs.getString("CustomerName"),
                                rs.getString("product"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
    public ArrayList<invoice> invoiceListSortBy() throws SQLException{
        
        ArrayList<invoice> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
            String sortByComboRawData = MainFrame.jComboBox1.getSelectedItem().toString();
            String sortBy;
            
            if (sortByComboRawData == "Customers with Order Status") {
                sortBy = "SELECT DISTINCT `CustomerName` FROM `Invoices` WHERE `status` = 'Order'";
            } else if (sortByComboRawData == "Customers with Active Status") {
                sortBy = "SELECT DISTINCT `CustomerName` FROM `Invoices` WHERE `status` = 'Active'";
            } else if (sortByComboRawData == "Customers with Lay-Bye Status") {
                sortBy = "SELECT DISTINCT `CustomerName` FROM `Invoices` WHERE `status` = 'Lay-Bye'";
            } else if (sortByComboRawData == "Customers with Done Status") {
                sortBy = "SELECT DISTINCT `CustomerName` FROM `Invoices` WHERE `status` = 'Done'";
            } else  {
                sortBy = "SELECT DISTINCT `CustomerName` FROM `Invoices`";
                //
            }
        
        try{
            st = con.createStatement();
            rs = st.executeQuery(sortBy);
            
            invoice pt;
            
            while(rs.next()){
                pt = new invoice(rs.getString("CustomerName"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
    public ArrayList<invoice> invoiceListSortByName() throws SQLException{
        
        ArrayList<invoice> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT `referenceNumber`, `CustomerName`, `product`, `status`, `qty` FROM `Invoices` WHERE `CustomerName` = '"+RecievePayments.jComboBoxCustomer.getSelectedItem().toString()+"'");
            
            invoice pt;
            
            while(rs.next()){
                pt = new invoice(rs.getInt("referenceNumber"),
                                rs.getString("CustomerName"),
                                rs.getString("product"),
                                rs.getString("status"),
                                rs.getInt("qty"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}
//"SELECT DISTINCT `CustomerName` FROM `Invoices` WHERE `status` = "+RecievePayments.jComboBoxInvoiceNumber.getSelectedItem().toString()+"";