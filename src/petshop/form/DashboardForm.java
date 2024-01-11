/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package petshop.form;

import petshop.config.Database;
import raven.toast.Notifications;

/**
 *
 * @author Ryan Rizky
 */
public class DashboardForm extends javax.swing.JPanel {

    /**
     * Creates new form DashboardForm
     */
    public DashboardForm() {
        initComponents();

        // Set customer data
        setCustomerData();

        // Set pet data
        setPetData();

        // Set pet care data
        setPetCareData();
    }

    public void setCustomerData(){
        try{
            String sql = "SELECT COUNT(*) FROM customers";
            java.sql.Connection conn = (java.sql.Connection) Database.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            if(rs.next()){
                totalCustomers.setText(rs.getString(1));
            }
        } catch(Exception e){
            showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }

    public void setPetData(){
        try{
            String sql = "SELECT COUNT(*) FROM pets";
            java.sql.Connection conn = (java.sql.Connection) Database.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            if(rs.next()){
                totalPets.setText(rs.getString(1));
            }
        } catch(Exception e){
            showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }

    public void setPetCareData(){
        try{
            String sql = "SELECT COUNT(*) FROM petcares";
            java.sql.Connection conn = (java.sql.Connection) Database.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            if(rs.next()){
                totalPetCares.setText(rs.getString(1));
            }
        } catch(Exception e){
            showNotification(e.getMessage(), Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT);
        }
    }

    public void showNotification(String message, Notifications.Type type, Notifications.Location location) {
        Notifications.getInstance().show(type, location, message);
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
        gridPanel = new javax.swing.JPanel();
        panelRounded2 = new petshop.custom.PanelRounded();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalCustomers = new javax.swing.JLabel();
        panelRounded3 = new petshop.custom.PanelRounded();
        jLabel8 = new javax.swing.JLabel();
        totalPets = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelRounded5 = new petshop.custom.PanelRounded();
        jLabel11 = new javax.swing.JLabel();
        totalPetCares = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(238, 240, 244));
        setPreferredSize(new java.awt.Dimension(1398, 688));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 62, 89));
        jLabel1.setText("Dashboard");

        gridPanel.setLayout(new java.awt.GridLayout(2, 2, 20, 20));

        panelRounded2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/account-box-65.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(57, 62, 89));
        jLabel3.setText("Customers");

        totalCustomers.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        totalCustomers.setForeground(new java.awt.Color(57, 62, 89));
        totalCustomers.setText("999");

        javax.swing.GroupLayout panelRounded2Layout = new javax.swing.GroupLayout(panelRounded2);
        panelRounded2.setLayout(panelRounded2Layout);
        panelRounded2Layout.setHorizontalGroup(
            panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRounded2Layout.createSequentialGroup()
                        .addComponent(totalCustomers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20))))
        );
        panelRounded2Layout.setVerticalGroup(
            panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(panelRounded2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(totalCustomers)))
                .addGap(20, 20, 20))
        );

        gridPanel.add(panelRounded2);

        panelRounded3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(57, 62, 89));
        jLabel8.setText("Pets");

        totalPets.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        totalPets.setForeground(new java.awt.Color(57, 62, 89));
        totalPets.setText("999");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/paw-65.png"))); // NOI18N

        javax.swing.GroupLayout panelRounded3Layout = new javax.swing.GroupLayout(panelRounded3);
        panelRounded3.setLayout(panelRounded3Layout);
        panelRounded3Layout.setHorizontalGroup(
            panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(590, Short.MAX_VALUE))
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addComponent(totalPets)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(20, 20, 20))))
        );
        panelRounded3Layout.setVerticalGroup(
            panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)
                        .addComponent(totalPets)))
                .addGap(20, 20, 20))
        );

        gridPanel.add(panelRounded3);

        panelRounded5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(57, 62, 89));
        jLabel11.setText("Pet Cares");

        totalPetCares.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        totalPetCares.setForeground(new java.awt.Color(57, 62, 89));
        totalPetCares.setText("999");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/pet-friendly2-65.png"))); // NOI18N

        javax.swing.GroupLayout panelRounded5Layout = new javax.swing.GroupLayout(panelRounded5);
        panelRounded5.setLayout(panelRounded5Layout);
        panelRounded5Layout.setHorizontalGroup(
            panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(519, Short.MAX_VALUE))
                    .addGroup(panelRounded5Layout.createSequentialGroup()
                        .addComponent(totalPetCares)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(20, 20, 20))))
        );
        panelRounded5Layout.setVerticalGroup(
            panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(panelRounded5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(8, 8, 8)
                        .addComponent(totalPetCares)))
                .addGap(20, 20, 20))
        );

        gridPanel.add(panelRounded5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1195, 1195, 1195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gridPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private petshop.custom.PanelRounded panelRounded2;
    private petshop.custom.PanelRounded panelRounded3;
    private petshop.custom.PanelRounded panelRounded5;
    private javax.swing.JLabel totalCustomers;
    private javax.swing.JLabel totalPetCares;
    private javax.swing.JLabel totalPets;
    // End of variables declaration//GEN-END:variables
}
