/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame.Create.Invoice;

import DatabaseConnection.myConnection;
import static DatabaseConnection.myConnection.getConnection;
import MainFrame.Create.customer.newCustomer;
import MainFrame.Products.Search;
import MainFrame.Products.Search1;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author berendfuchs
 */
public class Invoice extends javax.swing.JFrame {
    
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
    public Invoice() throws ParseException {
        initComponents();
        updateCustomerCombo();
        updateProductCombo();
        invoiceNumber();
        jDateChooserInvoiceDate.setDate(date);
        jDateChooserDueDate.setDate(dueDate);
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
    
    public ArrayList<Search1> ListsearchProduct(String ValToSearch){
        ArrayList<Search1> searchList1 = new ArrayList<>();
        
        Statement st;
        ResultSet resultset;
        
        try{
            Connection connection = getConnection();
            st = (Statement) connection.createStatement();
            String searchQuery = "SELECT * FROM `products` WHERE `productname` LIKE '%"+ValToSearch+"%'";
            resultset = st.executeQuery(searchQuery);
            
            Search1 search1;
            
            while(resultset.next())
            {
                search1 = new Search1(
                                resultset.getString("productname")
                                );
                searchList1.add(search1);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return searchList1;
    }
    
    public void searchProducts() throws SQLException
    {
        ArrayList<Search1> search1 = ListsearchProduct(jTextFieldSearchProduct.getText());
        String product;
        jComboBoxProductName.removeAllItems();
        for(int i = 0; i < search1.size(); i++)
        {
            product = search1.get(i).getProductname();
            jComboBoxProductName.addItem(product);
        }
    }
    
    private void invoiceNumber(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
            st = con.createStatement();
            String s = "SELECT MAX(ReferenceNumber)from Invoices";
            rs = st.executeQuery(s);
              while(rs.next())
              {
                String HighestInvoicenumberString = rs.getString(1);
                int HighestInvoicenumber = Integer.parseInt(HighestInvoicenumberString);
                
                int newInvoiceNumber = HighestInvoicenumber + 1;
                String newInvoiceNumberString = String.valueOf(newInvoiceNumber);
                jLabelInvoiceNumber.setText(newInvoiceNumberString);
              }
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "ERROR");
          }
    }
    
    private void layByePaymentData(){
        if (jComboBoxStatus.getSelectedItem().toString().equals("Lay-Bye")) {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
            String totalFromJTable = jTable1.getValueAt(i, 3).toString();
            try{
                theQuery("INSERT INTO `LayByeInfo`(`name`, `referenceNumber`, `paid`, `stillToPay`, `paymentDate`) VALUES ('"+jComboBoxCustomer.getSelectedItem().toString()+"',"
                        + "'"+jLabelInvoiceNumber.getText()+"',0,'"+totalFromJTable+"',"
                                + "'"+((JTextField)jDateChooserInvoiceDate.getDateEditor().getUiComponent()).getText()+"')");
                JOptionPane.showMessageDialog(null, "Note if you have received the first payment make out a received payment");
            }
                catch(Exception ex){}
            }
    }
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
    private void updateProductCombo(){
        /*
        //////////////////////////////////////////////////////////
        CONNECTS COMBOBOX TO SQL
        //////////////////////////////////////////////////////////
        */
      try{
      con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
      st = con.createStatement();
      String s = "select * from products";
      rs = st.executeQuery(s);
        while(rs.next())
        {
            jComboBoxProductName.addItem(rs.getString(2));
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
    
    private void saveQTYvalues(){
        String product = "";
        int sellQTY = 0;
        int oldQTY = 0;
        int newQTY = 0;
        int ID = 0;
        
        String message = "";
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            product = jTable1.getValueAt(i, 0).toString();
            sellQTY = Integer.parseInt(jTable1.getValueAt(i, 1).toString());
            
            try {
                Connection connection = myConnection.getConnection();
                st = connection.createStatement();
                String s = "SELECT * FROM `products` WHERE `productname` LIKE  '%"+product+"%'";
                rs = st.executeQuery(s);
                while(rs.next()){
                    oldQTY = Integer.parseInt(rs.getString("instock"));
                    ID = Integer.parseInt(rs.getString("id"));
                }
            } catch (SQLException e) {

            }
            if (jComboBoxStatus.getSelectedItem().toString().equals("Order")) {
                newQTY = oldQTY;
            } else {
                newQTY = oldQTY - sellQTY;
            }
            
            try{
                theQuery("UPDATE `products` SET `instock`='"+newQTY+"' WHERE `id`="+ID);
                }
                catch(Exception ex){}
            
            message = newQTY +" "+ product + " left in stock";
            
            JOptionPane.showMessageDialog(null, message);
        }
    }
    
    private void saveInvoiceData(){
        String BillingAddress = "";
        String ShippingAddress = "";
        /*
        Get needed data for customer from database
        */ 
        try {
            Connection connection = myConnection.getConnection();
            st = connection.createStatement();
            String s = "SELECT * FROM `Invoices` WHERE `CustomerName` LIKE  '%"+CustomerName+"%'";
            rs = st.executeQuery(s);
            while(rs.next()){
                BillingAddress = rs.getString("BillingAddress");
                ShippingAddress = rs.getString("ShippingAddress");
            }
        } catch (SQLException e) {

        }
        
        /*
        Insert Invoice data into database
        */
        
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            //z+=Double.parseDouble(jTable1.getValueAt(i, 3).toString());
            String productFromJTable = jTable1.getValueAt(i, 0).toString();
            String qtyFromJTable = jTable1.getValueAt(i, 1).toString();
            String amountFromJTable = jTable1.getValueAt(i, 2).toString();
            String totalFromJTable = jTable1.getValueAt(i, 3).toString();
            try{
                 theQuery("INSERT INTO `Invoices`(`ReferenceNumber`, `CustomerName`, `BillingAddress`, `ShippingAddress`, `DueDate`, `DateCreated`,"
                         + " `product`, `qty`, `amount`, `total`, `status`) VALUES ('"+jLabelInvoiceNumber.getText()+"',"
                         + "'"+jComboBoxCustomer.getSelectedItem().toString()+"','"+BillingAddress+"','"+ShippingAddress+"',"
                         + "'"+((JTextField)jDateChooserDueDate.getDateEditor().getUiComponent()).getText()+"','"+((JTextField)jDateChooserInvoiceDate.getDateEditor().getUiComponent()).getText()+"',"
                         + "'"+productFromJTable+"','"+qtyFromJTable+"','"+amountFromJTable+"','"+totalFromJTable+"','"+jComboBoxStatus.getSelectedItem().toString()+"')");
             }
             catch(Exception ex){}
        }
    }
    
    Object[] row = new Object[5];
    
    Color searchColor = new Color(153,153,153);
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jDateChooserInvoiceDate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jDateChooserDueDate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jButtonADD = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxProductName = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jButtonRemove = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jLabelTown = new javax.swing.JLabel();
        jLabelShippingAddress = new javax.swing.JLabel();
        jLabelInvoiceNumber = new javax.swing.JLabel();
        jComboBoxCustomer = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextFieldQTY = new javax.swing.JTextField();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jTextFieldSearchCustomers = new javax.swing.JTextField();
        jTextFieldSearchProduct = new javax.swing.JTextField();

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Invoice");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Invoice");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Customer");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, -1, -1));

        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("Email");
        jPanel2.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 148, -1, -1));

        jDateChooserInvoiceDate.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jDateChooserInvoiceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 156, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Invoice date");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jDateChooserDueDate.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jDateChooserDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 156, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Due date");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT", "QTY", "AMOUNT", "TOTAL"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
    });
    jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jTable1KeyPressed(evt);
        }
    });
    jScrollPane1.setViewportView(jTable1);

    jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 286, 940, 220));

    jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 255, 255));
    jLabel11.setText("Total");
    jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 512, -1, -1));

    jButtonADD.setText("ADD");
    jButtonADD.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonADDActionPerformed(evt);
        }
    });
    jPanel2.add(jButtonADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

    jLabel15.setForeground(new java.awt.Color(255, 255, 255));
    jLabel15.setText("AMOUNT");
    jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, -1));
    jPanel2.add(jTextFieldAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 223, -1));

    jLabel16.setForeground(new java.awt.Color(255, 255, 255));
    jLabel16.setText("QTY");
    jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

    jComboBoxProductName.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            jComboBoxProductNameFocusLost(evt);
        }
    });
    jComboBoxProductName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxProductNameActionPerformed(evt);
        }
    });
    jPanel2.add(jComboBoxProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 390, -1));

    jLabel18.setForeground(new java.awt.Color(255, 255, 255));
    jLabel18.setText("PRODUCT");
    jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

    jButtonRemove.setText("Remove");
    jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRemoveActionPerformed(evt);
        }
    });
    jPanel2.add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

    jButtonUpdate.setText("Update");
    jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonUpdateActionPerformed(evt);
        }
    });
    jPanel2.add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, -1, -1));

    jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(255, 255, 255));
    jLabel14.setText("N$ 0.00");
    jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 512, -1, -1));

    jButtonSave.setText("Save");
    jButtonSave.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonSaveActionPerformed(evt);
        }
    });
    jPanel2.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

    jButtonClear.setText("Email");
    jPanel2.add(jButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, -1, -1));

    jButtonPrint.setText("Print");
    jPanel2.add(jButtonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, -1, -1));

    jLabelTown.setForeground(new java.awt.Color(255, 255, 255));
    jLabelTown.setText("Town");
    jPanel2.add(jLabelTown, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 170, -1, -1));

    jLabelShippingAddress.setForeground(new java.awt.Color(255, 255, 255));
    jLabelShippingAddress.setText("ShippingAddress");
    jPanel2.add(jLabelShippingAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 192, -1, -1));

    jLabelInvoiceNumber.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
    jLabelInvoiceNumber.setForeground(new java.awt.Color(255, 255, 255));
    jLabelInvoiceNumber.setText("##########");
    jPanel2.add(jLabelInvoiceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 6, -1, -1));

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
    jPanel2.add(jComboBoxCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, 309, -1));

    jButton1.setText("Add New Customer");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 48, -1, -1));

    jTextFieldQTY.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            jTextFieldQTYFocusLost(evt);
        }
    });
    jPanel2.add(jTextFieldQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 223, -1));

    jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order", "Active", "Lay-Bye", "Done" }));
    jPanel2.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 170, -1));

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
    jPanel2.add(jTextFieldSearchCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, -1));

    jTextFieldSearchProduct.setForeground(new java.awt.Color(153, 153, 153));
    jTextFieldSearchProduct.setText("Search Product");
    jTextFieldSearchProduct.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            jTextFieldSearchProductFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            jTextFieldSearchProductFocusLost(evt);
        }
    });
    jTextFieldSearchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jTextFieldSearchProductKeyPressed(evt);
        }
    });
    jPanel2.add(jTextFieldSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 130, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();

        this.setLocation(X-mousepX, Y-mousepY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADDActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        /*
        NEW Variables
        */
        String productName = jComboBoxProductName.getSelectedItem().toString();
        int sellQTY = Integer.parseInt(jTextFieldQTY.getText());
        double amount = Double.parseDouble(jTextFieldAmount.getText());
        double total = sellQTY * amount;
        
        /*
        OLD Variables
        */
        int oldQTY = 0;
        int ID = 0;
        try {
                Connection connection = myConnection.getConnection();
                st = connection.createStatement();
                String s = "SELECT * FROM `products` WHERE `productname` LIKE  '%"+productName+"%'";
                rs = st.executeQuery(s);
                while(rs.next()){
                    oldQTY = Integer.parseInt(rs.getString("instock"));
                    ID = Integer.parseInt(rs.getString("id"));
                }
            } catch (SQLException e) {

            }
        
        /*
        Calculate new QTY
        */
        int newQTY = oldQTY - sellQTY;
        
        /*
        IF FUNCTION
        */
        String msg = "You only have "+oldQTY+" "+productName+" in stock!!!";
        if (newQTY<=-1) {
            JOptionPane.showMessageDialog(null, msg);
        }else{

        row[0] = productName;
        row[1] = sellQTY;
        row[2] = amount;
        row[3] = total;

        model.addRow(row);

        double z = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            z+=Double.parseDouble(jTable1.getValueAt(i, 3).toString());
        }
        z = z*100;
        z = (double)((int) z);
        z = z /100;
        jLabel14.setText("N$ "+z);
        //iTax = String.format("N$ %.2f", itemcost[25] / 100);
        }

    }//GEN-LAST:event_jButtonADDActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int i = jTable1.getSelectedRow();
        if (i >= 0) {
            model.removeRow(i);
        } else {
            JOptionPane.showMessageDialog(rootPane, model);
        }
        double z = 0;
        for (int y = 0; y < jTable1.getRowCount(); y++) {
            z+=Double.parseDouble(jTable1.getValueAt(y, 3).toString());
        }
        z = z*100;
        z = (double)((int) z);
        z = z /100;
        jLabel14.setText("N$ "+z);
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int i = jTable1.getSelectedRow();

        if (i>=0) {
            model.setValueAt(jComboBoxProductName.getSelectedItem().toString(), i, 0);
            model.setValueAt(jTextFieldQTY.getText(), i, 1);
            model.setValueAt(jTextFieldAmount.getText(), i, 2);
            model.setValueAt(Double.parseDouble(jTextFieldQTY.getText()) * Double.parseDouble(jTextFieldAmount.getText()), i, 3);
        } else {
            JOptionPane.showMessageDialog(rootPane, model);
        }
        double z = 0;
        for (int y = 0; y < jTable1.getRowCount(); y++) {
            z+=Double.parseDouble(jTable1.getValueAt(y, 3).toString());
        }
        z = z*100;
        z = (double)((int) z);
        z = z /100;
        jLabel14.setText("N$ "+z);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jComboBoxProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductNameActionPerformed
        productName = jComboBoxProductName.getItemAt(1);
        
        jTextFieldQTY.setText("0");
    }//GEN-LAST:event_jComboBoxProductNameActionPerformed

    private void jComboBoxCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCustomerActionPerformed
        
    }//GEN-LAST:event_jComboBoxCustomerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newCustomer s = new newCustomer();
	s.setVisible(true);
        s.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        saveQTYvalues();
        saveInvoiceData();
        layByePaymentData();
        this.dispose();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // display selected JTable row data

        // get selected row index
        int rowIndex = jTable1.getSelectedRow();
        jComboBoxProductName.setSelectedItem(jTable1.getValueAt(rowIndex, 0));
        jTextFieldQTY.setText((String) jTable1.getValueAt(rowIndex, 1));
        jTextFieldAmount.setText(jTable1.getValueAt(rowIndex, 2).toString());
        
        boolean a = jTable1.isEditing();
        
        if(a==true){
            JOptionPane.showMessageDialog(null, "Please update the selected row from the textfields");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextFieldQTYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQTYFocusLost
        

        try {
            Connection connection = myConnection.getConnection();
            st = connection.createStatement();
            String s = "SELECT * FROM `products` WHERE `productname` LIKE  '%"+productName+"%'";
            rs = st.executeQuery(s);
            while(rs.next()){
                String amount = rs.getString("sellingprice");
                jTextFieldAmount.setText(amount);
            }
        } catch (SQLException e) {

        }
    }//GEN-LAST:event_jTextFieldQTYFocusLost

    private void jComboBoxProductNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxProductNameFocusLost
        productName = jComboBoxProductName.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBoxProductNameFocusLost

    private void jComboBoxCustomerPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxCustomerPopupMenuWillBecomeInvisible
String tmp = (String)jComboBoxCustomer.getSelectedItem();

        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "select * from Customers where Name=?";

        try {
            pst = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst.setString(1, tmp);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if(rs.next()){
                String email = rs.getString("Email");
                jLabelEmail.setText(email);
                
                String city = rs.getString("BillingCity");
                jLabelTown.setText(city);
                
                String ShippingAddress ="<html>" + rs.getString("ShippingLine1") + " " + rs.getString("ShippingLine2") + "<br>" + rs.getString("ShippingLine3") + "<br>" +
                        rs.getString("ShippingCity") + "<br>" + rs.getString("ShippingState") + "<br>" + rs.getString("ShippingPoBox") + "</html>";
                jLabelShippingAddress.setText(ShippingAddress);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxCustomerPopupMenuWillBecomeInvisible

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
        
        String tmp = (String)jComboBoxCustomer.getSelectedItem();

        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "select * from Customers where Name=?";

        try {
            pst = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst.setString(1, tmp);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if(rs.next()){
                String email = rs.getString("Email");
                jLabelEmail.setText(email);
                
                String city = rs.getString("BillingCity");
                jLabelTown.setText(city);
                
                String ShippingAddress ="<html>" + rs.getString("ShippingLine1") + " " + rs.getString("ShippingLine2") + "<br>" + rs.getString("ShippingLine3") + "<br>" +
                        rs.getString("ShippingCity") + "<br>" + rs.getString("ShippingState") + "<br>" + rs.getString("ShippingPoBox") + "</html>";
                jLabelShippingAddress.setText(ShippingAddress);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchCustomersKeyPressed

    private void jTextFieldSearchProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductFocusGained
        if(jTextFieldSearchProduct.getText().equals("Search Product")){
            jTextFieldSearchProduct.setText("");
        }
    }//GEN-LAST:event_jTextFieldSearchProductFocusGained

    private void jTextFieldSearchProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductFocusLost
        if(jTextFieldSearchProduct.getText().equals("")){
            jTextFieldSearchProduct.setForeground(searchColor);//[153,153,153]
            jTextFieldSearchProduct.setText("Search Product");
        }else{
        jTextFieldSearchProduct.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextFieldSearchProductFocusLost

    private void jTextFieldSearchProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                searchProducts();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldSearchProductKeyPressed

    
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
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Invoice().setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxCustomer;
    private javax.swing.JComboBox<String> jComboBoxProductName;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateChooserDueDate;
    private com.toedter.calendar.JDateChooser jDateChooserInvoiceDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelInvoiceNumber;
    private javax.swing.JLabel jLabelShippingAddress;
    private javax.swing.JLabel jLabelTown;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldQTY;
    private javax.swing.JTextField jTextFieldSearchCustomers;
    private javax.swing.JTextField jTextFieldSearchProduct;
    // End of variables declaration//GEN-END:variables
}
