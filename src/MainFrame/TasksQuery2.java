/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berendfuchs
 */
public class TasksQuery2 {
    public ArrayList<tasks2> tasksList2() throws SQLException{
        
        ArrayList<tasks2> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        String nameToBeSorted = MainFrame.jLabel48.getText();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id`, `customerName`, `date`, `task`, `status` FROM `ToDos` where `date` > NOW()");
            
            tasks2 pt;
            
            while(rs.next()){
                pt = new tasks2(rs.getInt("id"),
                                rs.getString("customerName"),
                                rs.getString("date"),
                                rs.getString("task"),
                                rs.getString("status"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TasksQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}
