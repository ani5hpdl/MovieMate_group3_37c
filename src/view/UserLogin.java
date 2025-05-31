
package view;

import java.awt.Color;
import java.awt.event.ActionListener;

public class UserLogin extends javax.swing.JFrame {

    public UserLogin() {
        initComponents();
        transparent.setBackground(new Color(255,255,255,100));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transparent = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        account = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        password = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        icons = new javax.swing.JLabel();
        continueWith = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transparent.setBackground(new java.awt.Color(241, 238, 238));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/Group 37070.png"))); // NOI18N

        login.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        login.setText("Login");

        account.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        account.setText("Don't have an account yet?");

        loginButton.setBackground(new java.awt.Color(153, 153, 255));
        loginButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        loginButton.setText("Sign In");

        Password.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        Password.setToolTipText("");
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        password.setBackground(new java.awt.Color(0, 0, 0));
        password.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        password.setText("Password");

        Email.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        Email.setText("Enter your email");
        Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailFocusLost(evt);
            }
        });

        email.setBackground(new java.awt.Color(0, 0, 0));
        email.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        email.setText("Email");

        icons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/Frame 37274.png"))); // NOI18N

        continueWith.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        continueWith.setText("or continue with");

        register.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N
        register.setText("Register here");
        register.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transparentLayout = new javax.swing.GroupLayout(transparent);
        transparent.setLayout(transparentLayout);
        transparentLayout.setHorizontalGroup(
            transparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transparentLayout.createSequentialGroup()
                .addGroup(transparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transparentLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(account)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(transparentLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(transparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icons, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(transparentLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(transparentLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(continueWith))
                    .addGroup(transparentLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        transparentLayout.setVerticalGroup(
            transparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transparentLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addComponent(login)
                .addGap(21, 21, 21)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addComponent(continueWith)
                .addGap(16, 16, 16)
                .addComponent(icons, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(transparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(account))
                .addGap(95, 95, 95))
        );

        getContentPane().add(transparent, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 530, 480));

        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/FPP.jpg"))); // NOI18N
        getContentPane().add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFocusGained
        // TODO add your handling code here:
        if (Email.getText().equals("Enter your email")){
            Email.setText("");
        }
    }//GEN-LAST:event_EmailFocusGained

    private void EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFocusLost
        // TODO add your handling code here:
        if (Email.getText().isEmpty()){
            Email.setText("Enter your email");
        }
    }//GEN-LAST:event_EmailFocusLost

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusGained
        // TODO add your handling code here:
        if (String.valueOf(Password.getPassword()).equals("Enter your password")){
            Password.setText("");
        }
    }//GEN-LAST:event_PasswordFocusGained

    private void PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusLost
        // TODO add your handling code here:
        if (String.valueOf(Password.getPassword()).isEmpty()) {
            Password.setText("Enter your password");
    }

    }//GEN-LAST:event_PasswordFocusLost

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel account;
    private javax.swing.JLabel continueWith;
    private javax.swing.JLabel email;
    private javax.swing.JLabel icons;
    private javax.swing.JLabel login;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel password;
    private javax.swing.JButton register;
    private javax.swing.JPanel transparent;
    // End of variables declaration//GEN-END:variables


public void addUserLoginListener(ActionListener listener){
    
   loginButton.addActionListener(listener);
}

public javax.swing.JTextField getemailField(){
   return Email;
}

public javax.swing.JPasswordField getpasswordField(){
  return Password;
 }
}