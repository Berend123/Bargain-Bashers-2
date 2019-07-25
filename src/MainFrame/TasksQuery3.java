/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame;

import static MainFrame.MainFrame.jDateChooserFrom;
import static MainFrame.MainFrame.jDateChooserTo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author berendfuchs
 */
public class TasksQuery3 {
    public ArrayList<tasks3> tasksList3() throws SQLException{
        
        ArrayList<tasks3> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT Invoices.product, Invoices.qty, Invoices.total, products.costperunit, (total - costperunit)"
                    + " as profit FROM Invoices join products on Invoices.product=products.productname where"
                    + " Invoices.DateCreated BETWEEN '"+((JTextField)jDateChooserFrom.getDateEditor().getUiComponent()).getText()+"' and "
                            + "'"+((JTextField)jDateChooserTo.getDateEditor().getUiComponent()).getText()+"'");
            
            tasks3 pt;
            
            while(rs.next()){
                pt = new tasks3(rs.getString("product"),
                                rs.getInt("qty"),
                                rs.getInt("costperunit"),
                                rs.getInt("total"),
                                rs.getInt("profit"));
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TasksQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}
