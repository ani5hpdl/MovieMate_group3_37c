
package view;

import java.awt.event.ActionListener;

public class NewPassword extends javax.swing.JFrame {

    public NewPassword() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        subTitle = new javax.swing.JLabel();
        newPassword = new javax.swing.JLabel();
        reEnterPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtReEnterPassword = new javax.swing.JPasswordField();
        resetButton = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/Logo.png"))); // NOI18N
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        title.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        title.setText("Reset Password");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        subTitle.setFont(new java.awt.Font("Consolas", 0, 8)); // NOI18N
        subTitle.setText("Please set your new Password");
        getContentPane().add(subTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        newPassword.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        newPassword.setText("New Password");
        getContentPane().add(newPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        reEnterPassword.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        reEnterPassword.setText("Re-enter Password");
        getContentPane().add(reEnterPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        txtPassword.setText("Enter your new Password");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 252, -1));

        txtReEnterPassword.setText("Re-enter your new password");
        txtReEnterPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtReEnterPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtReEnterPasswordFocusLost(evt);
            }
        });
        getContentPane().add(txtReEnterPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 252, -1));

        resetButton.setBackground(new java.awt.Color(153, 153, 255));
        resetButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        resetButton.setText("Reset");
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 152, -1));

        mainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/FPP.jpg"))); // NOI18N
        getContentPane().add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
        if (txtPassword.getText().equals("Enter your new Password")){
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
        if (txtPassword.getText().isEmpty()){
            txtPassword.setText("Enter your new Password");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtReEnterPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReEnterPasswordFocusGained
        // TODO add your handling code here:
        if (txtReEnterPassword.getText().equals("Re-enter your new password")){
            txtReEnterPassword.setText("");
        }
    }//GEN-LAST:event_txtReEnterPasswordFocusGained

    private void txtReEnterPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReEnterPasswordFocusLost
        // TODO add your handling code here:
        if (txtReEnterPassword.getText().isEmpty()){
            txtReEnterPassword.setText("Re-enter your new password");
        }
    }//GEN-LAST:event_txtReEnterPasswordFocusLost

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel newPassword;
    private javax.swing.JLabel reEnterPassword;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel title;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtReEnterPassword;
    // End of variables declaration//GEN-END:variables
public void addUserListener(ActionListener listener){
    resetButton.addActionListener(listener);
}

public javax.swing.JTextField gettxtpassword(){
    return txtPassword;
}

public javax.swing.JTextField gettxtReEnterPassword(){
    return txtReEnterPassword;
}
}
