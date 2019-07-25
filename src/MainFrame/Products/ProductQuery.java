
package MainFrame.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductQuery {
    public ArrayList<product> productList() throws SQLException{
        
        ArrayList<product> clist = new ArrayList<>();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        Statement st;
        ResultSet rs;
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id`, `productname`, `category`, `instock`, `costperunit`, `sellingprice`, `LIQUIDATEATMINIMUM` FROM `products`");
            
            product pt;
            
            while(rs.next()){
                pt = new product(rs.getInt("id"),
                                rs.getString("productname"),
                                rs.getString("category"),
                                rs.getInt("instock"),
                                rs.getInt("costperunit"),
                                rs.getInt("sellingprice"),
                                rs.getInt("LIQUIDATEATMINIMUM"));
                                
                clist.add(pt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}
