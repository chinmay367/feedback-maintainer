package feedbackmaintainer2;


import static java.lang.System.in;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CS
 */
public class loginteacher extends javax.swing.JFrame {

    /**
     * Creates new form loginstudent
     */
   static public String teacherid;
    public loginteacher() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 0));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 240, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 160, 110, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Teacher ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 120, 110, 30);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(320, 120, 140, 30);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(320, 160, 140, 30);

        setBounds(0, 0, 577, 489);
    }// </editor-fold>//GEN-END:initComponents
            
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  String url="jdbc:mysql://localhost/feedback";
        try
        {
            Connection conn=DriverManager.getConnection(url, "root", "");
            try
            {
            String q="select * from addteacher where teacherid=? and password=?";
            PreparedStatement state=conn.prepareStatement(q);
            state.setString(1,jTextField2.getText());
            state.setString(2,jPasswordField1.getText());
            
         teacherid=jTextField2.getText();
               
            ResultSet set=state.executeQuery();
            if(set.next())
            {
               new teacherinterface().setVisible(true);
               this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane,"Invalid Teacher first register");
                new studentregistration().setVisible(true);
                this.dispose();
            }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane,"error in query"+" "+e.getMessage());
            }
            finally
            {
                conn.close();
            }
            
        }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(rootPane, "error in connection"+" "+e.getMessage());
       }
      
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(loginteacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginteacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginteacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginteacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginteacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
