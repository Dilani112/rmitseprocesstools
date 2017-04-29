package rmitseprocesstools.view;

import rmitseprocesstools.controller.*;
import javax.swing.JOptionPane;
import rmitseprocesstools.controller.BussinessOwnerController;


public class BussinessOwnerOperationsView extends javax.swing.JFrame {


    public BussinessOwnerOperationsView() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelBussinessOwnerOperations = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        panelBookingManagement = new javax.swing.JPanel();
        lblBookingManagement = new javax.swing.JLabel();
        btnAddNewBooking = new javax.swing.JButton();
        btnViewBookingSummary = new javax.swing.JButton();
        panelEmployeeManagement = new javax.swing.JPanel();
        btnAddWorkTimes = new javax.swing.JButton();
        btnAddEmployee = new javax.swing.JButton();
        btnViewEmployeeAvailability = new javax.swing.JButton();
        lblEmployeeManagement = new javax.swing.JLabel();
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
        setResizable(false);

        panelBussinessOwnerOperations.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Bussiness Owner Operations");

        panelBookingManagement.setBackground(new java.awt.Color(204, 204, 204));

        lblBookingManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBookingManagement.setText("Booking Management");

        btnAddNewBooking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddNewBooking.setText("Add New Booking");
        btnAddNewBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewBookingActionPerformed(evt);
            }
        });

        btnViewBookingSummary.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnViewBookingSummary.setText("View Booking Summary");
        btnViewBookingSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBookingSummaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBookingManagementLayout = new javax.swing.GroupLayout(panelBookingManagement);
        panelBookingManagement.setLayout(panelBookingManagementLayout);
        panelBookingManagementLayout.setHorizontalGroup(
            panelBookingManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookingManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBookingManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addGroup(panelBookingManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewBookingSummary)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelEmployeeManagement.setBackground(new java.awt.Color(204, 204, 204));

        btnAddWorkTimes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddWorkTimes.setText("Add Work Times");
        btnAddWorkTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWorkTimesActionPerformed(evt);
            }
        });

        btnAddEmployee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddEmployee.setText("Add Employee");
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        btnViewEmployeeAvailability.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnViewEmployeeAvailability.setText("View Employee Availability");
        btnViewEmployeeAvailability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEmployeeAvailabilityActionPerformed(evt);
            }
        });

        lblEmployeeManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmployeeManagement.setText("Employee Management");

        javax.swing.GroupLayout panelEmployeeManagementLayout = new javax.swing.GroupLayout(panelEmployeeManagement);
        panelEmployeeManagement.setLayout(panelEmployeeManagementLayout);
        panelEmployeeManagementLayout.setHorizontalGroup(
            panelEmployeeManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmployeeManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmployeeManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(panelEmployeeManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewEmployeeAvailability)
                    .addComponent(btnAddWorkTimes)
                    .addComponent(btnAddEmployee))
                .addContainerGap())
        );
        panelEmployeeManagementLayout.setVerticalGroup(
            panelEmployeeManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeManagementLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelEmployeeManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddEmployee)
                    .addComponent(lblEmployeeManagement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddWorkTimes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewEmployeeAvailability)
                .addGap(16, 16, 16))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(btnUpdateinfo)
                .addGap(94, 94, 94))
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

        javax.swing.GroupLayout panelBussinessOwnerOperationsLayout = new javax.swing.GroupLayout(panelBussinessOwnerOperations);
        panelBussinessOwnerOperations.setLayout(panelBussinessOwnerOperationsLayout);
        panelBussinessOwnerOperationsLayout.setHorizontalGroup(
            panelBussinessOwnerOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBussinessOwnerOperationsLayout.createSequentialGroup()
                .addGroup(panelBussinessOwnerOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBussinessOwnerOperationsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(panelBussinessOwnerOperationsLayout.createSequentialGroup()
                        .addGroup(panelBussinessOwnerOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBussinessOwnerOperationsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelEmployeeManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBussinessOwnerOperationsLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(lblTitle))
                            .addGroup(panelBussinessOwnerOperationsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelBookingManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelBussinessOwnerOperationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBussinessOwnerOperationsLayout.setVerticalGroup(
            panelBussinessOwnerOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBussinessOwnerOperationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(28, 28, 28)
                .addComponent(panelPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBookingManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelEmployeeManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBussinessOwnerOperations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBussinessOwnerOperations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBussinessOwnerOperations.getAccessibleContext().setAccessibleName("");
        panelBussinessOwnerOperations.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed
       try {
           AddEmployeeView view  = new AddEmployeeView();     
           view.setVisible(true);
           this.setVisible(false);                
            
        } catch (Exception er) {
            
            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAddEmployeeActionPerformed

    private void btnAddWorkTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWorkTimesActionPerformed
        try {
           AddWorkTimeView view = new AddWorkTimeView();     
           view.setVisible(true);
           this.setVisible(false);                
            
        } catch (Exception er) {
            
            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddWorkTimesActionPerformed

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
           AuthController controller = new AuthController(); 
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

    private void btnViewEmployeeAvailabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEmployeeAvailabilityActionPerformed
        try {
           EmployeeAvailabilityView view = new EmployeeAvailabilityView();     
           view.setVisible(true);
           this.setVisible(false);                
            
        } catch (Exception er) {
            
            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnViewEmployeeAvailabilityActionPerformed

    private void btnUpdateinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateinfoActionPerformed
        
        BussinessOwnerController controller = new BussinessOwnerController();
        controller.populateBusinessInfo();
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
    private javax.swing.JButton btnAddEmployee;
    private javax.swing.JButton btnAddNewBooking;
    private javax.swing.JButton btnAddWorkTimes;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdateinfo;
    private javax.swing.JButton btnViewBookingSummary;
    private javax.swing.JButton btnViewEmployeeAvailability;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBookingManagement;
    private javax.swing.JLabel lblEmployeeManagement;
    private javax.swing.JLabel lblPersonalinfo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBookingManagement;
    private javax.swing.JPanel panelBussinessOwnerOperations;
    private javax.swing.JPanel panelEmployeeManagement;
    private javax.swing.JPanel panelPersonal;
    // End of variables declaration//GEN-END:variables
}
