package MainFrame;

import DatabaseConnection.myConnection;
import static DatabaseConnection.myConnection.getConnection;
import Login.loginForm;
import java.awt.CardLayout;
import javax.swing.JFrame;
import MainFrame.Products.VeiwProducts;
import MainFrame.Create.Create;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author berendfuchs
 */
public class MainFrame extends javax.swing.JFrame {
    
    int mousepX;
    int mousepY;
        int Orders = 0;
        int Active = 0;
        int Done = 0;
        int LayByestilltopay = 0;
        int LayByepaid = 0;
    String name;
    
    String imagePth = null;
    public static int currentUserId;

    
    public MainFrame() throws SQLException {
        initComponents();
        caculateDashBoard();
        checkOverdueTasks();
        populateJTable5();
        populateJTable6();
        populatejTableProfit();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelUserPic = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnBanking = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnExpenses = new javax.swing.JButton();
        btnInvoices = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnTaxes = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        btnAccounting = new javax.swing.JButton();
        btnAccounting1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnScraping = new javax.swing.JButton();
        cardframe = new javax.swing.JPanel();
        pane_Dashboard = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelOrders = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelActive = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabelMoneyToBeMade = new javax.swing.JLabel();
        jLabelMoneyAlreadyIn = new javax.swing.JLabel();
        jLabelLayBye = new javax.swing.JLabel();
        jLabelDone = new javax.swing.JLabel();
        jLabelLayBye1 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel63 = new javax.swing.JLabel();
        jLabeltotalProfit = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableProfit = new javax.swing.JTable();
        jLabel64 = new javax.swing.JLabel();
        pane_Banking = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jLabelInOrOut = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jLabelBalance = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabelValue = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        pane_Customers = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButtonSet = new javax.swing.JButton();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        pane_Expenses = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pane_Invoices = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInvoices = new javax.swing.JTable();
        jButtonSetInvoiceStatus = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        pane_Reports = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pane_Taxes = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pane_accounting = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pane_Database = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pane_Scraping = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(46, 204, 113));
        setForeground(java.awt.Color.black);
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
        jLabel2.setText("MainFrame");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabelUserPic.setBackground(new java.awt.Color(0, 51, 255));
        jLabelUserPic.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelUserPic.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelUserPic.setOpaque(true);

        jLabelUsername.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelUserPic, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(518, 518, 518)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelUserPic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2))
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabelUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ButtonPanel.setBackground(new java.awt.Color(44, 62, 80));
        ButtonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 255), java.awt.Color.white, java.awt.Color.lightGray));

        btnDashboard.setBackground(new java.awt.Color(102, 102, 255));
        btnDashboard.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnBanking.setBackground(new java.awt.Color(102, 102, 255));
        btnBanking.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnBanking.setForeground(new java.awt.Color(255, 255, 255));
        btnBanking.setText("Banking");
        btnBanking.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBankingActionPerformed(evt);
            }
        });

        btnCustomers.setBackground(new java.awt.Color(102, 102, 255));
        btnCustomers.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnCustomers.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomers.setText("Customers");
        btnCustomers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });

        btnExpenses.setBackground(new java.awt.Color(102, 102, 255));
        btnExpenses.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnExpenses.setForeground(new java.awt.Color(255, 255, 255));
        btnExpenses.setText("Expenses");
        btnExpenses.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpensesActionPerformed(evt);
            }
        });

        btnInvoices.setBackground(new java.awt.Color(102, 102, 255));
        btnInvoices.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnInvoices.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoices.setText("Invoices");
        btnInvoices.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoicesActionPerformed(evt);
            }
        });

        btnReports.setBackground(new java.awt.Color(102, 102, 255));
        btnReports.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnReports.setForeground(new java.awt.Color(255, 255, 255));
        btnReports.setText("Reports");
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        btnTaxes.setBackground(new java.awt.Color(102, 102, 255));
        btnTaxes.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnTaxes.setForeground(new java.awt.Color(255, 255, 255));
        btnTaxes.setText("Taxes");
        btnTaxes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTaxes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaxesActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(255, 51, 51));
        btnexit.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 255, 255));
        btnexit.setText("Exit");
        btnexit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btnAccounting.setBackground(new java.awt.Color(102, 102, 255));
        btnAccounting.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnAccounting.setForeground(new java.awt.Color(255, 255, 255));
        btnAccounting.setText("Accounting");
        btnAccounting.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAccounting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountingActionPerformed(evt);
            }
        });

        btnAccounting1.setBackground(new java.awt.Color(102, 102, 255));
        btnAccounting1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnAccounting1.setForeground(new java.awt.Color(255, 255, 255));
        btnAccounting1.setText("DataBase");
        btnAccounting1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAccounting1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccounting1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(46, 204, 113));
        jButton5.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jButton5.setText("Create");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnScraping.setBackground(new java.awt.Color(102, 102, 255));
        btnScraping.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnScraping.setForeground(new java.awt.Color(255, 255, 255));
        btnScraping.setText("Scraping");
        btnScraping.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnScraping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScrapingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonPanelLayout = new javax.swing.GroupLayout(ButtonPanel);
        ButtonPanel.setLayout(ButtonPanelLayout);
        ButtonPanelLayout.setHorizontalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInvoices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaxes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccounting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccounting1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnScraping, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ButtonPanelLayout.setVerticalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanking, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaxes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnAccounting, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccounting1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnScraping, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardframe.setLayout(new java.awt.CardLayout());

        pane_Dashboard.setBackground(new java.awt.Color(44, 62, 80));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dashboard");

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("PRODUCTS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("The month of:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Orders:");

        jLabelOrders.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOrders.setText("######");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Active:");

        jLabelActive.setForeground(new java.awt.Color(255, 255, 255));
        jLabelActive.setText("######");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Done:");

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Lay-Bye paid:");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Money Already in = Active + Done + LayByepaid:");

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Money to be made = Orders + LayByestilltopay:");

        jLabelMoneyToBeMade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMoneyToBeMade.setText("#######################");

        jLabelMoneyAlreadyIn.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMoneyAlreadyIn.setText("#######################");

        jLabelLayBye.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLayBye.setText("######");

        jLabelDone.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDone.setText("######");

        jLabelLayBye1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLayBye1.setText("######");

        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Lay-Bye still to pay:");

        jDateChooserFrom.setDateFormatString("yyyy-MM-dd");

        jDateChooserTo.setDateFormatString("yyyy-MM-dd");

        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Profit:");

        jLabeltotalProfit.setForeground(new java.awt.Color(255, 255, 255));
        jLabeltotalProfit.setText("######");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel49))
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelLayBye1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelLayBye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelDone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelOrders))
                                .addGap(150, 150, 150)
                                .addComponent(jLabeltotalProfit)))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel63)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28)
                                .addComponent(jLabel29)
                                .addComponent(jLabelMoneyAlreadyIn)
                                .addComponent(jLabelMoneyToBeMade)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelOrders)
                            .addComponent(jLabel63)
                            .addComponent(jLabeltotalProfit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDone)
                            .addComponent(jLabel22))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLayBye)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLayBye1)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMoneyAlreadyIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMoneyToBeMade)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(44, 62, 80));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("work to be done");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        jLabel31.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Due and Overdue Tasks");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable6);

        jLabel32.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Upcoming Tasks");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("ID");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Started", "Complete", "Overdue" }));

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Name");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel31))
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel32))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel31))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel34)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel36))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addComponent(jLabel32)))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton8.setText("Calculate");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(44, 62, 80));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        jTableProfit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product", "Cost per unit", "Sold for", "Profit"
            }
        ));
        jScrollPane8.setViewportView(jTableProfit);

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Sold between dates");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel64)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(28, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout pane_DashboardLayout = new javax.swing.GroupLayout(pane_Dashboard);
        pane_Dashboard.setLayout(pane_DashboardLayout);
        pane_DashboardLayout.setHorizontalGroup(
            pane_DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane_DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pane_DashboardLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pane_DashboardLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pane_DashboardLayout.setVerticalGroup(
            pane_DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_DashboardLayout.createSequentialGroup()
                .addGroup(pane_DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane_DashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pane_DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jButton4)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 134, Short.MAX_VALUE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardframe.add(pane_Dashboard, "card2");

        pane_Banking.setBackground(new java.awt.Color(44, 62, 80));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Description");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("In Or Out");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Type");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Balance");

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("ID");

        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("#######");

        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDate.setText("######");

        jLabelDescription.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDescription.setText("######");

        jLabelInOrOut.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInOrOut.setText("######");

        jLabelType.setForeground(new java.awt.Color(255, 255, 255));
        jLabelType.setText("######");

        jLabelBalance.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBalance.setText("######");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Balance");

        jLabelValue.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValue.setText("######");

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

        javax.swing.GroupLayout pane_BankingLayout = new javax.swing.GroupLayout(pane_Banking);
        pane_Banking.setLayout(pane_BankingLayout);
        pane_BankingLayout.setHorizontalGroup(
            pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_BankingLayout.createSequentialGroup()
                .addGroup(pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane_BankingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE))
                    .addGroup(pane_BankingLayout.createSequentialGroup()
                        .addGroup(pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pane_BankingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(pane_BankingLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel21))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jLabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelInOrOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pane_BankingLayout.setVerticalGroup(
            pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_BankingLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pane_BankingLayout.createSequentialGroup()
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pane_BankingLayout.createSequentialGroup()
                        .addGroup(pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane_BankingLayout.createSequentialGroup()
                                .addGroup(pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabelID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pane_BankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabelValue)))
                            .addGroup(pane_BankingLayout.createSequentialGroup()
                                .addComponent(jLabelDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDescription)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelInOrOut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelBalance)))
                        .addGap(13, 13, 13)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardframe.add(pane_Banking, "card3");

        pane_Customers.setBackground(new java.awt.Color(44, 62, 80));

        jPanel4.setBackground(new java.awt.Color(64, 61, 79));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 86, 45), 3));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Add New To Do");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Task", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Started", "Complete", "Overdue" }));

        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("To Do's");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 86, 45), 3));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Customers", "Customers with Order Status", "Customers with Active Status", "Customers with Lay-Bye Status", "Customers with Done Status" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Search");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(44, 62, 80));

        jPanel8.setBackground(new java.awt.Color(44, 62, 80));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Salutation");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Name");
        jPanel8.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, -1, -1));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("First Name");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 74, -1, -1));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Midle Name");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 112, -1, -1));

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Last Name");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 146, -1, -1));

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Billing City");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 180, -1, -1));

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Billing State");
        jPanel8.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 214, -1, -1));

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("P.O.Box");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 248, -1, -1));

        jPanel9.setBackground(new java.awt.Color(44, 62, 80));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("######");
        jPanel9.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("######");
        jPanel9.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, -1, -1));

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("######");
        jPanel9.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 74, -1, -1));

        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("######");
        jPanel9.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 112, -1, -1));

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("######");
        jPanel9.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 146, -1, -1));

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("######");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 180, -1, -1));

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("######");
        jPanel9.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 214, -1, -1));

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("######");
        jPanel9.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 248, -1, -1));

        jButtonSet.setText("Set");
        jButtonSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetActionPerformed(evt);
            }
        });

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order", "Active", "Lay-Bye", "Done" }));

        jPanel10.setBackground(new java.awt.Color(44, 62, 80));

        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Status");

        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Amount");

        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Total");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel50)
                    .addComponent(jLabel53))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(jLabel54)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(44, 62, 80));

        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("######");

        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("######");

        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("######");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel52)
                        .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addGap(18, 18, 18)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(jLabel55)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSet, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSet)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pane_CustomersLayout = new javax.swing.GroupLayout(pane_Customers);
        pane_Customers.setLayout(pane_CustomersLayout);
        pane_CustomersLayout.setHorizontalGroup(
            pane_CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_CustomersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane_CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        pane_CustomersLayout.setVerticalGroup(
            pane_CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_CustomersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane_CustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane_CustomersLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cardframe.add(pane_Customers, "card4");

        pane_Expenses.setBackground(new java.awt.Color(44, 62, 80));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Expenses");

        javax.swing.GroupLayout pane_ExpensesLayout = new javax.swing.GroupLayout(pane_Expenses);
        pane_Expenses.setLayout(pane_ExpensesLayout);
        pane_ExpensesLayout.setHorizontalGroup(
            pane_ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_ExpensesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(994, Short.MAX_VALUE))
        );
        pane_ExpensesLayout.setVerticalGroup(
            pane_ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_ExpensesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(869, Short.MAX_VALUE))
        );

        cardframe.add(pane_Expenses, "card5");

        pane_Invoices.setBackground(new java.awt.Color(44, 62, 80));
        pane_Invoices.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Invoices");
        pane_Invoices.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jPanel7.setBackground(new java.awt.Color(238, 155, 31));

        jTableInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableInvoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInvoicesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableInvoices);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );

        pane_Invoices.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 142, -1, -1));

        jButtonSetInvoiceStatus.setText("Set");
        jButtonSetInvoiceStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetInvoiceStatusActionPerformed(evt);
            }
        });
        pane_Invoices.add(jButtonSetInvoiceStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 107, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order", "Active", "Lay-Bye", "Done", "Canceled" }));
        pane_Invoices.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 108, 160, -1));

        jLabel41.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("##############");
        pane_Invoices.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel42.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("##############");
        pane_Invoices.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel58.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("##############");
        pane_Invoices.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLabel59.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("##############");
        pane_Invoices.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel60.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("##############");
        pane_Invoices.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        jLabel61.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("##############");
        pane_Invoices.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, -1));

        jLabel62.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("##############");
        pane_Invoices.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, -1));

        cardframe.add(pane_Invoices, "card8");

        pane_Reports.setBackground(new java.awt.Color(44, 62, 80));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Reports");

        javax.swing.GroupLayout pane_ReportsLayout = new javax.swing.GroupLayout(pane_Reports);
        pane_Reports.setLayout(pane_ReportsLayout);
        pane_ReportsLayout.setHorizontalGroup(
            pane_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_ReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(1005, Short.MAX_VALUE))
        );
        pane_ReportsLayout.setVerticalGroup(
            pane_ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_ReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(869, Short.MAX_VALUE))
        );

        cardframe.add(pane_Reports, "card6");

        pane_Taxes.setBackground(new java.awt.Color(44, 62, 80));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Taxes");

        javax.swing.GroupLayout pane_TaxesLayout = new javax.swing.GroupLayout(pane_Taxes);
        pane_Taxes.setLayout(pane_TaxesLayout);
        pane_TaxesLayout.setHorizontalGroup(
            pane_TaxesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_TaxesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(1016, Short.MAX_VALUE))
        );
        pane_TaxesLayout.setVerticalGroup(
            pane_TaxesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_TaxesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(869, Short.MAX_VALUE))
        );

        cardframe.add(pane_Taxes, "card7");

        pane_accounting.setBackground(new java.awt.Color(44, 62, 80));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Accounting");

        javax.swing.GroupLayout pane_accountingLayout = new javax.swing.GroupLayout(pane_accounting);
        pane_accounting.setLayout(pane_accountingLayout);
        pane_accountingLayout.setHorizontalGroup(
            pane_accountingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_accountingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(981, Short.MAX_VALUE))
        );
        pane_accountingLayout.setVerticalGroup(
            pane_accountingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_accountingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(869, Short.MAX_VALUE))
        );

        cardframe.add(pane_accounting, "card9");

        pane_Database.setBackground(new java.awt.Color(44, 62, 80));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Data Base");

        javax.swing.GroupLayout pane_DatabaseLayout = new javax.swing.GroupLayout(pane_Database);
        pane_Database.setLayout(pane_DatabaseLayout);
        pane_DatabaseLayout.setHorizontalGroup(
            pane_DatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_DatabaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(992, Short.MAX_VALUE))
        );
        pane_DatabaseLayout.setVerticalGroup(
            pane_DatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_DatabaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(869, Short.MAX_VALUE))
        );

        cardframe.add(pane_Database, "card10");

        pane_Scraping.setBackground(new java.awt.Color(44, 62, 80));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Scraping");

        javax.swing.GroupLayout pane_ScrapingLayout = new javax.swing.GroupLayout(pane_Scraping);
        pane_Scraping.setLayout(pane_ScrapingLayout);
        pane_ScrapingLayout.setHorizontalGroup(
            pane_ScrapingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_ScrapingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(999, Short.MAX_VALUE))
        );
        pane_ScrapingLayout.setVerticalGroup(
            pane_ScrapingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_ScrapingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(869, Short.MAX_VALUE))
        );

        cardframe.add(pane_Scraping, "card11");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardframe, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardframe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void caculateDashBoard(){
        /*///////////////////////////////
        Orders
        *////////////////////////////////
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
            Statement st = con.createStatement();
            String s = "SELECT SUM(`total`) FROM Invoices WHERE `status` = 'Order' AND (`DateCreated` between "
                    + "'"+((JTextField)jDateChooserFrom.getDateEditor().getUiComponent()).getText()+"' and "
                    + "'"+((JTextField)jDateChooserTo.getDateEditor().getUiComponent()).getText()+"'";
            ResultSet rs = st.executeQuery(s);
            while(rs.next())
            {
            String OrdersString = rs.getString(1);
            Orders = Integer.parseInt(OrdersString);
            }
            }catch(Exception e){
            }
        /*///////////////////////////////
        Active
        *////////////////////////////////
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
            Statement st = con.createStatement();
            String s = "SELECT SUM(`total`) FROM Invoices WHERE `status` = 'Active' AND (`DateCreated` between "
                    + "'"+((JTextField)jDateChooserFrom.getDateEditor().getUiComponent()).getText()+"' and "
                    + "'"+((JTextField)jDateChooserTo.getDateEditor().getUiComponent()).getText()+"')";
            ResultSet rs = st.executeQuery(s);
            while(rs.next())
            {
            String ActiveString = rs.getString(1);
            Active = Integer.parseInt(ActiveString);
            }
            }catch(Exception e){
            }
        /*///////////////////////////////
        Done
        *////////////////////////////////
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
            Statement st = con.createStatement();
            String s = "SELECT SUM(`total`) FROM Invoices WHERE `status` = 'Done' AND (`DateCreated` between "
                    + "'"+((JTextField)jDateChooserFrom.getDateEditor().getUiComponent()).getText()+"' and "
                    + "'"+((JTextField)jDateChooserTo.getDateEditor().getUiComponent()).getText()+"')";
            ResultSet rs = st.executeQuery(s);
            while(rs.next())
            {
            String DoneString = rs.getString(1);
            Done = Integer.parseInt(DoneString);
            }
            }catch(Exception e){
            }
        
        
        /*///////////////////////////////
        LayBye still to pay
        *////////////////////////////////
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
            Statement st = con.createStatement();
            String s = "SELECT SUM(`stillToPay`) FROM LayByeInfo";
            ResultSet rs = st.executeQuery(s);
            while(rs.next())
            {
            String LayByeString = rs.getString(1);
            LayByestilltopay = Integer.parseInt(LayByeString);
            }
            }catch(Exception e){
            }
        /*///////////////////////////////
        LayBye paid
        *////////////////////////////////
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase","Berend", "kidcoltv6");
            Statement st = con.createStatement();
            String s = "SELECT SUM(`paid`) FROM LayByeInfo WHERE (`paymentDate` between "
                    + "'"+((JTextField)jDateChooserFrom.getDateEditor().getUiComponent()).getText()+"' and "
                    + "'"+((JTextField)jDateChooserTo.getDateEditor().getUiComponent()).getText()+"')";
            
            ResultSet rs = st.executeQuery(s);
            while(rs.next())
            {
            String LayByepaidString = rs.getString(1);
            LayByepaid = Integer.parseInt(LayByepaidString);
            }
            }catch(Exception e){
            }
        /*///////////////////////////////
        /////////////////////////////////
        *////////////////////////////////
        /*///////////////////////////////
        Set Variables
        *////////////////////////////////
        int MoneyAlreadyin = Active + Done + LayByepaid;
        int MoneyToBemade = Orders + LayByestilltopay;
        jLabelOrders.setText(String.valueOf(Orders));
        jLabelActive.setText(String.valueOf(Active));
        jLabelDone.setText(String.valueOf(Done));
        jLabelLayBye.setText(String.valueOf(LayByestilltopay));
        jLabelLayBye1.setText(String.valueOf(LayByepaid));
        jLabelMoneyAlreadyIn.setText(String.valueOf(MoneyAlreadyin));
        jLabelMoneyToBeMade.setText(String.valueOf(MoneyToBemade));
        //SELECT SUM(`total`) FROM Invoices WHERE `status` = 'Order'
    }
    
    public void checkOverdueTasks(){
        try{
           theQuery("UPDATE `ToDos` SET `status` = 'Overdue' WHERE `date` < NOW() AND `status` = 'Not Started'");
         }
         catch(Exception ex){}
    }
    
    public void populateJTable6() throws SQLException {
        TasksQuery2 pq = new TasksQuery2();
        ArrayList<tasks2> clist = null;
        try {
            clist = pq.tasksList2();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] colNames = {"ID","CustomerName","Date","Task","Status"};
        Object[][] rows = new Object[clist.size()][5];
        
        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getId();
            rows[i][1] = clist.get(i).getCustomerName();
            rows[i][2] = clist.get(i).getDate();
            rows[i][3] = clist.get(i).getTask();
            rows[i][4] = clist.get(i).getStatus();
        }
        
        
        InvoiceModel imd = new InvoiceModel(rows, colNames);
        jTable6.setModel(imd);
}
        public void populatejTableProfit() throws SQLException {
        TasksQuery3 pq = new TasksQuery3();
        ArrayList<tasks3> clist = null;
        try {
            clist = pq.tasksList3();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] colNames = {"Product","QTY","CostPerUnit","SoldFor","Profit"};
        Object[][] rows = new Object[clist.size()][5];
        
        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getProduct();
            rows[i][0] = clist.get(i).getQty();
            rows[i][1] = clist.get(i).getCostperunit();
            rows[i][2] = clist.get(i).getTotal();
            rows[i][3] = clist.get(i).getProfit();
        }
        
        
        InvoiceModel imd = new InvoiceModel(rows, colNames);
        jTableProfit.setModel(imd);
        
        /*///////////////////////////////
        Profit
        *////////////////////////////////
        double totalProfit = 0;
        for (int i = 0; i < jTableProfit.getRowCount(); i++) {
            totalProfit+=Double.parseDouble(jTableProfit.getValueAt(i, 4).toString());
        }
        totalProfit = totalProfit*100;
        totalProfit = (double)((int) totalProfit);
        totalProfit = totalProfit /100;
        jLabeltotalProfit.setText(""+totalProfit);
}
    
    public void populateJTable5() throws SQLException {
        TasksQuery1 pq = new TasksQuery1();
        ArrayList<tasks1> clist = null;
        try {
            clist = pq.tasksList1();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] colNames = {"ID","CustomerName","Date","Task","Status"};
        Object[][] rows = new Object[clist.size()][5];
        
        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getId();
            rows[i][1] = clist.get(i).getCustomerName();
            rows[i][2] = clist.get(i).getDate();
            rows[i][3] = clist.get(i).getTask();
            rows[i][4] = clist.get(i).getStatus();
        }
        
        
        InvoiceModel imd = new InvoiceModel(rows, colNames);
        jTable5.setModel(imd);
        jTable5.getColumnModel().getColumn(0).setPreferredWidth(10);
}
    
    public void populateJTable4() throws SQLException {
        InvoiceQuery pq = new InvoiceQuery();
        ArrayList<invoice> clist = null;
        try {
            clist = pq.invoiceListSortBy();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] colNames = {"CustomerName"};
        Object[][] rows = new Object[clist.size()][1];
        
        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getCustomerName();
        }
        

        
        
        InvoiceModel imd = new InvoiceModel(rows, colNames);
        jTable4.setModel(imd);
}
    
    public void populateJTableInvoices() throws SQLException {
        InvoiceQuery2 pq = new InvoiceQuery2();
        ArrayList<invoice> clist = null;
        try {
            clist = pq.invoiceList();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] colNames = {"IN","Name","Product","Qty","Amount","Total","Status"};
        Object[][] rows = new Object[clist.size()][7];
        
        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getReferenceNumber();
            rows[i][1] = clist.get(i).getCustomerName();
            rows[i][2] = clist.get(i).getProduct();
            rows[i][3] = clist.get(i).getQty();
            rows[i][4] = clist.get(i).getAmount();
            rows[i][5] = clist.get(i).getTotal();
            rows[i][6] = clist.get(i).getStatus();
        }
        

        
        
        InvoiceModel2 imd = new InvoiceModel2(rows, colNames);
        jTableInvoices.setModel(imd);
        jTableInvoices.getColumnModel().getColumn(0).setPreferredWidth(5);
}
    public void populateUserJLables() throws SQLException {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement("SELECT `Salutation`, `FirstName`, `MiddleInitial`, `LastName`, `BillingLine1`, "
                    + "`BillingLine2`, `BillingLine3`, `BillingCity`, `BillingState`, `BillingPoBox`, `Name` FROM `Customers` WHERE `Name` = '"+name+"'");
            rs = ps.executeQuery();
            
            if(rs.next()){
                jLabel46.setText(rs.getString(1));
                jLabel45.setText(rs.getString(2));
                jLabel44.setText(rs.getString(3));
                jLabel43.setText(rs.getString(4));
                jLabel35.setText(rs.getString(8));
                jLabel39.setText(rs.getString(9));
                jLabel40.setText(rs.getString(10));
                jLabel48.setText(rs.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ps = con.prepareStatement("SELECT `ID`, `ReferenceNumber`, `CustomerName`, `BillingAddress`, `ShippingAddress`, "
                    + "`DueDate`, `DateCreated`, `product`, `qty`, `amount`, `total`, `status` FROM `Invoices`"
                    + " WHERE `CustomerName` = '"+name+"'");
            rs = ps.executeQuery();
            
            if(rs.next()){
                jLabel51.setText(rs.getString(12));
                jLabel52.setText(rs.getString(10));
                jLabel55.setText(rs.getString(11));
                jComboBoxStatus.setSelectedItem(rs.getString(12));
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void populateJTable3() throws SQLException {
        BankingQuery pq = new BankingQuery();
        ArrayList<banking> clist = pq.bankingList();
        String[] colNames = {"ID","Date","Description","InOut","Type","Balance","Value"};
        Object[][] rows = new Object[clist.size()][7];
        
        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getCid();
            rows[i][1] = clist.get(i).getDate();
            rows[i][2] = clist.get(i).getDescription();
            rows[i][3] = clist.get(i).getInOut();
            rows[i][4] = clist.get(i).getType();
            rows[i][5] = clist.get(i).getBalance();
            rows[i][6] = clist.get(i).getValue();
        }
        BankingModel bmd = new BankingModel(rows, colNames);
        jTable3.setModel(bmd);
    }
    
    public ArrayList<banking> ListBanking(String ValToSearch){
        ArrayList<banking> BankingList = new ArrayList<>();
        
        Statement st;
        ResultSet resultset;
        
        try{
            Connection connection = getConnection();
            st = (Statement) connection.createStatement();
            String BankingQuery = "SELECT * FROM `HannesReportBankAccount` WHERE CONCAT(`id`, `Date`, `Description`, `InOut`, `Type`, `Balance`, `value`) LIKE '%"+ValToSearch+"%'";
            resultset = st.executeQuery(BankingQuery);
            
            banking Banking;
            
            while(resultset.next())
            {
                Banking = new banking(
                                resultset.getInt("id"),
                                resultset.getString("Date"),
                                resultset.getString("Description"),
                                resultset.getString("InOut"),
                                resultset.getString("Type"),
                                resultset.getString("Balance"),
                                resultset.getString("value")
                                );
                BankingList.add(Banking);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return BankingList;
    }
    
    // function to display data in jtable
    public void SearchBanking()
    {
        ArrayList<banking> Banking = ListBanking(jTextFieldSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Date","Description","InOut","Type","Balance","Value"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < Banking.size(); i++)
        {
            row[0] = Banking.get(i).getCid();
            row[1] = Banking.get(i).getDate();
            row[2] = Banking.get(i).getDescription();
            row[3] = Banking.get(i).getInOut();
            row[4] = Banking.get(i).getType();
            row[5] = Banking.get(i).getBalance();
            row[6] = Banking.get(i).getValue();
            model.addRow(row);
        }
        jTable3.setModel(model);
    }
    Color searchColor = new Color(153,153,153);
    
    public void subitTasks() throws ParseException{
        
        String nameForTaskSubission = jLabel48.getText();
        String Date = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        String task = jTextArea1.getText();
        String Status = jComboBox2.getSelectedItem().toString();
        
        try{
                 theQuery("INSERT INTO `ToDos`(`customerName`, `date`, `task`, `status`) VALUES ('"+nameForTaskSubission+"','"+Date+"','"+task+"','"+Status+"')");
                 JOptionPane.showMessageDialog(null, "Task inserted into DataBase.");
            }
             catch(Exception ex){}
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        CardLayout c = (CardLayout)(cardframe.getLayout());
        c.show(cardframe, "card2");
        caculateDashBoard();
        checkOverdueTasks();
        try {
            populateJTable6();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            populateJTable5();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnBankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBankingActionPerformed
        try {
            populateJTable3();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card3");
    }//GEN-LAST:event_btnBankingActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        try {
            populateJTable4();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card4");
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpensesActionPerformed
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card5");
    }//GEN-LAST:event_btnExpensesActionPerformed

    private void btnInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoicesActionPerformed
        try {
            populateJTableInvoices();
                    } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card8");
    }//GEN-LAST:event_btnInvoicesActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card6");
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnTaxesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaxesActionPerformed
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card7");
    }//GEN-LAST:event_btnTaxesActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnAccountingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountingActionPerformed
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card9");
    }//GEN-LAST:event_btnAccountingActionPerformed

    private void btnAccounting1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccounting1ActionPerformed
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card10");
    }//GEN-LAST:event_btnAccounting1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.minimumSize();
        VeiwProducts s = null;
        try {
            s = new VeiwProducts();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.setVisible(true);
        s.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Create s = new Create();
        s.setVisible(true);
        s.pack();
        s.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();
        
        this.setLocation(X-mousepX, Y-mousepY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void btnScrapingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScrapingActionPerformed
        CardLayout c = (CardLayout)(cardframe.getLayout()); //CardLayout c = (CardLayout)(panel.getLayout());
        c.show(cardframe, "card11");
    }//GEN-LAST:event_btnScrapingActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // display selected JTable row data

        // get selected row index
        int rowIndex = jTable3.getSelectedRow();
        jLabelID.setText(jTable3.getValueAt(rowIndex, 0).toString());
        jLabelDate.setText(jTable3.getValueAt(rowIndex, 1).toString());
        jLabelDescription.setText(jTable3.getValueAt(rowIndex, 2).toString());
        jLabelInOrOut.setText(jTable3.getValueAt(rowIndex, 3).toString());
        jLabelType.setText(jTable3.getValueAt(rowIndex, 4).toString());
        jLabelBalance.setText(jTable3.getValueAt(rowIndex, 5).toString());
        jLabelValue.setText(jTable3.getValueAt(rowIndex, 5).toString());

    }//GEN-LAST:event_jTable3MouseClicked

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
            SearchBanking();
        }
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        int rowIndex = jTable4.getSelectedRow();
        name = jTable4.getValueAt(rowIndex, 0).toString();
        try {
            populateUserJLables();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        ///////////////////////////////////
        // Populate Tasks JTable
        ///////////////////////////////////
        TasksQuery pq = new TasksQuery();
        ArrayList<tasks> clist = null;
        
        try {
            clist = pq.tasksList();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] colNames = {"Date","Task","Status"};
        Object[][] rows = new Object[clist.size()][3];

        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getDate();
            rows[i][1] = clist.get(i).getTask();
            rows[i][2] = clist.get(i).getStatus();
        }

        TasksModel imd = new TasksModel(rows, colNames);
        jTable1.setModel(imd);
        ///////////////////////////////////
        // End
        ///////////////////////////////////
    }//GEN-LAST:event_jTable4MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        InvoiceQuery pq = new InvoiceQuery();
        ArrayList<invoice> clist = null;
        try {
            clist = pq.invoiceListSortBy();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] colNames = {"CustomerName"};
        Object[][] rows = new Object[clist.size()][1];

        for(int i = 0; i < clist.size(); i++){
            rows[i][0] = clist.get(i).getCustomerName();
        }

        InvoiceModel imd = new InvoiceModel(rows, colNames);
        jTable4.setModel(imd);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetActionPerformed
        try{
           theQuery("UPDATE `Invoices` SET `status`= '"+jComboBoxStatus.getSelectedItem().toString()+"' WHERE `CustomerName` = '"+jLabel48.getText()+"'");
         }
         catch(Exception ex){}
    }//GEN-LAST:event_jButtonSetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            subitTasks();
        } catch (ParseException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        int rowIndex = jTable5.getSelectedRow();
        jLabel34.setText(jTable5.getValueAt(rowIndex, 0).toString());
        jLabel36.setText(jTable5.getValueAt(rowIndex, 1).toString());
        jComboBox3.setSelectedItem(jTable5.getValueAt(rowIndex, 4));
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        int rowIndex = jTable6.getSelectedRow();
        jLabel34.setText(jTable6.getValueAt(rowIndex, 0).toString());
        jLabel36.setText(jTable6.getValueAt(rowIndex, 1).toString());
        jComboBox3.setSelectedItem(jTable6.getValueAt(rowIndex, 4));
    }//GEN-LAST:event_jTable6MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
           theQuery("UPDATE `ToDos` SET `status`='"+jComboBox3.getSelectedItem().toString()+"' WHERE `id` = '"+jLabel34.getText()+"'");
         }
         catch(Exception ex){}
         try {
            populateJTable5();
        } catch (SQLException ex) {
            Logger.getLogger(VeiwProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            populateJTable6();
        } catch (SQLException ex) {
            Logger.getLogger(VeiwProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
             theQuery("DELETE FROM `ToDos` WHERE `id` = '"+jLabel34.getText()+"'");
         }
         catch(Exception ex){}
        try {
            populateJTable5();
        } catch (SQLException ex) {
            Logger.getLogger(VeiwProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            populateJTable6();
        } catch (SQLException ex) {
            Logger.getLogger(VeiwProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        caculateDashBoard();
        try {
            populatejTableProfit();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButtonSetInvoiceStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetInvoiceStatusActionPerformed
        try{
           theQuery("UPDATE `Invoices` SET `status`= '"+jComboBox4.getSelectedItem().toString()+"' WHERE `CustomerName` = '"+jLabel42.getText()+"' AND `product` = '"+jLabel58.getText()+"'");
         }
         catch(Exception ex){}
        try {
            populateJTableInvoices();
                    } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSetInvoiceStatusActionPerformed

    private void jTableInvoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInvoicesMouseClicked
        int rowIndex = jTableInvoices.getSelectedRow();
        String invoiceNumber = jTableInvoices.getValueAt(rowIndex, 0).toString();
        String name1 = jTableInvoices.getValueAt(rowIndex, 1).toString();
        String productName = jTableInvoices.getValueAt(rowIndex, 2).toString();
        String QTY = jTableInvoices.getValueAt(rowIndex, 3).toString();
        String ammount = jTableInvoices.getValueAt(rowIndex, 4).toString();
        String total = jTableInvoices.getValueAt(rowIndex, 5).toString();
        String status = jTableInvoices.getValueAt(rowIndex, 6).toString();
        jLabel41.setText(invoiceNumber);
        jLabel42.setText(name1);
        jLabel58.setText(productName);
        jLabel59.setText(QTY);
        jLabel60.setText(ammount);
        jLabel61.setText(total);
        jLabel62.setText(status);
    }//GEN-LAST:event_jTableInvoicesMouseClicked

    /**
     * @param args the command line arguments
     */
    
    public void theQuery(String query){
        Connection con = null;
        Statement st = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://192.168.8.158:3306/BargainDatabase", "Berend", "kidcoltv6");
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton btnAccounting;
    private javax.swing.JButton btnAccounting1;
    private javax.swing.JButton btnBanking;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnExpenses;
    private javax.swing.JButton btnInvoices;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnScraping;
    private javax.swing.JButton btnTaxes;
    private javax.swing.JButton btnexit;
    private javax.swing.JPanel cardframe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonSet;
    private javax.swing.JButton jButtonSetInvoiceStatus;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    public static com.toedter.calendar.JDateChooser jDateChooserFrom;
    public static com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    public static javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelActive;
    private javax.swing.JLabel jLabelBalance;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelDone;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInOrOut;
    private javax.swing.JLabel jLabelLayBye;
    private javax.swing.JLabel jLabelLayBye1;
    private javax.swing.JLabel jLabelMoneyAlreadyIn;
    private javax.swing.JLabel jLabelMoneyToBeMade;
    private javax.swing.JLabel jLabelOrders;
    private javax.swing.JLabel jLabelType;
    public javax.swing.JLabel jLabelUserPic;
    public javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelValue;
    private javax.swing.JLabel jLabeltotalProfit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTableInvoices;
    private javax.swing.JTable jTableProfit;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JPanel pane_Banking;
    private javax.swing.JPanel pane_Customers;
    private javax.swing.JPanel pane_Dashboard;
    private javax.swing.JPanel pane_Database;
    private javax.swing.JPanel pane_Expenses;
    private javax.swing.JPanel pane_Invoices;
    private javax.swing.JPanel pane_Reports;
    private javax.swing.JPanel pane_Scraping;
    private javax.swing.JPanel pane_Taxes;
    private javax.swing.JPanel pane_accounting;
    // End of variables declaration//GEN-END:variables
}
