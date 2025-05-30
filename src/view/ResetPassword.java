package view;




import java.awt.event.ActionListener;

public class ResetPassword extends javax.swing.JFrame {


    public ResetPassword() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoFP = new javax.swing.JLabel();
        forgotPassword = new javax.swing.JLabel();
        enterEmail = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        codeButton = new javax.swing.JButton();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoFP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/Logo.png"))); // NOI18N
        getContentPane().add(logoFP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        forgotPassword.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        forgotPassword.setText("Forgot your Password?");
        getContentPane().add(forgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        enterEmail.setFont(new java.awt.Font("Consolas", 0, 8)); // NOI18N
        enterEmail.setText("Enter your email so we can send you resend code");
        getContentPane().add(enterEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        email.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        email.setText("Email");
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 51, -1));

        textEmail.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        textEmail.setText("Enter your email");
        textEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textEmailFocusLost(evt);
            }
        });
        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });
        getContentPane().add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 280, 27));

        codeButton.setBackground(new java.awt.Color(153, 153, 255));
        codeButton.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        codeButton.setText("Send Code");
        getContentPane().add(codeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 195, -1));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/FPP.jpg"))); // NOI18N
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void textEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textEmailFocusGained
        // TODO add your handling code here:
      if (textEmail.getText().equals("Enter your email")){
          textEmail.setText("");
      }
    }//GEN-LAST:event_textEmailFocusGained

    private void textEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textEmailFocusLost
        // TODO add your handling code here:
        if (textEmail.getText().isEmpty()){
            textEmail.setText("Enter your email");
        }
    }//GEN-LAST:event_textEmailFocusLost

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton codeButton;
    private javax.swing.JLabel email;
    private javax.swing.JLabel enterEmail;
    private javax.swing.JLabel forgotPassword;
    private javax.swing.JLabel image;
    private javax.swing.JLabel logoFP;
    private javax.swing.JTextField textEmail;
    // End of variables declaration//GEN-END:variables

public void addUserListener(ActionListener listener){
    codeButton.addActionListener(listener);
}

public javax.swing.JTextField gettextEmail(){
    return textEmail;
}

}

