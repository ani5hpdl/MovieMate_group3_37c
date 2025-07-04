
package view;

import java.awt.event.ActionListener;


public class OTPEntry extends javax.swing.JFrame {

    public OTPEntry() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        subTitle = new javax.swing.JLabel();
        numOtp = new javax.swing.JTextField();
        verifyButton = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/MOVIEMAT.png"))); // NOI18N
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        title.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        title.setText("Enter OTP");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        subTitle.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        subTitle.setText("We have send an OTP to your email");
        getContentPane().add(subTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        numOtp.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        numOtp.setText("Enter your OTP code");
        numOtp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numOtpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numOtpFocusLost(evt);
            }
        });
        getContentPane().add(numOtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 190, 190, -1));

        verifyButton.setBackground(new java.awt.Color(153, 153, 255));
        verifyButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        verifyButton.setText("Verify");
        getContentPane().add(verifyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 131, -1));

        mainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Assests/FPP.jpg"))); // NOI18N
        getContentPane().add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 510, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void numOtpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numOtpFocusGained
        // TODO add your handling code here:
        if (numOtp.getText().equals("Enter your OTP code")){
            numOtp.setText("");
        }
    }//GEN-LAST:event_numOtpFocusGained

    private void numOtpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numOtpFocusLost
        // TODO add your handling code here:
        if (numOtp.getText().isEmpty()){
            numOtp.setText("Enter your OTP code");
        }
    }//GEN-LAST:event_numOtpFocusLost

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OTPEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField numOtp;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel title;
    private javax.swing.JButton verifyButton;
    // End of variables declaration//GEN-END:variables
public void addUserListener(ActionListener listener){
    verifyButton.addActionListener(listener);
}

public javax.swing.JTextField getnumOtp(){
    return numOtp;
}
}
