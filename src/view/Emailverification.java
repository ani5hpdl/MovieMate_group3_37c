package view;

import javax.swing.JOptionPane;

public class Emailverification extends javax.swing.JFrame {

    private String userEmail;

    // Constructor requires email so that OTP is associated properly
    public Emailverification(String email) {
        this.userEmail = email;
        initComponents();
        jLabel2.setText("OTP sent to: " + email);

        // Debugging: print text as user types
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                System.out.println("Typed so far: '" + jTextField2.getText() + "'");
            }
        });

        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                System.out.println("TextField lost focus. Current text: '" + jTextField2.getText() + "'");
            }
        });
    }

    // ==== GENERATED CODE (do not modify) ====

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField2.addActionListener(evt -> jTextField2ActionPerformed(evt));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jButton2.setText("Verify ");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jButton4.setText("Cancel");
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel2.setText("The OTP is sent to your E-mail");

        jLabel3.setText("Enter the OTP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(204, 204, 204))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel3)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(36, 36, 36))
        );

        pack();
    }

    // ==== END GENERATED CODE ====

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // You can leave this empty or handle Enter key on OTP field
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String otp = jTextField2.getText();
        System.out.println("OTP from textfield on Verify click: '" + otp + "'");
        System.out.println("User email in Emailverification: '" + userEmail + "'");

        if (otp == null || otp.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the OTP.");
            return;
        }

        // Call your controller to verify
        String result = Controller.OtpVerifier.verifyOtp(userEmail, otp.trim());
        JOptionPane.showMessageDialog(this, result);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose(); // Close window on cancel
    }

    // ===== Variables declaration =====
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField2;
    // ===== End of variables declaration =====
}
