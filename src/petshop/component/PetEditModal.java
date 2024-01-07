/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package petshop.component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.formdev.flatlaf.FlatClientProperties;

import petshop.config.Database;
import petshop.form.PetForm;
import raven.toast.Notifications;

import java.awt.Toolkit;

/**
 *
 * @author Ryan Rizky
 */
public class PetEditModal extends javax.swing.JFrame {

    private PetForm petForm;
    private int mouseX, mouseY;
    private String id, name, breed, color, age, description, customerName;
    /**
     * Creates new form PetEditModal
     */
    public PetEditModal(PetForm petForm, String id, String name, String breed, String color, String age, String description, String customerName) {
        initComponents();
        this.petForm = petForm;

        addDraggableMouseListener();
        centerFrameOnScreen();
        setComboCustomer();
        setFieldData();
        setPlaceholder();
    }

    private void setPlaceholder() {
        textPetName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Hewan");
        textBreed.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Jenis Hewan");
        textColor.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Warna Hewan");
        textAge.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Umur Hewan");
    }

    public void resetForm() {
        textPetName.setText("");
        textBreed.setText("");
        textColor.setText("");
        textAge.setText("");
        areaDescription.setText("");
        comboCustomer.setSelectedIndex(0);
    }

    public void setFieldData() {
        textID.setText(id);
        textPetName.setText(name);
        textBreed.setText(breed);
        textColor.setText(color);
        textAge.setText(age);
        areaDescription.setText(description);
        
        for (int i = 0; i < comboCustomer.getItemCount(); i++) {
            if (comboCustomer.getItemAt(i).equals(customerName)) {
                comboCustomer.setSelectedIndex(i);
                break;
            }
        }
    }

    private void setComboCustomer() {
        try {
            comboCustomer.removeAllItems();

            String sql = "SELECT name FROM customers";
            java.sql.Connection conn = (java.sql.Connection) petshop.config.Database.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            java.sql.ResultSet res = pst.executeQuery();

            while (res.next()) {
                comboCustomer.addItem(res.getString("name"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addDraggableMouseListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = e.getXOnScreen() - mouseX;
                int newY = e.getYOnScreen() - mouseY;

                setLocation(newX, newY);
            }
        });
    }

    private void centerFrameOnScreen() {
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

        setLocation(x, y);
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
        textPetName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textBreed = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textColor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textAge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDescription = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        comboCustomer = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        buttonUpdate = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(238, 240, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 62, 89));
        jLabel1.setText("Pet");

        panelRounded1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama Hewan");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Jenis Hewan");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Warna Hewan");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Umur Hewan (Bulan)");

        areaDescription.setColumns(20);
        areaDescription.setRows(5);
        jScrollPane1.setViewportView(areaDescription);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Deskripsi");

        comboCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCustomer.setPreferredSize(new java.awt.Dimension(64, 22));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Pemilik");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("ID");

        textID.setEditable(false);

        javax.swing.GroupLayout panelRounded1Layout = new javax.swing.GroupLayout(panelRounded1);
        panelRounded1.setLayout(panelRounded1Layout);
        panelRounded1Layout.setHorizontalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded1Layout.createSequentialGroup()
                        .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textBreed, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textColor)
                            .addComponent(textAge)
                            .addComponent(jScrollPane1)
                            .addComponent(comboCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRounded1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRounded1Layout.createSequentialGroup()
                                        .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRounded1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(105, 105, 105))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRounded1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(86, 86, 86))
                                    .addGroup(panelRounded1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(196, 196, 196))
                                    .addGroup(panelRounded1Layout.createSequentialGroup()
                                        .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panelRounded1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(7, 7, 7)))
                                        .addGap(195, 195, 195))))
                            .addComponent(textPetName))
                        .addGap(20, 20, 20))
                    .addGroup(panelRounded1Layout.createSequentialGroup()
                        .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRounded1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(195, 195, 195)))
                        .addGap(19, 19, 19))))
        );
        panelRounded1Layout.setVerticalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(textID)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(textPetName)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(textBreed)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(textColor)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(textAge)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        buttonUpdate.setBackground(new java.awt.Color(46, 115, 228));
        buttonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdate.setText("Perbarui");
        buttonUpdate.setFocusable(false);
        buttonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateMouseClicked(evt);
            }
        });

        buttonReset.setBackground(new java.awt.Color(52, 149, 104));
        buttonReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonReset.setText("Reset");
        buttonReset.setFocusable(false);
        buttonReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonResetMouseClicked(evt);
            }
        });

        buttonCancel.setBackground(new java.awt.Color(142, 149, 155));
        buttonCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancel.setText("Batal");
        buttonCancel.setFocusable(false);
        buttonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel1))
                            .addComponent(panelRounded1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(panelRounded1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateMouseClicked
        try{
            String id = textID.getText();
            String name = textPetName.getText();
            String breed = textBreed.getText();
            String color = textColor.getText();
            String age = textAge.getText();
            String description = areaDescription.getText();
            String customerName = comboCustomer.getSelectedItem().toString();

            String sql = "UPDATE pets SET name = ?, breed = ?, color = ?, age = ?, description = ?, customer_id = (SELECT id FROM customers WHERE name = ?), updated_at = NOW() WHERE id = ?";
            java.sql.Connection conn = (java.sql.Connection) Database.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, breed);
            pst.setString(3, color);
            pst.setString(4, age);
            pst.setString(5, description);
            pst.setString(6, customerName);
            pst.setString(7, id);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0){
                petForm.showNotification("Success updated pets information", Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT);
                petForm.refreshTable();
            } else {
                petForm.showNotification("Failed updated pets information", Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT);
            }

            close();
        } catch (Exception e) {
            petForm.showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }//GEN-LAST:event_buttonUpdateMouseClicked

    private void buttonResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonResetMouseClicked
        resetForm();
    }//GEN-LAST:event_buttonResetMouseClicked

    private void buttonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelMouseClicked
        close();
    }//GEN-LAST:event_buttonCancelMouseClicked

    private void close() {
        this.dispose(); // Close the customer modal
    }

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
            java.util.logging.Logger.getLogger(PetEditModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PetEditModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PetEditModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PetEditModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescription;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<String> comboCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private petshop.custom.PanelRounded panelRounded1;
    private javax.swing.JTextField textAge;
    private javax.swing.JTextField textBreed;
    private javax.swing.JTextField textColor;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textPetName;
    // End of variables declaration//GEN-END:variables
}
