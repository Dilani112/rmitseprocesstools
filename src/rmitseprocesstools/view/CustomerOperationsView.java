package rmitseprocesstools.view;

import rmitseprocesstools.controller.*;
import javax.swing.JOptionPane;
import rmitseprocesstools.model.User;


public class CustomerOperationsView extends javax.swing.JFrame {


    public CustomerOperationsView() {
        initComponents();
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelCustomerOperations = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        panelBookingManagement = new javax.swing.JPanel();
        lblBookingManagement = new javax.swing.JLabel();
        btnAddNewBooking = new javax.swing.JButton();
        btnViewBookingSummary = new javax.swing.JButton();
        btnCancelBooking = new javax.swing.JButton();
        btnTracking = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        panelPersonal = new javax.swing.JPanel();
        lblPersonalinfo = new javax.swing.JLabel();
        btnUpdateinfo = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Appointment Booking System - Bussiness Owner Operations");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(595, 330));
        setResizable(false);

        panelCustomerOperations.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelCustomerOperations.setPreferredSize(new java.awt.Dimension(555, 305));
        panelCustomerOperations.setRequestFocusEnabled(false);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Customer Operations");

        panelBookingManagement.setBackground(new java.awt.Color(204, 204, 204));

        lblBookingManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBookingManagement.setText("Booking Management");

        btnAddNewBooking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddNewBooking.setText("Make New Booking");
        btnAddNewBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewBookingActionPerformed(evt);
            }
        });

        btnViewBookingSummary.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnViewBookingSummary.setText("View Booking History");
        btnViewBookingSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBookingSummaryActionPerformed(evt);
            }
        });

        btnCancelBooking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelBooking.setText("Cancel Booking");
        btnCancelBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelBookingActionPerformed(evt);
            }
        });

        btnTracking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTracking.setText("Track Booking");

        javax.swing.GroupLayout panelBookingManagementLayout = new javax.swing.GroupLayout(panelBookingManagement);
        panelBookingManagement.setLayout(panelBookingManagementLayout);
        panelBookingManagementLayout.setHorizontalGroup(
            panelBookingManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookingManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBookingManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addGroup(panelBookingManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTracking)
                    .addComponent(btnCancelBooking)
                    .addComponent(btnAddNewBooking)
                    .addComponent(btnViewBookingSummary))
                .addGap(26, 26, 26))
        );
        panelBookingManagementLayout.setVerticalGroup(
            panelBookingManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookingManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookingManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBookingManagement)
                    .addComponent(btnAddNewBooking))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelBooking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTracking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewBookingSummary)
                .addContainerGap())
        );

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogout.setText("Log out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        panelPersonal.setBackground(new java.awt.Color(204, 204, 204));

        lblPersonalinfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPersonalinfo.setText("Personal Info Management");

        btnUpdateinfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateinfo.setText("Update Info");
        btnUpdateinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateinfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPersonalLayout = new javax.swing.GroupLayout(panelPersonal);
        panelPersonal.setLayout(panelPersonalLayout);
        panelPersonalLayout.setHorizontalGroup(
            panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPersonalinfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateinfo)
                .addGap(81, 81, 81))
        );
        panelPersonalLayout.setVerticalGroup(
            panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPersonalinfo)
                    .addComponent(btnUpdateinfo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCustomerOperationsLayout = new javax.swing.GroupLayout(panelCustomerOperations);
        panelCustomerOperations.setLayout(panelCustomerOperationsLayout);
        panelCustomerOperationsLayout.setHorizontalGroup(
            panelCustomerOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustomerOperationsLayout.createSequentialGroup()
                .addGroup(panelCustomerOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerOperationsLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblTitle))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerOperationsLayout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(btnLogout))
                    .addGroup(panelCustomerOperationsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelCustomerOperationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBookingManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCustomerOperationsLayout.setVerticalGroup(
            panelCustomerOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustomerOperationsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(20, 20, 20)
                .addComponent(panelPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBookingManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCustomerOperations, 562, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCustomerOperations, javax.swing.GroupLayout.PREFERRED_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCustomerOperations.getAccessibleContext().setAccessibleName("");
        panelCustomerOperations.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewBookingActionPerformed
        try {
           AddBookingView view = new AddBookingView();
           view.setVisible(true);
           this.setVisible(false);                
            
        } catch (Exception er) {
            
            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddNewBookingActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        try {
            AuthController controller= new AuthController();
            LoginView view = new LoginView(); 
            
           if(controller.logout())
           {
                view.setVisible(true);
                this.setVisible(false);
           }                          
            
        } catch (Exception er) {

            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewBookingSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBookingSummaryActionPerformed
        try {
           BookingSummaryView view = new BookingSummaryView();     
           view.setVisible(true);
           this.setVisible(false);                
            
        } catch (Exception er) {
            
            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnViewBookingSummaryActionPerformed

    private void btnCancelBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelBookingActionPerformed

    private void btnUpdateinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateinfoActionPerformed
        
        CustomerController controller = new CustomerController();
        controller.populateCustomerInfo();
        this.setVisible(false);

    }//GEN-LAST:event_btnUpdateinfoActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BussinessOwnerOperationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BussinessOwnerOperationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BussinessOwnerOperationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BussinessOwnerOperationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BussinessOwnerOperationsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewBooking;
    private javax.swing.JButton btnCancelBooking;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTracking;
    private javax.swing.JButton btnUpdateinfo;
    private javax.swing.JButton btnViewBookingSummary;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBookingManagement;
    private javax.swing.JLabel lblPersonalinfo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBookingManagement;
    private javax.swing.JPanel panelCustomerOperations;
    private javax.swing.JPanel panelPersonal;
    // End of variables declaration//GEN-END:variables
}
