/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package petshop;

import com.formdev.flatlaf.FlatIntelliJLaf;

import petshop.form.DashboardForm;
import petshop.form.MembershipForm;
import petshop.form.PetForm;
import petshop.form.CustomerForm;

import java.awt.Color;

import javax.swing.ImageIcon;


/**
 *
 * @author Ryan Rizky
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        
        initComponents();

        DashboardForm dashboardForm = new DashboardForm();
        bodyPanel.removeAll();
        bodyPanel.add(dashboardForm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SideBar = new javax.swing.JPanel();
        mainIcon1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dashboardIcon = new petshop.custom.PanelRounded();
        jLabel6 = new javax.swing.JLabel();
        userIcon = new petshop.custom.PanelRounded();
        jLabel7 = new javax.swing.JLabel();
        petCareIcon = new petshop.custom.PanelRounded();
        jLabel8 = new javax.swing.JLabel();
        transactionIcon = new petshop.custom.PanelRounded();
        jLabel9 = new javax.swing.JLabel();
        memberIcon = new petshop.custom.PanelRounded();
        jLabel10 = new javax.swing.JLabel();
        settingIcon = new petshop.custom.PanelRounded();
        jLabel11 = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        NavBar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SideBar.setBackground(new java.awt.Color(255, 255, 255));

        mainIcon1.setBackground(new java.awt.Color(255, 255, 255));
        mainIcon1.setPreferredSize(new java.awt.Dimension(60, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/paw-custom (1).png"))); // NOI18N

        javax.swing.GroupLayout mainIcon1Layout = new javax.swing.GroupLayout(mainIcon1);
        mainIcon1.setLayout(mainIcon1Layout);
        mainIcon1Layout.setHorizontalGroup(
            mainIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainIcon1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(10, 10, 10))
        );
        mainIcon1Layout.setVerticalGroup(
            mainIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainIcon1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        dashboardIcon.setBackground(new java.awt.Color(239, 246, 255));
        dashboardIcon.setPreferredSize(new java.awt.Dimension(60, 60));
        dashboardIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardIconMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/dashboard-custom.png"))); // NOI18N

        javax.swing.GroupLayout dashboardIconLayout = new javax.swing.GroupLayout(dashboardIcon);
        dashboardIcon.setLayout(dashboardIconLayout);
        dashboardIconLayout.setHorizontalGroup(
            dashboardIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardIconLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(10, 10, 10))
        );
        dashboardIconLayout.setVerticalGroup(
            dashboardIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardIconLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        userIcon.setBackground(new java.awt.Color(255, 255, 255));
        userIcon.setPreferredSize(new java.awt.Dimension(60, 60));
        userIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userIconMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/account-box-normal.png"))); // NOI18N

        javax.swing.GroupLayout userIconLayout = new javax.swing.GroupLayout(userIcon);
        userIcon.setLayout(userIconLayout);
        userIconLayout.setHorizontalGroup(
            userIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userIconLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(10, 10, 10))
        );
        userIconLayout.setVerticalGroup(
            userIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userIconLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        petCareIcon.setBackground(new java.awt.Color(255, 255, 255));
        petCareIcon.setMinimumSize(new java.awt.Dimension(60, 60));
        petCareIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petCareIconMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/home-variant-normal.png"))); // NOI18N

        javax.swing.GroupLayout petCareIconLayout = new javax.swing.GroupLayout(petCareIcon);
        petCareIcon.setLayout(petCareIconLayout);
        petCareIconLayout.setHorizontalGroup(
            petCareIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, petCareIconLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(10, 10, 10))
        );
        petCareIconLayout.setVerticalGroup(
            petCareIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(petCareIconLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        transactionIcon.setBackground(new java.awt.Color(255, 255, 255));
        transactionIcon.setMinimumSize(new java.awt.Dimension(60, 60));
        transactionIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionIconMouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/point-of-sale-normal.png"))); // NOI18N

        javax.swing.GroupLayout transactionIconLayout = new javax.swing.GroupLayout(transactionIcon);
        transactionIcon.setLayout(transactionIconLayout);
        transactionIconLayout.setHorizontalGroup(
            transactionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionIconLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(10, 10, 10))
        );
        transactionIconLayout.setVerticalGroup(
            transactionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionIconLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        memberIcon.setBackground(new java.awt.Color(255, 255, 255));
        memberIcon.setMinimumSize(new java.awt.Dimension(60, 60));
        memberIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberIconMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/card-account-details-normal.png"))); // NOI18N

        javax.swing.GroupLayout memberIconLayout = new javax.swing.GroupLayout(memberIcon);
        memberIcon.setLayout(memberIconLayout);
        memberIconLayout.setHorizontalGroup(
            memberIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, memberIconLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(10, 10, 10))
        );
        memberIconLayout.setVerticalGroup(
            memberIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberIconLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        settingIcon.setBackground(new java.awt.Color(255, 255, 255));
        settingIcon.setMinimumSize(new java.awt.Dimension(60, 60));
        settingIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingIconMouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/icon/cog-normal.png"))); // NOI18N

        javax.swing.GroupLayout settingIconLayout = new javax.swing.GroupLayout(settingIcon);
        settingIcon.setLayout(settingIconLayout);
        settingIconLayout.setHorizontalGroup(
            settingIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingIconLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(10, 10, 10))
        );
        settingIconLayout.setVerticalGroup(
            settingIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingIconLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SideBarLayout = new javax.swing.GroupLayout(SideBar);
        SideBar.setLayout(SideBarLayout);
        SideBarLayout.setHorizontalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SideBarLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(settingIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transactionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(petCareIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        SideBarLayout.setVerticalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(mainIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(dashboardIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(petCareIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(transactionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(memberIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(settingIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        bodyPanel.setBackground(new java.awt.Color(238, 240, 244));
        bodyPanel.setLayout(new java.awt.BorderLayout());

        NavBar.setBackground(new java.awt.Color(255, 255, 255));
        NavBar.setPreferredSize(new java.awt.Dimension(100, 66));

        javax.swing.GroupLayout NavBarLayout = new javax.swing.GroupLayout(NavBar);
        NavBar.setLayout(NavBarLayout);
        NavBarLayout.setHorizontalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        NavBarLayout.setVerticalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(SideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1398, Short.MAX_VALUE)
                    .addComponent(NavBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1398, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean dashIconClicked = true;
    private boolean userIconClicked = false;
    private boolean petCareIconClicked = false;
    private boolean saleIconClicked = false;
    private boolean memberIconClicked = false;
    private boolean settingIconClicked = false;

    private void dashboardIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardIconMouseClicked
        ImageIcon imageNormal = new ImageIcon(getClass().getResource("/petshop/icon/dashboard-normal.png"));
        ImageIcon imageClicked = new ImageIcon(getClass().getResource("/petshop/icon/dashboard-custom.png"));
        ImageIcon userNormal = new ImageIcon(getClass().getResource("/petshop/icon/account-box-normal.png"));
        ImageIcon petCareNormal = new ImageIcon(getClass().getResource("/petshop/icon/home-variant-normal.png"));
        ImageIcon saleNormal = new ImageIcon(getClass().getResource("/petshop/icon/point-of-sale-normal.png"));
        ImageIcon memberNormal = new ImageIcon(getClass().getResource("/petshop/icon/card-account-details-normal.png"));
        ImageIcon settingNormal = new ImageIcon(getClass().getResource("/petshop/icon/cog-normal.png"));

        if (dashIconClicked) {
            dashIconClicked = false;
            dashboardIcon.setBackground(new Color(255,255,255));
            jLabel6.setIcon(imageNormal);
        } else {
            dashIconClicked = true;
            dashboardIcon.setBackground(new Color(239,246,255));
            jLabel6.setIcon(imageClicked);
        }

        userIconClicked = false;
        userIcon.setBackground(new Color(255,255,255));
        jLabel7.setIcon(userNormal);

        petCareIconClicked = false;
        petCareIcon.setBackground(new Color(255,255,255));
        jLabel8.setIcon(petCareNormal);

        saleIconClicked = false;
        transactionIcon.setBackground(new Color(255,255,255));
        jLabel9.setIcon(saleNormal);

        memberIconClicked = false;
        memberIcon.setBackground(new Color(255,255,255));
        jLabel10.setIcon(memberNormal);

        settingIconClicked = false;
        settingIcon.setBackground(new Color(255,255,255));
        jLabel11.setIcon(settingNormal);

        DashboardForm dashboardForm = new DashboardForm();
        bodyPanel.removeAll();
        bodyPanel.add(dashboardForm);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_dashboardIconMouseClicked

    private void userIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userIconMouseClicked
        ImageIcon imageNormal = new ImageIcon(getClass().getResource("/petshop/icon/account-box-custom.png"));
        ImageIcon imageClicked = new ImageIcon(getClass().getResource("/petshop/icon/account-box-normal.png"));
        ImageIcon dashNormal = new ImageIcon(getClass().getResource("/petshop/icon/dashboard-normal.png"));
        ImageIcon petCareNormal = new ImageIcon(getClass().getResource("/petshop/icon/home-variant-normal.png"));
        ImageIcon saleNormal = new ImageIcon(getClass().getResource("/petshop/icon/point-of-sale-normal.png"));
        ImageIcon memberNormal = new ImageIcon(getClass().getResource("/petshop/icon/card-account-details-normal.png"));
        ImageIcon settingNormal = new ImageIcon(getClass().getResource("/petshop/icon/cog-normal.png"));

        if (userIconClicked) {
            userIconClicked = false;
            userIcon.setBackground(new Color(255, 255, 255));
            jLabel7.setIcon(imageClicked);
        } else {
            userIconClicked = true;
            userIcon.setBackground(new Color(239, 246, 255));
            jLabel7.setIcon(imageNormal);
        }

        dashIconClicked = false;
        dashboardIcon.setBackground(new Color(255, 255, 255));
        jLabel6.setIcon(dashNormal);

        petCareIconClicked = false;
        petCareIcon.setBackground(new Color(255, 255, 255));
        jLabel8.setIcon(petCareNormal);

        saleIconClicked = false;
        transactionIcon.setBackground(new Color(255,255,255));
        jLabel9.setIcon(saleNormal);

        memberIconClicked = false;
        memberIcon.setBackground(new Color(255,255,255));
        jLabel10.setIcon(memberNormal);

        settingIconClicked = false;
        settingIcon.setBackground(new Color(255,255,255));
        jLabel11.setIcon(settingNormal);

        CustomerForm userForm = new CustomerForm();
        bodyPanel.removeAll();
        bodyPanel.add(userForm);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_userIconMouseClicked

    private void petCareIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petCareIconMouseClicked
        ImageIcon imageNormal = new ImageIcon(getClass().getResource("/petshop/icon/home-variant-custom.png"));
        ImageIcon imageClicked = new ImageIcon(getClass().getResource("/petshop/icon/home-variant-normal.png"));
        ImageIcon dashNormal = new ImageIcon(getClass().getResource("/petshop/icon/dashboard-normal.png"));
        ImageIcon userNormal = new ImageIcon(getClass().getResource("/petshop/icon/account-box-normal.png"));
        ImageIcon saleNormal = new ImageIcon(getClass().getResource("/petshop/icon/point-of-sale-normal.png"));
        ImageIcon memberNormal = new ImageIcon(getClass().getResource("/petshop/icon/card-account-details-normal.png"));
        ImageIcon settingNormal = new ImageIcon(getClass().getResource("/petshop/icon/cog-normal.png"));

        if (petCareIconClicked) {
            petCareIconClicked = false;
            petCareIcon.setBackground(new Color(255, 255, 255));
            jLabel8.setIcon(imageClicked);
        } else {
            petCareIconClicked = true;
            petCareIcon.setBackground(new Color(239, 246, 255));
            jLabel8.setIcon(imageNormal);
        }

        dashIconClicked = false;
        dashboardIcon.setBackground(new Color(255, 255, 255));
        jLabel6.setIcon(dashNormal);

        userIconClicked = false;
        userIcon.setBackground(new Color(255, 255, 255));
        jLabel7.setIcon(userNormal);

        saleIconClicked = false;
        transactionIcon.setBackground(new Color(255,255,255));
        jLabel9.setIcon(saleNormal);

        memberIconClicked = false;
        memberIcon.setBackground(new Color(255,255,255));
        jLabel10.setIcon(memberNormal);

        settingIconClicked = false;
        settingIcon.setBackground(new Color(255,255,255));
        jLabel11.setIcon(settingNormal);

        PetForm petCareForm = new PetForm();
        bodyPanel.removeAll();
        bodyPanel.add(petCareForm);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_petCareIconMouseClicked

    private void transactionIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionIconMouseClicked
        ImageIcon imageNormal = new ImageIcon(getClass().getResource("/petshop/icon/point-of-sale-custom.png"));
        ImageIcon imageClicked = new ImageIcon(getClass().getResource("/petshop/icon/point-of-sale-normal.png"));
        ImageIcon dashNormal = new ImageIcon(getClass().getResource("/petshop/icon/dashboard-normal.png"));
        ImageIcon userNormal = new ImageIcon(getClass().getResource("/petshop/icon/account-box-normal.png"));
        ImageIcon petCareNormal = new ImageIcon(getClass().getResource("/petshop/icon/home-variant-normal.png"));
        ImageIcon memberNormal = new ImageIcon(getClass().getResource("/petshop/icon/card-account-details-normal.png"));
        ImageIcon settingNormal = new ImageIcon(getClass().getResource("/petshop/icon/cog-normal.png"));

        if (saleIconClicked) {
            saleIconClicked = false;
            transactionIcon.setBackground(new Color(255, 255, 255));
            jLabel9.setIcon(imageClicked);
        } else {
            saleIconClicked = true;
            transactionIcon.setBackground(new Color(239, 246, 255));
            jLabel9.setIcon(imageNormal);
        }

        dashIconClicked = false;
        dashboardIcon.setBackground(new Color(255, 255, 255));
        jLabel6.setIcon(dashNormal);

        userIconClicked = false;
        userIcon.setBackground(new Color(255, 255, 255));
        jLabel7.setIcon(userNormal);

        petCareIconClicked = false;
        petCareIcon.setBackground(new Color(255, 255, 255));
        jLabel8.setIcon(petCareNormal);

        memberIconClicked = false;
        memberIcon.setBackground(new Color(255,255,255));
        jLabel10.setIcon(memberNormal);

        settingIconClicked = false;
        settingIcon.setBackground(new Color(255,255,255));
        jLabel11.setIcon(settingNormal);
    }//GEN-LAST:event_transactionIconMouseClicked

    private void memberIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberIconMouseClicked
        ImageIcon imageNormal = new ImageIcon(getClass().getResource("/petshop/icon/card-account-details-custom.png"));
        ImageIcon imageClicked = new ImageIcon(getClass().getResource("/petshop/icon/card-account-details-normal.png"));
        ImageIcon dashNormal = new ImageIcon(getClass().getResource("/petshop/icon/dashboard-normal.png"));
        ImageIcon userNormal = new ImageIcon(getClass().getResource("/petshop/icon/account-box-normal.png"));
        ImageIcon petCareNormal = new ImageIcon(getClass().getResource("/petshop/icon/home-variant-normal.png"));
        ImageIcon saleNormal = new ImageIcon(getClass().getResource("/petshop/icon/point-of-sale-normal.png"));
        ImageIcon settingNormal = new ImageIcon(getClass().getResource("/petshop/icon/cog-normal.png"));

        if (memberIconClicked) {
            memberIconClicked = false;
            memberIcon.setBackground(new Color(255, 255, 255));
            jLabel10.setIcon(imageClicked);
        } else {
            memberIconClicked = true;
            memberIcon.setBackground(new Color(239, 246, 255));
            jLabel10.setIcon(imageNormal);
        }

        dashIconClicked = false;
        dashboardIcon.setBackground(new Color(255, 255, 255));
        jLabel6.setIcon(dashNormal);

        userIconClicked = false;
        userIcon.setBackground(new Color(255, 255, 255));
        jLabel7.setIcon(userNormal);

        petCareIconClicked = false;
        petCareIcon.setBackground(new Color(255, 255, 255));
        jLabel8.setIcon(petCareNormal);

        saleIconClicked = false;
        transactionIcon.setBackground(new Color(255,255,255));
        jLabel9.setIcon(saleNormal);

        settingIconClicked = false;
        settingIcon.setBackground(new Color(255,255,255));
        jLabel11.setIcon(settingNormal);

        MembershipForm memberForm = new MembershipForm();
        bodyPanel.removeAll();
        bodyPanel.add(memberForm);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_memberIconMouseClicked

    private void settingIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingIconMouseClicked
        ImageIcon imageNormal = new ImageIcon(getClass().getResource("/petshop/icon/cog-custom.png"));
        ImageIcon imageClicked = new ImageIcon(getClass().getResource("/petshop/icon/cog-normal.png"));
        ImageIcon dashNormal = new ImageIcon(getClass().getResource("/petshop/icon/dashboard-normal.png"));
        ImageIcon userNormal = new ImageIcon(getClass().getResource("/petshop/icon/account-box-normal.png"));
        ImageIcon petCareNormal = new ImageIcon(getClass().getResource("/petshop/icon/home-variant-normal.png"));
        ImageIcon saleNormal = new ImageIcon(getClass().getResource("/petshop/icon/point-of-sale-normal.png"));
        ImageIcon memberNormal = new ImageIcon(getClass().getResource("/petshop/icon/card-account-details-normal.png"));

        if (settingIconClicked) {
            settingIconClicked = false;
            settingIcon.setBackground(new Color(255, 255, 255));
            jLabel11.setIcon(imageClicked);
        } else {
            settingIconClicked = true;
            settingIcon.setBackground(new Color(239, 246, 255));
            jLabel11.setIcon(imageNormal);
        }

        dashIconClicked = false;
        dashboardIcon.setBackground(new Color(255, 255, 255));
        jLabel6.setIcon(dashNormal);

        userIconClicked = false;
        userIcon.setBackground(new Color(255, 255, 255));
        jLabel7.setIcon(userNormal);

        petCareIconClicked = false;
        petCareIcon.setBackground(new Color(255, 255, 255));
        jLabel8.setIcon(petCareNormal);

        saleIconClicked = false;
        transactionIcon.setBackground(new Color(255,255,255));
        jLabel9.setIcon(saleNormal);

        memberIconClicked = false;
        memberIcon.setBackground(new Color(255,255,255));
        jLabel10.setIcon(memberNormal);
    }//GEN-LAST:event_settingIconMouseClicked

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
            FlatIntelliJLaf.registerCustomDefaultsSource("petshop.style");
            FlatIntelliJLaf.setup();
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NavBar;
    private javax.swing.JPanel SideBar;
    private javax.swing.JPanel bodyPanel;
    private petshop.custom.PanelRounded dashboardIcon;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel mainIcon1;
    private petshop.custom.PanelRounded memberIcon;
    private petshop.custom.PanelRounded petCareIcon;
    private petshop.custom.PanelRounded settingIcon;
    private petshop.custom.PanelRounded transactionIcon;
    private petshop.custom.PanelRounded userIcon;
    // End of variables declaration//GEN-END:variables
}
