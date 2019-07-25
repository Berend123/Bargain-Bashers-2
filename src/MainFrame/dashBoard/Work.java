package MainFrame.dashBoard;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Work extends JFrame implements ActionListener{
    JLabel JL_fname,JL_lname,JL_age,JL_id;
    JTextField JT_fname,JT_lname,JT_age,JT_id;
    JButton btn_search;

      public Work(){
          super("Search");
          JL_id = new JLabel("Enter ID:");
          JL_id.setBounds(20, 20, 200, 20);
          JT_id = new JTextField(20);
          JT_id.setBounds(130, 20, 150, 20);
          btn_search = new JButton("Search");
          btn_search.setBounds(300, 20, 80, 20);
          btn_search.addActionListener(this);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(500,200);
          
          JL_fname = new JLabel("Fname: ");
          JL_fname.setBounds(20, 50, 100, 20);
          JT_fname = new JTextField(20);
          JT_fname.setBounds(130, 50, 150, 20);
          JL_lname = new JLabel("Lname: ");
          JL_lname.setBounds(20, 80, 100, 20);
          JT_lname = new JTextField(20);
          JT_lname.setBounds(130, 80, 150, 20);
          JL_age = new JLabel("Age: ");
          JL_age.setBounds(20, 110, 100, 20);
          JT_age = new JTextField(20);
          JT_age.setBounds(130, 110, 150, 20);
          setLayout(null);
          add(btn_search);
          add(JL_fname);
          add(JT_fname);
          add(JL_lname);
          add(JT_lname);
          add(JL_age);
          add(JT_age);
          add(JL_id);
          add(JT_id);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
    Function f = new Function();
    ResultSet rs = null;
    String fn = "fname";
    String ln = "lname";
    String ag = "age";
    
    rs = f.find(JT_id.getText());
    try{
      if(rs.next()){
          JT_fname.setText(rs.getString("fname"));
            JT_lname.setText(rs.getString("lname"));
              JT_age.setText(rs.getString("age"));
      }  else{
          JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
      }
    }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
   public class Function{
       Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
       public ResultSet find(String s){
           try{
           con = DriverManager.getConnection("jdbc:mysql://localhost/test_db","root","");
           ps = con.prepareStatement("select * from users where id = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
       
   }

    
 public static void main(String[] args){
  new Work();
 }
 
}
/////////////////// END :)