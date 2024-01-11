/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package petshop.component;

import petshop.config.Database;
import petshop.form.PetCareForm;
import raven.toast.Notifications;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import java.awt.Toolkit;

/**
 *
 * @author Ryan Rizky
 */
public class PetCareInsertModal extends javax.swing.JFrame {

    private int mouseX, mouseY;
    private PetCareForm petCareForm;

    int totalDays = 0;
    int pricePerDay = 0;
    int discount = 0;
    int total = 0;

    /**
     * Creates new form PetCareInsertModal
     */
    public PetCareInsertModal(PetCareForm petCareForm) {
        // Set the frame to the center of the screen
        initComponents();

        this.petCareForm = petCareForm;

        // Set the frame to the center of the screen
        centerFrameOnScreen();

        // Add a mouse listener to the entire frame
        addDraggableMouseListener();

        // Set the combo box customer
        setComboCustomer();

        // Set the combo box pet
        setComboPet();

        // Set the combo box discount
        setComboDiscount();

        // Set the combo box status
        setComboStatus();

        // Set the summary
        setSummary();

        // Set the price
        setPrice();

        dateCheckIn.setMinSelectableDate(new Date());
        dateCheckOut.setMinSelectableDate(new Date());
    }

    private void addDraggableMouseListener() {
        // Add a mouse listener to the entire frame
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Get the current mouse coordinates
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Calculate the new location of the frame
                int newX = e.getXOnScreen() - mouseX;
                int newY = e.getYOnScreen() - mouseY;

                // Set the new location of the frame
                setLocation(newX, newY);
            }
        });
    }

    private void centerFrameOnScreen() {
        // Calculate the center of the screen
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

        // Set the frame location to the center
        setLocation(x, y);
    }

    private void setComboCustomer() {
        try {
            comboCustomer.removeAllItems();

            String sql = "SELECT name FROM customers";
            java.sql.Connection conn = (java.sql.Connection) Database.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            java.sql.ResultSet res = pst.executeQuery();

            while (res.next()) {
                comboCustomer.addItem(res.getString("name"));
            }

        } catch (Exception e) {
            petCareForm.showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }

    private void setComboPet() {
        try {
            comboPet.removeAllItems();
    
            // Check if a customer is selected
            if (comboCustomer.getSelectedItem() != null) {
                String selectedCustomer = comboCustomer.getSelectedItem().toString();
    
                String sql = "SELECT name FROM pets WHERE customer_id = (SELECT id FROM customers WHERE name = ?)";
                java.sql.Connection conn = (java.sql.Connection) Database.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
    
                pst.setString(1, selectedCustomer);
    
                java.sql.ResultSet res = pst.executeQuery();
    
                while (res.next()) {
                    comboPet.addItem(res.getString("name"));
                }
            }
        } catch (Exception e) {
            petCareForm.showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }

    private void setComboDiscount() {
        comboDiscount.removeAllItems();

        comboDiscount.addItem("Ya");
        comboDiscount.addItem("Tidak");
    }

    private void setComboStatus() {
        comboStatus.removeAllItems();

        comboStatus.addItem("On Progress");
        comboStatus.addItem("Done");
    }

    private void resetForm() {
        comboCustomer.setSelectedIndex(0);
        comboPet.setSelectedIndex(0);
        dateCheckIn.setDate(null);
        dateCheckOut.setDate(null);
        comboDiscount.setSelectedIndex(0);
        comboStatus.setSelectedIndex(0);
        textTotal.setText("0");
    }

    private void setSummary() {
        try {
            // Check if both dateCheckIn and dateCheckOut are not null
            if (dateCheckIn.getDate() != null && dateCheckOut.getDate() != null) {
    
                // Calculate total days
                LocalDate checkInDate = dateCheckIn.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate checkOutDate = dateCheckOut.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                totalDays = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    
                // Set the total days to the textTotalDay label
                textTotalDay.setText(String.valueOf(totalDays));
                setTotal();
            } else {
                textTotalDay.setText("0");
            }
        } catch (Exception e) {
            petCareForm.showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }

    private void setPrice() {
        try {
            String sqlPrice = "SELECT price FROM settings WHERE id = 1";
            java.sql.Connection connPrice = (java.sql.Connection) Database.configDB();
            java.sql.PreparedStatement pstPrice = connPrice.prepareStatement(sqlPrice);

            java.sql.ResultSet resPrice = pstPrice.executeQuery();
            if (resPrice.next()) {
                pricePerDay = resPrice.getInt("price");

                textPricePerDay.setText(String.valueOf(pricePerDay));
            }
        } catch (Exception e) {
            petCareForm.showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }
    
    private void setDiscount() {
        try {
            String sqlDiscount = "SELECT discount FROM settings WHERE id = 1";
            java.sql.Connection connDiscount = (java.sql.Connection) Database.configDB();
            java.sql.PreparedStatement pstDiscount = connDiscount.prepareStatement(sqlDiscount);
    
            java.sql.ResultSet resDiscount = pstDiscount.executeQuery();
            if (resDiscount.next()) {
                discount = resDiscount.getInt("discount");
    
                textDiscount.setText(String.valueOf(discount));
            }
        } catch (Exception e) {
            petCareForm.showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }
        
    private void setTotal() {
        try {
            int totalday = totalDays;
            int price = pricePerDay;
            int discounts = discount;

            int totaldiscount = (int) ((discounts / 100.0) * price * totalday);
            total = (price * totalday) - totaldiscount;

            textTotal.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            petCareForm.showNotification("Invalid input. Please enter valid numbers.", Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelRounded1 = new petshop.custom.PanelRounded();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboCustomer = new javax.swing.JComboBox<>();
        comboPet = new javax.swing.JComboBox<>();
        dateCheckIn = new com.toedter.calendar.JDateChooser();
        dateCheckOut = new com.toedter.calendar.JDateChooser();
        comboDiscount = new javax.swing.JComboBox<>();
        buttonCancel = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        panelRounded2 = new petshop.custom.PanelRounded();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textTotalDay = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textPricePerDay = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textDiscount = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textTotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(238, 240, 244));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 62, 89));
        jLabel1.setText("Pet Care");

        panelRounded1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama Pemilik");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nama Hewan");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Check-in");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Check-out");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Diskon");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboStatus.setPreferredSize(new java.awt.Dimension(64, 22));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Status");

        comboCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCustomerActionPerformed(evt);
            }
        });

        comboPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dateCheckIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateCheckInPropertyChange(evt);
            }
        });

        dateCheckOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateCheckOutPropertyChange(evt);
            }
        });

        comboDiscount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDiscountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRounded1Layout = new javax.swing.GroupLayout(panelRounded1);
        panelRounded1.setLayout(panelRounded1Layout);
        panelRounded1Layout.setHorizontalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRounded1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(105, 105, 105))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRounded1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded1Layout.createSequentialGroup()
                        .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboDiscount, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateCheckOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateCheckIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCustomer, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRounded1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(196, 196, 196))
                            .addComponent(comboPet, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        panelRounded1Layout.setVerticalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        buttonCancel.setBackground(new java.awt.Color(142, 149, 155));
        buttonCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancel.setText("Batal");
        buttonCancel.setFocusable(false);
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonAdd.setBackground(new java.awt.Color(46, 115, 228));
        buttonAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonAdd.setForeground(new java.awt.Color(255, 255, 255));
        buttonAdd.setText("Tambah");
        buttonAdd.setFocusable(false);
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonReset.setBackground(new java.awt.Color(52, 149, 104));
        buttonReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonReset.setText("Reset");
        buttonReset.setFocusable(false);
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        panelRounded2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Total Hari :");
        jPanel1.add(jLabel8);

        textTotalDay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTotalDay.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        textTotalDay.setText("0");
        jPanel1.add(textTotalDay);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Harga Per-hari :");
        jPanel1.add(jLabel12);

        textPricePerDay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPricePerDay.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        textPricePerDay.setText("0");
        jPanel1.add(textPricePerDay);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Diskon (Persen) :");
        jPanel1.add(jLabel14);

        textDiscount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDiscount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        textDiscount.setText("0");
        jPanel1.add(textDiscount);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Total Harga :");
        jPanel1.add(jLabel10);

        textTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        textTotal.setText("0");
        jPanel1.add(textTotal);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(57, 62, 89));
        jLabel16.setText("Summary");

        javax.swing.GroupLayout panelRounded2Layout = new javax.swing.GroupLayout(panelRounded2);
        panelRounded2.setLayout(panelRounded2Layout);
        panelRounded2Layout.setHorizontalGroup(
            panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded2Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel16)
                .addGap(141, 141, 141))
            .addGroup(panelRounded2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRounded2Layout.setVerticalGroup(
            panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelRounded1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel1)
                .addGap(300, 300, 300))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRounded1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close() {
        this.dispose();
    }

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        resetForm();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        close();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        try {
            String sql = "INSERT INTO petcares (customer_id, pet_id, check_in, check_out, discount, total, status) VALUES ((SELECT id FROM customers WHERE name = ?), (SELECT id FROM pets WHERE name = ?), ?, ?, ?, ?, ?)";
            java.sql.Connection conn = (java.sql.Connection) Database.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            if (comboCustomer.getSelectedItem() == null || comboPet.getSelectedItem() == null || dateCheckIn.getDate() == null || dateCheckOut.getDate() == null || comboDiscount.getSelectedItem() == null || comboStatus.getSelectedItem() == null) {
                petCareForm.showNotification("Please fill all the fields.", Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT);
                return;
            }

            // Convert date to the 'YYYY-MM-DD' format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDateIn = dateFormat.format(dateCheckIn.getDate());
            String formattedDateOut = dateFormat.format(dateCheckOut.getDate());

            pst.setString(1, comboCustomer.getSelectedItem().toString());
            pst.setString(2, comboPet.getSelectedItem().toString());
            pst.setString(3, formattedDateIn);
            pst.setString(4, formattedDateOut);
            pst.setInt(5, discount);
            pst.setInt(6, total);
            pst.setInt(7, comboStatus.getSelectedItem() != null && comboStatus.getSelectedItem().equals("On Progress") ? 0 : 1);

            pst.execute();
            int rowsAffected = pst.getUpdateCount();

            if (rowsAffected > 0) {
                petCareForm.showNotification("Pet care information added successfully.", Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT);
                petCareForm.refreshTable();
            } else {
                petCareForm.showNotification("Failed to add pet care information.", Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT);
            }

            close();
        } catch (Exception e) {
            petCareForm.showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void comboCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCustomerActionPerformed
        setComboPet();
    }//GEN-LAST:event_comboCustomerActionPerformed

    private void dateCheckInPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateCheckInPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            setSummary();
        }
    }//GEN-LAST:event_dateCheckInPropertyChange

    private void dateCheckOutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateCheckOutPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            setSummary();
        }
    }//GEN-LAST:event_dateCheckOutPropertyChange

    private void comboDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDiscountActionPerformed
        if (comboDiscount.getSelectedItem() != null && comboDiscount.getSelectedItem().equals("Ya")) {
            setDiscount();
        } else {
            textDiscount.setText("0");
            discount = 0;
        }
        setTotal();
    }//GEN-LAST:event_comboDiscountActionPerformed

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
            java.util.logging.Logger.getLogger(PetCareInsertModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PetCareInsertModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PetCareInsertModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PetCareInsertModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonReset;
    private javax.swing.JComboBox<String> comboCustomer;
    private javax.swing.JComboBox<String> comboDiscount;
    private javax.swing.JComboBox<String> comboPet;
    private javax.swing.JComboBox<String> comboStatus;
    private com.toedter.calendar.JDateChooser dateCheckIn;
    private com.toedter.calendar.JDateChooser dateCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private petshop.custom.PanelRounded panelRounded1;
    private petshop.custom.PanelRounded panelRounded2;
    private javax.swing.JLabel textDiscount;
    private javax.swing.JLabel textPricePerDay;
    private javax.swing.JLabel textTotal;
    private javax.swing.JLabel textTotalDay;
    // End of variables declaration//GEN-END:variables
}
