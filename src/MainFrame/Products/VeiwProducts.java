/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame.Products;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.table.JTableHeader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import MainFrame.Products.Search;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author berendfuchs
 */
public final class VeiwProducts extends javax.swing.JFrame {

    /**
     * Creates new form VeiwProducts
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int mousepX;
    int mousepY;
    
    String imagePth = null;
    public static int currentUserId;
    public VeiwProducts() throws SQLException {
        initComponents();
        populateJTable();
//        updateCatagoryCombo();
        
        jTable1.setShowGrid(true);
        jTable1.setGridColor(jPanel1.getBackground());
        jTable1.setSelectionBackground(jPanel1.getBackground());
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
        
        JTableHeader th = jTable1.getTableHeader();
        th.setForeground(Color.BLUE);
        
        th.setFont(new Font("Tahoma", Font.PLAIN, 14));
    }
    
    public ArrayList<Search> Listsearch(String ValToSearch){
        ArrayList<Search> searchList = new ArrayList<>();
        
        Statement st;
        ResultSet resultset;
        
        try{
            Connection connection = getConnection();
            st = (Statement) connection.createStatement();
            String searchQuery = "SELECT * FROM `products` WHERE CONCAT(`id`, `productname`, `category`, `instock`, `costperunit`, `sellingprice`, `LIQUIDATEATMINIMUM`) LIKE '%"+ValToSearch+"%'";
            resultset = st.executeQuery(searchQuery);
            
            Search search;
            
            while(resultset.next())
            {
                search = new Search(
                                resultset.getInt("id"),
                                resultset.getString("productname"),
                                resultset.getString("category"),
                                resultset.getInt("instock"),
                                resultset.getInt("costperunit"),
                                resultset.getInt("sellingprice"),
                                resultset.getInt("LIQUIDATEATMINIMUM")
                                );
                searchList.add(search);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return searchList;
    }
    
    // function to display data in jtable
    public void SearchData()
    {
        ArrayList<Search> search = Listsearch(jTextFieldSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Id","Productname","Category","Instock","Costperunit","Sellingprice","LIQUIDATEATMINIMUM"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < search.size(); i++)
        {
            row[0] = search.get(i).getId();
            row[1] = search.get(i).getProductname();
            row[2] = search.get(i).getCategory();
            row[3] = search.get(i).getInstock();
            row[4] = search.get(i).getCostperunit();
            row[5] = search.get(i).getSellingprice();
            row[6] = search.get(i).getLIQUIDATEATMINIMUM();
            model.addRow(row);
        }
        jTable1.setShowGrid(true);
        jTable1.setGridColor(jPanel1.getBackground());
        jTable1.setSelectionBackground(jPanel1.getBackground());
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
        
        JTableHeader th = jTable1.getTableHeader();
        th.setForeground(Color.BLUE);
        
        th.setFont(new Font("Tahoma", Font.PLAIN, 14));
        /*//////////////////////////////////////////////////////
        Total number of products
        *///////////////////////////////////////////////////////
        
        double totalProducts = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            totalProducts+=Double.parseDouble(jTable1.getValueAt(i, 3).toString());
        }
        totalProducts = totalProducts*100;
        totalProducts = (double)((int) totalProducts);
        totalProducts = totalProducts /100;
        jLabelTotalProducts.setText(""+totalProducts);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////

        /*//////////////////////////////////////////////////////
        Total Retail value of products
        *///////////////////////////////////////////////////////
        
        double instock = 0;
        double sellingprice = 0;
        double totalRetailValue = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            instock = Double.parseDouble(jTable1.getValueAt(i, 3).toString());
            sellingprice = Double.parseDouble(jTable1.getValueAt(i, 5).toString());
            totalRetailValue = (totalRetailValue)+(instock*sellingprice);
        }
        totalRetailValue = totalRetailValue*100;
        totalRetailValue = (double)((int) totalRetailValue);
        totalRetailValue = totalRetailValue /100;
        jLabelTotalRetailValue.setText(""+totalRetailValue);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////
        
        /*//////////////////////////////////////////////////////
        Total Cost of stock to comapny
        *///////////////////////////////////////////////////////
        
        double totalCostOfStock = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            instock = Double.parseDouble(jTable1.getValueAt(i, 3).toString());
            sellingprice = Double.parseDouble(jTable1.getValueAt(i, 4).toString());
            totalCostOfStock = (totalCostOfStock)+(instock*sellingprice);
        }
        totalCostOfStock = totalCostOfStock*100;
        totalCostOfStock = (double)((int) totalCostOfStock);
        totalCostOfStock = totalCostOfStock /100;
        jLabelCompanyCostOfStock.setText(""+totalCostOfStock);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////
        
        /*//////////////////////////////////////////////////////
        Total Company Profit @ Full Retail
        *///////////////////////////////////////////////////////
        
        double totalProfitFullRetail = totalRetailValue-totalCostOfStock;
        
        jLabelCompanyProfitFullRetail.setText(""+totalProfitFullRetail);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
//        private void updateCatagoryCombo(){
//        String sql = "select DISTINCT CATEGORY from PRODUCTS";
//        //String sql = "select * from PRODUCTS";
//        try {
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//            while(rs.next()){
//                jComboBoxCategory.addItem(rs.getString("CATEGORY"));
//            }
//        } catch (SQLException e) {
//            
//        }
//    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCostPerUnit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox();
        jButtonEditContact = new javax.swing.JButton();
        jTextFieldProductName = new javax.swing.JTextField();
        jTextFieldInStock = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonRemoveContact = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jButtonAddProduct = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabelTotalProducts = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSellingPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldLIQUIDATEATMINIMUM = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabelTotalRetailValue = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelCompanyCostOfStock = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelCompanyProfitFullRetail = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

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

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Products");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(535, 535, 535)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 584, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Category:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 90, 140, 22);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Product Name:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 50, 140, 22);

        jTextFieldCostPerUnit.setBackground(new java.awt.Color(159, 182, 204));
        jTextFieldCostPerUnit.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(jTextFieldCostPerUnit);
        jTextFieldCostPerUnit.setBounds(170, 170, 460, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("In Stock:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 130, 140, 22);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cost per unit:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 170, 140, 22);

        jComboBoxCategory.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sound", "kids", "PPE", "Fitness", "LIQUIDATE", "Electronics", "Cosmetics", "bikes", "HandKnittedItems" }));
        jComboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoryActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxCategory);
        jComboBoxCategory.setBounds(170, 90, 460, 30);

        jButtonEditContact.setBackground(new java.awt.Color(102, 102, 255));
        jButtonEditContact.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jButtonEditContact.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditContact.setText("Edit Existing");
        jButtonEditContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditContactActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEditContact);
        jButtonEditContact.setBounds(180, 310, 189, 38);

        jTextFieldProductName.setBackground(new java.awt.Color(159, 182, 204));
        jTextFieldProductName.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(jTextFieldProductName);
        jTextFieldProductName.setBounds(170, 50, 460, 30);

        jTextFieldInStock.setBackground(new java.awt.Color(159, 182, 204));
        jTextFieldInStock.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(jTextFieldInStock);
        jTextFieldInStock.setBounds(170, 130, 460, 30);

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
        jScrollPane3.setViewportView(jTable1);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 350, 1240, 360);

        jButtonRemoveContact.setBackground(new java.awt.Color(102, 102, 255));
        jButtonRemoveContact.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jButtonRemoveContact.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRemoveContact.setText("Remove");
        jButtonRemoveContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveContactActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRemoveContact);
        jButtonRemoveContact.setBounds(380, 310, 130, 38);

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ID:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 10, 140, 22);

        jTextFieldId.setBackground(new java.awt.Color(159, 182, 204));
        jTextFieldId.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(jTextFieldId);
        jTextFieldId.setBounds(170, 10, 460, 30);

        jButtonAddProduct.setBackground(new java.awt.Color(102, 102, 255));
        jButtonAddProduct.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jButtonAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddProduct.setText("Add NEW");
        jButtonAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProductActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAddProduct);
        jButtonAddProduct.setBounds(20, 310, 150, 38);

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total Number of Products In Stock:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(640, 20, 250, 22);

        jLabelTotalProducts.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelTotalProducts.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalProducts.setText("########");
        jPanel2.add(jLabelTotalProducts);
        jLabelTotalProducts.setBounds(640, 40, 120, 22);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Selling Price:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 210, 140, 22);

        jTextFieldSellingPrice.setBackground(new java.awt.Color(159, 182, 204));
        jTextFieldSellingPrice.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(jTextFieldSellingPrice);
        jTextFieldSellingPrice.setBounds(170, 210, 460, 30);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("AT MINIMUM");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 270, 130, 22);

        jTextFieldLIQUIDATEATMINIMUM.setBackground(new java.awt.Color(159, 182, 204));
        jTextFieldLIQUIDATEATMINIMUM.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(jTextFieldLIQUIDATEATMINIMUM);
        jTextFieldLIQUIDATEATMINIMUM.setBounds(170, 250, 460, 30);

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("LIQUIDATE");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 250, 100, 22);

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("LIQUIDATE");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(10, 250, 100, 22);

        jTextFieldSearch.setForeground(new java.awt.Color(158, 158, 158));
        jTextFieldSearch.setText("Search");
        jTextFieldSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchFocusLost(evt);
            }
        });
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldSearch);
        jTextFieldSearch.setBounds(1020, 320, 190, 26);

        jLabelTotalRetailValue.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelTotalRetailValue.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalRetailValue.setText("########");
        jPanel2.add(jLabelTotalRetailValue);
        jLabelTotalRetailValue.setBounds(640, 110, 120, 22);

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Retail Value of stock:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(640, 90, 250, 17);

        jLabelCompanyCostOfStock.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelCompanyCostOfStock.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompanyCostOfStock.setText("########");
        jPanel2.add(jLabelCompanyCostOfStock);
        jLabelCompanyCostOfStock.setBounds(640, 180, 120, 22);

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Company Cost of stock:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(640, 160, 250, 17);

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Company Profit @ Full Retail:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(640, 220, 250, 17);

        jLabelCompanyProfitFullRetail.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelCompanyProfitFullRetail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompanyProfitFullRetail.setText("########");
        jPanel2.add(jLabelCompanyProfitFullRetail);
        jLabelCompanyProfitFullRetail.setBounds(640, 240, 120, 22);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(890, 10, 10, 290);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void populateJTable() throws SQLException {
        /*//////////////////////////////////////////////////////
        Populate JTable
        *///////////////////////////////////////////////////////
        
        ProductQuery pq = new ProductQuery();
        ArrayList<product> clist = pq.productList();
        
        String[] colNames = {"Id","Product Name","Category","In Stock","Cost per unit","Selling Price","LIQUIDATE AT MINIMUM"};
        Object[][] rows = new Object[clist.size()][7];
        
        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getCid();
            rows[i][1] = clist.get(i).getProductname();
            rows[i][2] = clist.get(i).getCategory();
            rows[i][3] = clist.get(i).getInstock();
            rows[i][4] = clist.get(i).getCostperunit();
            rows[i][5] = clist.get(i).getSellingprice();
            rows[i][6] = clist.get(i).getLIQUIDATEATMINIMUM();
            
            
        }
        
        MyModel mmd = new MyModel(rows, colNames);
        jTable1.setModel(mmd);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////
        
        /*//////////////////////////////////////////////////////
        Total number of products
        *///////////////////////////////////////////////////////
        
        double totalProducts = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            totalProducts+=Double.parseDouble(jTable1.getValueAt(i, 3).toString());
        }
        totalProducts = totalProducts*100;
        totalProducts = (double)((int) totalProducts);
        totalProducts = totalProducts /100;
        jLabelTotalProducts.setText(""+totalProducts);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////
        
        /*//////////////////////////////////////////////////////
        Total Retail value of products
        *///////////////////////////////////////////////////////
        
        double instock = 0;
        double sellingprice = 0;
        double totalRetailValue = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            instock = Double.parseDouble(jTable1.getValueAt(i, 3).toString());
            sellingprice = Double.parseDouble(jTable1.getValueAt(i, 5).toString());
            totalRetailValue = (totalRetailValue)+(instock*sellingprice);
        }
        totalRetailValue = totalRetailValue*100;
        totalRetailValue = (double)((int) totalRetailValue);
        totalRetailValue = totalRetailValue /100;
        jLabelTotalRetailValue.setText(""+totalRetailValue);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////
        
        /*//////////////////////////////////////////////////////
        Total Cost of stock to comapny
        *///////////////////////////////////////////////////////
        
        double costOfStock = 0;
        double totalCostOfStock = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            instock = Double.parseDouble(jTable1.getValueAt(i, 3).toString());
            costOfStock = Double.parseDouble(jTable1.getValueAt(i, 4).toString());
            totalCostOfStock = (totalCostOfStock)+(instock*costOfStock);
        }
        totalCostOfStock = totalCostOfStock*100;
        totalCostOfStock = (double)((int) totalCostOfStock);
        totalCostOfStock = totalCostOfStock /100;
        jLabelCompanyCostOfStock.setText(""+totalCostOfStock);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////
        
        /*//////////////////////////////////////////////////////
        Total Company Profit @ Full Retail
        *///////////////////////////////////////////////////////
        
        double totalProfitFullRetail = totalRetailValue-totalCostOfStock;
        
        jLabelCompanyProfitFullRetail.setText(""+totalProfitFullRetail);
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////

        /*//////////////////////////////////////////////////////
        SET COLUMNS WIDTH AND HEIGHT
        *///////////////////////////////////////////////////////
        
        /*//////////////////////////////////////////////////////
        End
        *///////////////////////////////////////////////////////
    }
    
        Color searchColor = new Color(153,153,153);
    
        
            public Connection getConnection(){
                Connection con = null;
                
                try{
                    con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase", "Berend", "kidcoltv6");
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                } return con;
            }
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButtonEditContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditContactActionPerformed
         try{
           theQuery("update products set productname = '"+jTextFieldProductName.getText()+"',category = '"+jComboBoxCategory.getSelectedItem().toString()+"',instock = "+jTextFieldInStock.getText()+",costperunit = "+jTextFieldCostPerUnit.getText()+",sellingprice = "+jTextFieldSellingPrice.getText()+",LIQUIDATEATMINIMUM = "+jTextFieldLIQUIDATEATMINIMUM.getText()+" where id = "+jTextFieldId.getText());
         }
         catch(Exception ex){}
         try {
            populateJTable();
        } catch (SQLException ex) {
            Logger.getLogger(VeiwProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
    }//GEN-LAST:event_jButtonEditContactActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // display selected JTable row data

        // get selected row index
        int rowIndex = jTable1.getSelectedRow();
        jTextFieldId.setText(jTable1.getValueAt(rowIndex, 0).toString());
        jTextFieldProductName.setText(jTable1.getValueAt(rowIndex, 1).toString());
        jComboBoxCategory.setSelectedItem(jTable1.getValueAt(rowIndex, 2));
        jTextFieldInStock.setText(jTable1.getValueAt(rowIndex, 3).toString());
        jTextFieldCostPerUnit.setText(jTable1.getValueAt(rowIndex, 4).toString());
        jTextFieldSellingPrice.setText(jTable1.getValueAt(rowIndex, 5).toString());
        jTextFieldLIQUIDATEATMINIMUM.setText(jTable1.getValueAt(rowIndex, 6).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonRemoveContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveContactActionPerformed
         try{
             theQuery("delete from products where id = "+jTextFieldId.getText());
         }
         catch(Exception ex){}
         
         try {
            populateJTable();
        } catch (SQLException ex) {
            Logger.getLogger(VeiwProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
    }//GEN-LAST:event_jButtonRemoveContactActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();
        
        this.setLocation(X-mousepX, Y-mousepY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButtonAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProductActionPerformed
         try{
             theQuery("insert into products (productname,category,instock,costperunit,sellingprice,LIQUIDATEATMINIMUM) values('"+jTextFieldProductName.getText()+"',"
                     + "'"+jComboBoxCategory.getSelectedItem().toString()+"','"+jTextFieldInStock.getText()+"','"+jTextFieldCostPerUnit.getText()+"',"
                     + "'"+jTextFieldSellingPrice.getText()+"','"+jTextFieldLIQUIDATEATMINIMUM.getText()+"')");
         }
         catch(Exception ex){}
         
        try {
            populateJTable();
        } catch (SQLException ex) {
            Logger.getLogger(VeiwProducts.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
    }//GEN-LAST:event_jButtonAddProductActionPerformed

    private void jComboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoryActionPerformed
          String catag = (String) jComboBoxCategory.getSelectedItem();
    }//GEN-LAST:event_jComboBoxCategoryActionPerformed

    private void jTextFieldSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusGained
        if(jTextFieldSearch.getText().equals("Search")){
            jTextFieldSearch.setText("");
        }
    }//GEN-LAST:event_jTextFieldSearchFocusGained

    private void jTextFieldSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusLost
        if(jTextFieldSearch.getText().equals("")){
            jTextFieldSearch.setForeground(searchColor);//[153,153,153]
            jTextFieldSearch.setText("Search");
        }else{
        jTextFieldSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextFieldSearchFocusLost

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            SearchData();
        }
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    /**
     * @param query
     */
    
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
            java.util.logging.Logger.getLogger(VeiwProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiwProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiwProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiwProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new VeiwProducts().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(VeiwProducts.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonEditContact;
    private javax.swing.JButton jButtonRemoveContact;
    private javax.swing.JComboBox<String> jComboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCompanyCostOfStock;
    private javax.swing.JLabel jLabelCompanyProfitFullRetail;
    private javax.swing.JLabel jLabelTotalProducts;
    private javax.swing.JLabel jLabelTotalRetailValue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCostPerUnit;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldInStock;
    private javax.swing.JTextField jTextFieldLIQUIDATEATMINIMUM;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldSellingPrice;
    // End of variables declaration//GEN-END:variables
}
