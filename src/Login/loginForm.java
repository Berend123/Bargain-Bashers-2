package Login;


import DatabaseConnection.myConnection;
import MainFrame.MainFrame;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author berendfuchs
 */
public class loginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    int mousepX;
    int mousepY;
    
    public loginForm() {
        initComponents();
        setLocationRelativeTo(null);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBoxSowPass = new javax.swing.JCheckBox();
        jButtonCancel = new javax.swing.JButton();
        jButtonLogin1 = new javax.swing.JButton();
        jLabelCreateAccount = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 170, 130, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 70, 130, 30);

        jTextFieldUsername.setBackground(new java.awt.Color(159, 182, 204));
        jTextFieldUsername.setForeground(new java.awt.Color(153, 0, 0));
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldUsername);
        jTextFieldUsername.setBounds(220, 66, 250, 40);

        jPasswordField1.setBackground(new java.awt.Color(159, 182, 204));
        jPasswordField1.setForeground(new java.awt.Color(153, 0, 0));
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        jPanel2.add(jPasswordField1);
        jPasswordField1.setBounds(220, 170, 250, 40);

        jCheckBoxSowPass.setText("Show password");
        jCheckBoxSowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSowPassActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxSowPass);
        jCheckBoxSowPass.setBounds(480, 180, 130, 23);

        jButtonCancel.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCancel);
        jButtonCancel.setBounds(240, 250, 120, 50);

        jButtonLogin1.setBackground(new java.awt.Color(102, 102, 255));
        jButtonLogin1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jButtonLogin1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin1.setText("Login");
        jButtonLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogin1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonLogin1);
        jButtonLogin1.setBounds(400, 249, 120, 50);

        jLabelCreateAccount.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabelCreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCreateAccount.setText("New user? click here to create an account.");
        jLabelCreateAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCreateAccountMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelCreateAccount);
        jLabelCreateAccount.setBounds(220, 320, 290, 17);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 630, 380));

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
        jLabel2.setText("Login Form");

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
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 450, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jCheckBoxSowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSowPassActionPerformed
        if(jCheckBoxSowPass.isSelected()){
            jPasswordField1.setEchoChar((char)0);
        } else {
            jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBoxSowPassActionPerformed

    private void jLabelCreateAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCreateAccountMouseClicked
        signupForm s = new signupForm();
        s.setVisible(true);
        s.pack();
        s.setLocationRelativeTo(null);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabelCreateAccountMouseClicked

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogin1ActionPerformed
        
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement("SELECT `username`, `pass`, `pic`, id FROM `user` WHERE `username` = ? AND `pass` = ?");
            ps.setString(1, jTextFieldUsername.getText());
            ps.setString(2, String.valueOf(jPasswordField1.getPassword()));
            rs = ps.executeQuery();
            
            if(rs.next()){
                //Get current user id
                MainFrame.currentUserId = rs.getInt("id");
                MainFrame s = new MainFrame();
                s.setVisible(true);
                s.pack();
                s.setLocationRelativeTo(null);
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                /*
                Set user name and picture in mainframe
                */
                s.jLabelUserPic.setIcon(new Myfunc().resizePic(null, rs.getBytes(3), s.jLabelUserPic.getWidth(), s.jLabelUserPic.getHeight()));
                s.jLabelUsername.setText(rs.getString(1));
                
                /*
                set username in user logged in in the class (userLoggedIn)
                */
                int id = 0;
                try{
                    theQuery("UPDATE `userLoggedIn` SET `log`='"+rs.getString(1)+"' WHERE `id` = "+id);
                }
         catch(Exception ex){}
                
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter correct credentials");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLogin1ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();
        
        this.setLocation(X-mousepX, Y-mousepY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement("SELECT `username`, `pass`, `pic`, id FROM `user` WHERE `username` = ? AND `pass` = ?");
            ps.setString(1, jTextFieldUsername.getText());
            ps.setString(2, String.valueOf(jPasswordField1.getPassword()));
            rs = ps.executeQuery();
            
            if(rs.next()){
                //Get current user id
                MainFrame.currentUserId = rs.getInt("id");
                MainFrame s = new MainFrame();
                s.setVisible(true);
                s.pack();
                s.setLocationRelativeTo(null);
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                /*
                Set user name and picture in mainframe
                */
                s.jLabelUserPic.setIcon(new Myfunc().resizePic(null, rs.getBytes(3), s.jLabelUserPic.getWidth(), s.jLabelUserPic.getHeight()));
                s.jLabelUsername.setText(rs.getString(1));
                
                /*
                set username in user logged in in the class (userLoggedIn)
                */
                int id = 0;
                try{
                    theQuery("UPDATE `userLoggedIn` SET `log`='"+rs.getString(1)+"' WHERE `id` = "+id);
                }
         catch(Exception ex){}
                
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter correct credentials");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jTextFieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement("SELECT `username`, `pass`, `pic`, id FROM `user` WHERE `username` = ? AND `pass` = ?");
            ps.setString(1, jTextFieldUsername.getText());
            ps.setString(2, String.valueOf(jPasswordField1.getPassword()));
            rs = ps.executeQuery();
            
            if(rs.next()){
                //Get current user id
                MainFrame.currentUserId = rs.getInt("id");
                MainFrame s = new MainFrame();
                s.setVisible(true);
                s.pack();
                s.setLocationRelativeTo(null);
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                /*
                Set user name and picture in mainframe
                */
                s.jLabelUserPic.setIcon(new Myfunc().resizePic(null, rs.getBytes(3), s.jLabelUserPic.getWidth(), s.jLabelUserPic.getHeight()));
                s.jLabelUsername.setText(rs.getString(1));
                
                /*
                set username in user logged in in the class (userLoggedIn)
                */
                int id = 0;
                try{
                    theQuery("UPDATE `userLoggedIn` SET `log`='"+rs.getString(1)+"' WHERE `id` = "+id);
                }
         catch(Exception ex){}
                
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter correct credentials");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jTextFieldUsernameKeyPressed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonLogin1;
    private javax.swing.JCheckBox jCheckBoxSowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCreateAccount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
