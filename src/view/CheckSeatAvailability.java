
package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class CheckSeatAvailability extends javax.swing.JFrame {

    public CheckSeatAvailability() {
        initComponents();
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        movieTitle = new javax.swing.JLabel();
        titleComboBox = new javax.swing.JComboBox<>();
        showTitle = new javax.swing.JLabel();
        timeComboBox = new javax.swing.JComboBox<>();
        title = new javax.swing.JLabel();
        Screen = new javax.swing.JLabel();
        BottomPanel = new javax.swing.JPanel();
        filterSeats = new javax.swing.JLabel();
        filterComboBox = new javax.swing.JComboBox<>();
        availableSeats = new javax.swing.JLabel();
        availableLabel = new javax.swing.JLabel();
        bookLabel = new javax.swing.JLabel();
        preLabel = new javax.swing.JLabel();
        regular = new javax.swing.JLabel();
        booked = new javax.swing.JLabel();
        premium = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        PanelWrapper = new javax.swing.JPanel();
        CenterPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setPreferredSize(new java.awt.Dimension(500, 350));
        MainPanel.setLayout(new java.awt.BorderLayout());

        TopPanel.setBackground(new java.awt.Color(245, 245, 220));
        TopPanel.setToolTipText("");
        TopPanel.setPreferredSize(new java.awt.Dimension(600, 150));

        movieTitle.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        movieTitle.setText("Movie Title: ");

        titleComboBox.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        titleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deadpool 3", "Avatar: The Way Of Water", "House Of The Dragon", "Avengers" }));
        titleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleComboBoxActionPerformed(evt);
            }
        });

        showTitle.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        showTitle.setText("ShowTime: ");

        timeComboBox.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00 AM", "1:00 PM", "4:00 PM", " " }));

        title.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        title.setText("Check Seat Availability");

        Screen.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        Screen.setForeground(new java.awt.Color(204, 85, 0));
        Screen.setText("Screen");

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TopPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(movieTitle))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(showTitle)))
                        .addGap(18, 18, 18)
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(Screen, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                .addGap(0, 229, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(164, 164, 164))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movieTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(Screen)
                .addContainerGap())
        );

        MainPanel.add(TopPanel, java.awt.BorderLayout.PAGE_START);

        BottomPanel.setBackground(new java.awt.Color(245, 245, 220));
        BottomPanel.setPreferredSize(new java.awt.Dimension(700, 80));

        filterSeats.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        filterSeats.setText("Filter Seats: ");

        filterComboBox.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Regular", "Premium", "Booked" }));

        availableSeats.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        availableSeats.setText("Available Seats: 80");

        availableLabel.setBackground(new java.awt.Color(102, 178, 255));
        availableLabel.setForeground(new java.awt.Color(255, 255, 255));
        availableLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        availableLabel.setOpaque(true);

        bookLabel.setBackground(new java.awt.Color(220, 20, 60));
        bookLabel.setForeground(new java.awt.Color(255, 255, 255));
        bookLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bookLabel.setOpaque(true);

        preLabel.setBackground(new java.awt.Color(255, 215, 0));
        preLabel.setForeground(new java.awt.Color(255, 255, 255));
        preLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        preLabel.setOpaque(true);

        regular.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        regular.setText("Regular");

        booked.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        booked.setText("Booked");

        premium.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        premium.setText("Premium");

        confirmButton.setBackground(new java.awt.Color(0, 51, 102));
        confirmButton.setForeground(new java.awt.Color(173, 216, 153));
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BottomPanelLayout = new javax.swing.GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
            BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(availableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(regular)
                .addGap(57, 57, 57)
                .addComponent(bookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(booked)
                .addGap(74, 74, 74)
                .addComponent(preLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(premium)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(filterSeats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(availableSeats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(confirmButton)
                .addGap(50, 50, 50))
        );
        BottomPanelLayout.setVerticalGroup(
            BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPanelLayout.createSequentialGroup()
                .addGroup(BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regular)
                    .addComponent(bookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(booked)
                    .addComponent(preLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(premium))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterSeats)
                    .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availableSeats)
                    .addComponent(confirmButton))
                .addGap(23, 23, 23))
        );

        MainPanel.add(BottomPanel, java.awt.BorderLayout.PAGE_END);

        PanelWrapper.setBackground(new java.awt.Color(245, 245, 220));
        PanelWrapper.setMinimumSize(new java.awt.Dimension(580, 360));
        PanelWrapper.setPreferredSize(new java.awt.Dimension(650, 350));

        CenterPanel.setBackground(new java.awt.Color(245, 245, 220));
        CenterPanel.setPreferredSize(new java.awt.Dimension(600, 310));
        CenterPanel.setLayout(new java.awt.GridLayout(8, 10, 5, 5));

        jButton1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton1.setText("A0");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setFocusPainted(false);
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton1);

        jButton2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton2.setText("A1");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setFocusPainted(false);
        jButton2.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton2.setPreferredSize(new java.awt.Dimension(50, 20));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        CenterPanel.add(jButton2);

        jButton3.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton3.setText("A2");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setFocusPainted(false);
        jButton3.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton3.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton3);

        jButton4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton4.setText("A3");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setFocusPainted(false);
        jButton4.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton4.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton4);

        jButton5.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton5.setText("A4");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setFocusPainted(false);
        jButton5.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton5.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton5);

        jButton6.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton6.setText("A5");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setFocusPainted(false);
        jButton6.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton6.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton6);

        jButton7.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton7.setText("A6");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton7.setFocusPainted(false);
        jButton7.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton7.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton7);

        jButton8.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton8.setText("A7");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton8.setFocusPainted(false);
        jButton8.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton8.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton8);

        jButton9.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton9.setText("A8");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.setFocusPainted(false);
        jButton9.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton9.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton9);

        jButton10.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton10.setText("A9");
        jButton10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton10.setFocusPainted(false);
        jButton10.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton10.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton10);

        jButton11.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton11.setText("B0");
        jButton11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton11.setFocusPainted(false);
        jButton11.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton11.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton11);

        jButton12.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton12.setText("B1");
        jButton12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton12.setFocusPainted(false);
        jButton12.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton12.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton12);

        jButton13.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton13.setText("B2");
        jButton13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton13.setFocusPainted(false);
        jButton13.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton13.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton13);

        jButton14.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton14.setText("B3");
        jButton14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton14.setFocusPainted(false);
        jButton14.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton14.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton14);

        jButton15.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton15.setText("B4");
        jButton15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton15.setFocusPainted(false);
        jButton15.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton15.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton15);

        jButton16.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton16.setText("B5");
        jButton16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton16.setFocusPainted(false);
        jButton16.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton16.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton16);

        jButton17.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton17.setText("B6");
        jButton17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton17.setFocusPainted(false);
        jButton17.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton17.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton17);

        jButton18.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton18.setText("B7");
        jButton18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton18.setFocusPainted(false);
        jButton18.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton18.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton18);

        jButton19.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton19.setText("B8");
        jButton19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton19.setFocusPainted(false);
        jButton19.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton19.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton19);

        jButton20.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton20.setText("B9");
        jButton20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton20.setFocusPainted(false);
        jButton20.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton20.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton20);

        jButton21.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton21.setText("C0");
        jButton21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton21.setFocusPainted(false);
        jButton21.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton21.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton21);

        jButton22.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton22.setText("C1");
        jButton22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton22.setFocusPainted(false);
        jButton22.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton22.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton22);

        jButton23.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton23.setText("C2");
        jButton23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton23.setFocusPainted(false);
        jButton23.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton23.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton23);

        jButton24.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton24.setText("C3");
        jButton24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton24.setFocusPainted(false);
        jButton24.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton24.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton24);

        jButton25.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton25.setText("C4");
        jButton25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton25.setFocusPainted(false);
        jButton25.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton25.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton25);

        jButton26.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton26.setText("C5");
        jButton26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton26.setFocusPainted(false);
        jButton26.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton26.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton26);

        jButton27.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton27.setText("C6");
        jButton27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton27.setFocusPainted(false);
        jButton27.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton27.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton27);

        jButton28.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton28.setText("C7");
        jButton28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton28.setFocusPainted(false);
        jButton28.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton28.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton28);

        jButton29.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton29.setText("C8");
        jButton29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton29.setFocusPainted(false);
        jButton29.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton29.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton29);

        jButton30.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton30.setText("C9");
        jButton30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton30.setFocusPainted(false);
        jButton30.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton30.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton30);

        jButton31.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton31.setText("D0");
        jButton31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton31.setFocusPainted(false);
        jButton31.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton31.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton31);

        jButton32.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton32.setText("D1");
        jButton32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton32.setFocusPainted(false);
        jButton32.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton32.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton32);

        jButton33.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton33.setText("D2");
        jButton33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton33.setFocusPainted(false);
        jButton33.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton33.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton33);

        jButton34.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton34.setText("D3");
        jButton34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton34.setFocusPainted(false);
        jButton34.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton34.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton34);

        jButton35.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton35.setText("D4");
        jButton35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton35.setFocusPainted(false);
        jButton35.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton35.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton35);

        jButton36.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton36.setText("D5");
        jButton36.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton36.setFocusPainted(false);
        jButton36.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton36.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton36);

        jButton37.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton37.setText("D6");
        jButton37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton37.setFocusPainted(false);
        jButton37.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton37.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton37);

        jButton38.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton38.setText("D7");
        jButton38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton38.setFocusPainted(false);
        jButton38.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton38.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton38);

        jButton39.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton39.setText("D8");
        jButton39.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton39.setFocusPainted(false);
        jButton39.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton39.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton39);

        jButton40.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton40.setText("D9");
        jButton40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton40.setFocusPainted(false);
        jButton40.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton40.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton40);

        jButton41.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton41.setText("E0");
        jButton41.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton41.setFocusPainted(false);
        jButton41.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton41.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton41);

        jButton42.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton42.setText("E1");
        jButton42.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton42.setFocusPainted(false);
        jButton42.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton42.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton42);

        jButton43.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton43.setText("E2");
        jButton43.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton43.setFocusPainted(false);
        jButton43.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton43.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton43);

        jButton44.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton44.setText("E3");
        jButton44.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton44.setFocusPainted(false);
        jButton44.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton44.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton44);

        jButton45.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton45.setText("E4");
        jButton45.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton45.setFocusPainted(false);
        jButton45.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton45.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton45);

        jButton46.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton46.setText("E5");
        jButton46.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton46.setFocusPainted(false);
        jButton46.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton46.setPreferredSize(new java.awt.Dimension(50, 20));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        CenterPanel.add(jButton46);

        jButton47.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton47.setText("E6");
        jButton47.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton47.setFocusPainted(false);
        jButton47.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton47.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton47);

        jButton48.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton48.setText("E7");
        jButton48.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton48.setFocusPainted(false);
        jButton48.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton48.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton48);

        jButton49.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton49.setText("E8");
        jButton49.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton49.setFocusPainted(false);
        jButton49.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton49.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton49);

        jButton50.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton50.setText("E9");
        jButton50.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton50.setFocusPainted(false);
        jButton50.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton50.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton50);

        jButton51.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton51.setText("F0");
        jButton51.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton51.setFocusPainted(false);
        jButton51.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton51.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton51);

        jButton52.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton52.setText("F1");
        jButton52.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton52.setFocusPainted(false);
        jButton52.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton52.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton52);

        jButton53.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton53.setText("F2");
        jButton53.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton53.setFocusPainted(false);
        jButton53.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton53.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton53);

        jButton54.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton54.setText("F3");
        jButton54.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton54.setFocusPainted(false);
        jButton54.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton54.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton54);

        jButton55.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton55.setText("F4");
        jButton55.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton55.setFocusPainted(false);
        jButton55.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton55.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton55);

        jButton56.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton56.setText("F5");
        jButton56.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton56.setFocusPainted(false);
        jButton56.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton56.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton56);

        jButton57.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton57.setText("F6");
        jButton57.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton57.setFocusPainted(false);
        jButton57.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton57.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton57);

        jButton58.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton58.setText("F7");
        jButton58.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton58.setFocusPainted(false);
        jButton58.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton58.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton58);

        jButton59.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton59.setText("F8");
        jButton59.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton59.setFocusPainted(false);
        jButton59.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton59.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton59);

        jButton60.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton60.setText("F9");
        jButton60.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton60.setFocusPainted(false);
        jButton60.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton60.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton60);

        jButton61.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton61.setText("G0");
        jButton61.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton61.setFocusPainted(false);
        jButton61.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton61.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton61);

        jButton62.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton62.setText("G1");
        jButton62.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton62.setFocusPainted(false);
        jButton62.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton62.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton62);

        jButton63.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton63.setText("G2");
        jButton63.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton63.setFocusPainted(false);
        jButton63.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton63.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton63);

        jButton64.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton64.setText("G3");
        jButton64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton64.setFocusPainted(false);
        jButton64.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton64.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton64);

        jButton65.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton65.setText("G4");
        jButton65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton65.setFocusPainted(false);
        jButton65.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton65.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton65);

        jButton66.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton66.setText("G5");
        jButton66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton66.setFocusPainted(false);
        jButton66.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton66.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton66);

        jButton67.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton67.setText("G6");
        jButton67.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton67.setFocusPainted(false);
        jButton67.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton67.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton67);

        jButton68.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton68.setText("G7");
        jButton68.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton68.setFocusPainted(false);
        jButton68.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton68.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton68);

        jButton69.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton69.setText("G8");
        jButton69.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton69.setFocusPainted(false);
        jButton69.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton69.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton69);

        jButton70.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton70.setText("G9");
        jButton70.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton70.setFocusPainted(false);
        jButton70.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton70.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton70);

        jButton71.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton71.setText("H0");
        jButton71.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton71.setFocusPainted(false);
        jButton71.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton71.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton71);

        jButton72.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton72.setText("H1");
        jButton72.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton72.setFocusPainted(false);
        jButton72.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton72.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton72);

        jButton73.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton73.setText("H2");
        jButton73.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton73.setFocusPainted(false);
        jButton73.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton73.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton73);

        jButton74.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton74.setText("H3");
        jButton74.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton74.setFocusPainted(false);
        jButton74.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton74.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton74);

        jButton75.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton75.setText("H4");
        jButton75.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton75.setFocusPainted(false);
        jButton75.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton75.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton75);

        jButton76.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton76.setText("H5");
        jButton76.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton76.setFocusPainted(false);
        jButton76.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton76.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton76);

        jButton77.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton77.setText("H6");
        jButton77.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton77.setFocusPainted(false);
        jButton77.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton77.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton77);

        jButton78.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton78.setText("H7");
        jButton78.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton78.setFocusPainted(false);
        jButton78.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton78.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton78);

        jButton79.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton79.setText("H8");
        jButton79.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton79.setFocusPainted(false);
        jButton79.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton79.setPreferredSize(new java.awt.Dimension(50, 20));
        CenterPanel.add(jButton79);

        jButton80.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jButton80.setText("H9");
        jButton80.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton80.setFocusPainted(false);
        jButton80.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton80.setPreferredSize(new java.awt.Dimension(50, 20));
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton80ActionPerformed(evt);
            }
        });
        CenterPanel.add(jButton80);

        PanelWrapper.add(CenterPanel);

        MainPanel.add(PanelWrapper, java.awt.BorderLayout.CENTER);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton80ActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void titleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleComboBoxActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckSeatAvailability().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel PanelWrapper;
    private javax.swing.JLabel Screen;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel availableLabel;
    private javax.swing.JLabel availableSeats;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JLabel booked;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> filterComboBox;
    private javax.swing.JLabel filterSeats;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel movieTitle;
    private javax.swing.JLabel preLabel;
    private javax.swing.JLabel premium;
    private javax.swing.JLabel regular;
    private javax.swing.JLabel showTitle;
    private javax.swing.JComboBox<String> timeComboBox;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox<String> titleComboBox;
    // End of variables declaration//GEN-END:variables

    public void addMovieSelectionListener(ActionListener listener) {
        titleComboBox.addActionListener(listener); 
    }
    public void addSeatTypeFilterListener(ActionListener listener){
        filterComboBox.addActionListener(listener);
    }
    public void addShowtimeListener(ActionListener listener){
        timeComboBox.addActionListener(listener);
    }
    public void addConfirmButtonListener(ActionListener listener){
        confirmButton.addActionListener(listener);
    }

public JButton[] getSeatButtons() {
        return new JButton[] {
            jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9, jButton10,
            jButton11, jButton12, jButton13, jButton14, jButton15, jButton16, jButton17, jButton18, jButton19, jButton20,
            jButton21, jButton22, jButton23, jButton24, jButton25, jButton26, jButton27, jButton28, jButton29, jButton30,
            jButton31, jButton32, jButton33, jButton34, jButton35, jButton36, jButton37, jButton38, jButton39, jButton40,
            jButton41, jButton42, jButton43, jButton44, jButton45, jButton46, jButton47, jButton48, jButton49, jButton50,
            jButton51, jButton52, jButton53, jButton54, jButton55, jButton56, jButton57, jButton58, jButton59, jButton60,
            jButton61, jButton62, jButton63, jButton64, jButton65, jButton66, jButton67, jButton68, jButton69, jButton70,
            jButton71, jButton72, jButton73, jButton74, jButton75, jButton76, jButton77, jButton78, jButton79, jButton80
        };
    }

    public String getSelectedmovie(){
       return titleComboBox.getSelectedItem() != null ? titleComboBox.getSelectedItem().toString(): "";
    }
    public String getSelectedShowtime(){
       return timeComboBox.getSelectedItem() != null? timeComboBox.getSelectedItem().toString(): "";
    }
    public String getSelectedSeatType(){
       return filterComboBox.getSelectedItem() != null? filterComboBox.getSelectedItem().toString() : "";
    }
    public void updateAvailableSeat(int count){
       availableSeats.setText("Available Seats: " + count);
    }
    public void showMessage(String message) {
       javax.swing.JOptionPane.showMessageDialog(this, message);
    }
}