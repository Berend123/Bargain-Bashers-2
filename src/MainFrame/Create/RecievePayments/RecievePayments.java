/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame.Create.RecievePayments;

import DatabaseConnection.myConnection;
import static DatabaseConnection.myConnection.getConnection;
import MainFrame.Create.Invoice.Invoice;
import MainFrame.InvoiceModel;
import MainFrame.InvoiceQuery;
import MainFrame.MainFrame;
import MainFrame.Products.Search;
import MainFrame.TasksModel;
import MainFrame.TasksQuery;
import MainFrame.invoice;
import MainFrame.tasks;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author berendfuchs
 */
public class RecievePayments extends javax.swing.JFrame {

    /**
     * Creates new form RecievePayments
     */
    Connection con;
    PreparedStatement pst = null;
    Statement st;
    ResultSet rs;
    
    String productName = "";
    String CustomerName = "";
    
    
    Date date = new Date();
    Date dueDate= date;

    int mousepX;
    int mousepY;
    
        int sellQTY = 0;
        int oldQTY = 0;
        int newQTY = 0;
        int ID = 0;
        
    public RecievePayments() {
        initComponents();
        updateCustomerCombo();
        jDateChooserPaymentDate.setDate(date);
        jTextField1.setEnabled(false);
    }
    
    public ArrayList<Search> ListsearchCustomer(String ValToSearch){
        ArrayList<Search> searchList = new ArrayList<>();
        
        Statement st;
        ResultSet resultset;
        
        try{
            Connection connection = getConnection();
            st = (Statement) connection.createStatement();
            String searchQuery = "SELECT * FROM `Customers` WHERE `Name` LIKE '%"+ValToSearch+"%'";
            resultset = st.executeQuery(searchQuery);
            
            Search search;
            
            while(resultset.next())
            {
                search = new Search(
                                resultset.getString("Name")
                                );
                searchList.add(search);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return searchList;
    }
    
    public void searchCustomers() throws SQLException
    {
        ArrayList<Search> search = ListsearchCustomer(jTextFieldSearchCustomers.getText());
        String customer;
        jComboBoxCustomer.removeAllItems();
        for(int i = 0; i < search.size(); i++)
        {
            customer = search.get(i).getName();
            jComboBoxCustomer.addItem(customer);
        }
    }
    
    private void invoiceNumber(){
        String invoiceNumber = jComboBoxInvoiceNumber.getSelectedItem().toString();
        jLabelInvoiceNumber.setText(invoiceNumber);
    }
    
    private void updateCustomerCombo(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
            st = con.createStatement();
            String s = "select * from Customers";
            rs = st.executeQuery(s);
              while(rs.next())
              {
                  jComboBoxCustomer.addItem(rs.getString(2));
              }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "ERROR");
    }finally{
        try{
            st.close();
            rs.close();
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR CLOSE");
        }
        }
        }
    
    private void PaymentData(){
        
        ////////////////////////////////////////////////////////////////
        //Lay-By
        ////////////////////////////////////////////////////////////////
        if (jComboBoxStatus.getSelectedItem().toString().equals("Lay-Bye")) {
        //Amount to be paid off
        String stringTotal = "";
        //Old data
        String oldPaid = "";
        
        try {
            Connection connection = myConnection.getConnection();
            st = connection.createStatement();
            String s = "SELECT `total` FROM `Invoices` WHERE `CustomerName` = '"+jComboBoxCustomer.getSelectedItem().toString()+"'";
            rs = st.executeQuery(s);
            while(rs.next()){
                stringTotal = rs.getString("total");
            }
        } catch (SQLException e) {

        }
        
        try {
            Connection connection = myConnection.getConnection();
            st = connection.createStatement();
            String s = "SELECT `id`, `referenceNumber`, `name`, `paid`, `stillToPay`, `paymentDate` FROM `LayByeInfo` WHERE `name` = '"+jComboBoxCustomer.getSelectedItem().toString()+"'";
            rs = st.executeQuery(s);
            while(rs.next()){
                oldPaid = rs.getString("paid");
            }
        } catch (SQLException e) {

        }
        //Old data converted
        int Total = Integer.valueOf(stringTotal);
        int oldPaidInt = Integer.valueOf(oldPaid);
        //Calculate new data
        int newPaid = oldPaidInt + Integer.valueOf(jTextField1.getText());
        int newStillToPay = Total - newPaid;
        
        
            try{
                theQuery("INSERT INTO `LayByeInfo`(`name`, `referenceNumber`, `paid`, `stillToPay`, `paymentDate`) VALUES ('"
                        + ""+jComboBoxCustomer.getSelectedItem().toString()+"',"
                        + "'"+jLabelInvoiceNumber.getText()+"','"+jTextField1.getText()+"','"+newStillToPay+"',"
                        + "'"+((JTextField)jDateChooserPaymentDate.getDateEditor().getUiComponent()).getText()+"')");
                //          '"+((JTextField)jDateChooserInvoiceDate.getDateEditor().getUiComponent()).getText()+"'
            }
                catch(Exception ex){}
            
        ////////////////////////////////////////////////////////////////
        //Done
        ////////////////////////////////////////////////////////////////
        //Save QTY values
        ////////////////////////////////////////////////////////////////
        
        } else {
        String product = productNameVariable.getText();
        String message = "";
        
        ////////////////////////////////////////////////////////////////
        //Get selling Quantity
        ////////////////////////////////////////////////////////////////
        
            try {
                Connection connection = myConnection.getConnection();
                st = connection.createStatement();
                String s = "SELECT * FROM `Invoices` WHERE `CustomerName` = '"+customerName.getText()+"' AND `product` = '"+productNameVariable.getText()+"'";
                rs = st.executeQuery(s);
                while(rs.next()){
                    sellQTY = Integer.parseInt(rs.getString("qty"));
                }
            } catch (SQLException e) {

            }
        
        ////////////////////////////////////////////////////////////////
        //Save product QTY from products
        ////////////////////////////////////////////////////////////////
        
            try {
                Connection connection = myConnection.getConnection();
                st = connection.createStatement();
                String s = "SELECT * FROM `products` WHERE `productname` =  '"+product+"'";
                rs = st.executeQuery(s);
                while(rs.next()){
                    oldQTY = Integer.parseInt(rs.getString("instock"));
                    ID = Integer.parseInt(rs.getString("id"));
                }
            } catch (SQLException e) {

            }
            newQTY = oldQTY - sellQTY;
            
            try{
                theQuery("UPDATE `products` SET `instock`='"+newQTY+"' WHERE `id`='"+ID+"'");
                }
                catch(Exception ex){}
            
            message = newQTY +" "+ product + " left in stock";
            
            JOptionPane.showMessageDialog(null, message);
        
        ////////////////////////////////////////////////////////////////
        //Save Invoice Status
        ////////////////////////////////////////////////////////////////
            try{
                 theQuery("UPDATE `Invoices` SET `status`= '"+jComboBoxStatus.getSelectedItem().toString()+"' "
                         + "WHERE `ReferenceNumber` = '"+jLabelInvoiceNumber.getText()+"'");
             }
             catch(Exception ex){}
        }
        
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void updateJTabble(){
        try{
        con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        st = con.createStatement();
        String s = "SELECT * FROM `Invoices` WHERE `CustomerName` = '"+jComboBoxCustomer.getSelectedItem().toString()+"'";
        rs = st.executeQuery(s);
        jComboBoxInvoiceNumber.removeAllItems();
                    while(rs.next())
                    {
                        jComboBoxInvoiceNumber.addItem(rs.getString(2));
                        jComboBoxStatus.setSelectedItem(rs.getString(12));
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "ERROR");
                }finally{
                    try{
                        st.close();
                        rs.close();
                        con.close();
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "ERROR CLOSE");
          }
          }
        invoiceNumber();
        
        
        
        
        InvoiceQuery pq = new InvoiceQuery();
        ArrayList<invoice> clist = null;
        try {
            clist = pq.invoiceListSortByName();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] colNames = {"InvoiceNumber","CustomerName","ProductName","Status","QTY"};
        Object[][] rows = new Object[clist.size()][5];

        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getReferenceNumber();
            rows[i][1] = clist.get(i).getCustomerName();
            rows[i][2] = clist.get(i).getProduct();
            rows[i][3] = clist.get(i).getStatus();
            rows[i][4] = clist.get(i).getQty();
        }

        InvoiceModel imd = new InvoiceModel(rows, colNames);
        jTable1.setModel(imd);
    }
    
    Color searchColor = new Color(153,153,153);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelInvoiceNumber = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCustomer = new javax.swing.JComboBox<>();
        jTextFieldSearchCustomers = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jDateChooserPaymentDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBoxInvoiceNumber = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        customerName = new javax.swing.JLabel();
        productNameVariable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(46, 204, 113));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recieve Payments");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Invoice");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jLabelInvoiceNumber.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelInvoiceNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInvoiceNumber.setText("##########");
        jPanel2.add(jLabelInvoiceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Amount Recieved");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

        jComboBoxCustomer.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxCustomerPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBoxCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCustomerActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 309, -1));

        jTextFieldSearchCustomers.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchCustomers.setText("Search Customers");
        jTextFieldSearchCustomers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchCustomersFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchCustomersFocusLost(evt);
            }
        });
        jTextFieldSearchCustomers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchCustomersKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldSearchCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 150, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Payment date");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jDateChooserPaymentDate.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jDateChooserPaymentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 156, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Invoices listed to Customer");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "E-WALLET", "BLUE-WALLET", "EASY WALLET", "CASH", "BANK TRANSFER" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 160, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Payment Method");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 130, -1));

        jPanel2.add(jComboBoxInvoiceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 200, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Customer");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jButton9.setText("Print");
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        jButton7.setText("Clear");
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jButton10.setText("Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lay-Bye", "Done" }));
        jComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatusActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 170, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 560, 160));

        customerName.setForeground(new java.awt.Color(255, 255, 255));
        customerName.setText("#################");
        jPanel2.add(customerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        productNameVariable.setForeground(new java.awt.Color(255, 255, 255));
        productNameVariable.setText("#################");
        jPanel2.add(productNameVariable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();

        this.setLocation(X-mousepX, Y-mousepY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jComboBoxCustomerPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxCustomerPopupMenuWillBecomeInvisible
        updateJTabble();
    }//GEN-LAST:event_jComboBoxCustomerPopupMenuWillBecomeInvisible

    private void jComboBoxCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCustomerActionPerformed

    }//GEN-LAST:event_jComboBoxCustomerActionPerformed

    private void jTextFieldSearchCustomersFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchCustomersFocusGained
        if(jTextFieldSearchCustomers.getText().equals("Search Customers")){
            jTextFieldSearchCustomers.setText("");
        }
    }//GEN-LAST:event_jTextFieldSearchCustomersFocusGained

    private void jTextFieldSearchCustomersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchCustomersFocusLost
        if(jTextFieldSearchCustomers.getText().equals("")){
            jTextFieldSearchCustomers.setForeground(searchColor);//[153,153,153]
            jTextFieldSearchCustomers.setText("Search Customers");
        }else{
            jTextFieldSearchCustomers.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextFieldSearchCustomersFocusLost

    private void jTextFieldSearchCustomersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchCustomersKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                searchCustomers();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldSearchCustomersKeyPressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        PaymentData();
        updateJTabble();
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusActionPerformed
        if (jComboBoxStatus.getSelectedItem().toString() == "Lay-Bye"){
            jTextField1.setEnabled(true);
        } else {
            jTextField1.setEnabled(false);
        }
        
        // jTextField1
    }//GEN-LAST:event_jComboBoxStatusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int rowIndex = jTable1.getSelectedRow();
        customerName.setText(jTable1.getValueAt(rowIndex, 1).toString());
        productNameVariable.setText(jTable1.getValueAt(rowIndex, 2).toString());
        jLabelInvoiceNumber.setText(jTable1.getValueAt(rowIndex, 0).toString());
        jComboBoxInvoiceNumber.setSelectedItem(jTable1.getValueAt(rowIndex, 0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

   public void theQuery(String query){
      Connection con = null;
      Statement st = null;
      try{
          con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
          st = con.createStatement();
          st.executeUpdate(query);
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,ex.getMessage());
          System.out.println(ex.getMessage());
      }
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecievePayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecievePayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecievePayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecievePayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecievePayments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerName;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JComboBox<String> jComboBoxCustomer;
    public static javax.swing.JComboBox<String> jComboBoxInvoiceNumber;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateChooserPaymentDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelInvoiceNumber;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldSearchCustomers;
    private javax.swing.JLabel productNameVariable;
    // End of variables declaration//GEN-END:variables
}
