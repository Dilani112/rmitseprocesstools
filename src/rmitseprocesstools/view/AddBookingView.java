package rmitseprocesstools.view;

import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;
import rmitseprocesstools.controller.BussinessOwnerController;
import rmitseprocesstools.controller.BookingController;
import javax.swing.JOptionPane;


public class AddBookingView extends javax.swing.JFrame {

    public AddBookingView() {
        
        BookingController controller = new BookingController();
        
        initComponents();
        
        controller.populateBookingCustomerDetails(cmbCustomerList,txtPhone,txtAddress,true);
        controller.populateBookingBusinessDetails(cmbBusinessList);  
        controller.populateBookingAvailableDates(cmbDateList);
        controller.populateBookingTimes(jstAvailableTimes);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBooking = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblPreferred = new javax.swing.JLabel();
        btnConfirmBooking = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbCustomerList = new javax.swing.JComboBox();
        lblDates = new javax.swing.JLabel();
        cmbDateList = new javax.swing.JComboBox<>();
        cmbBusinessList = new javax.swing.JComboBox<>();
        lblBusiness = new javax.swing.JLabel();
        cmbActivity = new javax.swing.JComboBox<>();
        lblActivity = new javax.swing.JLabel();
        lblAvailableEmployees = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jspAvailabletimes = new javax.swing.JScrollPane();
        jstAvailableTimes = new javax.swing.JList<>();
        cmbAvailableEmployees = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelBooking.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Booking Form");

        lblName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblName.setText("Name ");

        lblPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhone.setText("Phone");

        txtPhone.setEditable(false);
        txtPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPhone.setRequestFocusEnabled(false);
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        lblPreferred.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPreferred.setText("Available Times");

        btnConfirmBooking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConfirmBooking.setText("Confirm booking");
        btnConfirmBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmBookingActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cmbCustomerList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbCustomerList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerListItemStateChanged(evt);
            }
        });
        cmbCustomerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerListActionPerformed(evt);
            }
        });

        lblDates.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDates.setText("Available Dates");

        cmbDateList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbDateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDateListActionPerformed(evt);
            }
        });

        cmbBusinessList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBusinessListActionPerformed(evt);
            }
        });

        lblBusiness.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBusiness.setText("Business");

        lblActivity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblActivity.setText("Activity");

        lblAvailableEmployees.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAvailableEmployees.setText("<html>Available</br>\nEmployees</html>");

        lblAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAddress.setText("Address");

        txtAddress.setEditable(false);
        txtAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jspAvailabletimes.setViewportView(jstAvailableTimes);

        cmbAvailableEmployees.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbAvailableEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAvailableEmployeesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBookingLayout = new javax.swing.GroupLayout(panelBooking);
        panelBooking.setLayout(panelBookingLayout);
        panelBookingLayout.setHorizontalGroup(
            panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookingLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBookingLayout.createSequentialGroup()
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDates)
                            .addComponent(lblBusiness)
                            .addComponent(lblActivity)
                            .addComponent(lblAvailableEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress)
                            .addComponent(lblName)
                            .addComponent(lblPhone))
                        .addGap(10, 10, 10)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress)
                            .addGroup(panelBookingLayout.createSequentialGroup()
                                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbDateList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbBusinessList, 0, 407, Short.MAX_VALUE)
                                    .addComponent(cmbActivity, 0, 407, Short.MAX_VALUE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbAvailableEmployees, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCustomerList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBookingLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(lblPreferred))
                            .addGroup(panelBookingLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jspAvailabletimes, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookingLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        panelBookingLayout.setVerticalGroup(
            panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBookingLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPreferred)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jspAvailabletimes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBookingLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(33, 33, 33)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbCustomerList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone))
                        .addGap(35, 35, 35)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbBusinessList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBusiness))
                        .addGap(18, 18, 18)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDates))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBookingLayout.createSequentialGroup()
                                .addComponent(lblActivity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAvailableEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBookingLayout.createSequentialGroup()
                                .addComponent(cmbActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(cmbAvailableEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConfirmBooking))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void cmbAvailableEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAvailableEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAvailableEmployeesActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void cmbBusinessListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBusinessListActionPerformed
        BookingController controller = new BookingController();
        controller.populateBookingEmployeeDetails(cmbBusinessList,cmbAvailableEmployees);
        controller.populateBookingActivityDetails(cmbBusinessList,cmbActivity);
    }//GEN-LAST:event_cmbBusinessListActionPerformed

    private void cmbDateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDateListActionPerformed

        /*jstAvailableTimes.removeAll();
        populateBookingTimes(jstAvailableTimes);
        setCmbTimeListValues(cmbDateList.getSelectedItem().toString());*/
    }//GEN-LAST:event_cmbDateListActionPerformed

    private void cmbCustomerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerListActionPerformed
        
        BookingController controller = new BookingController(); 
        controller.populateBookingCustomerDetails(cmbCustomerList,txtPhone,txtAddress,false);
    }//GEN-LAST:event_cmbCustomerListActionPerformed

    private void cmbCustomerListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerListItemStateChanged

    }//GEN-LAST:event_cmbCustomerListItemStateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        
        BookingController controller = new BookingController();
        
        if(controller.btnCancel())
        {
            try {
                CustomerOperationsView view = new CustomerOperationsView();
                view.setVisible(true);
                this.setVisible(false);

            } catch (Exception er) {

                JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            try {
                BussinessOwnerOperationsView view = new BussinessOwnerOperationsView();
                view.setVisible(true);
                this.setVisible(false);

            } catch (Exception er) {

                JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
            }
        }
            
       
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnConfirmBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmBookingActionPerformed

       /* BookingController controller = new BookingController();
        List<String> list = BookingController.setScheDuleTimeListValues(cmbDateList.getSelectedItem().toString());

        String text = this.cmbCustomerList.getSelectedItem().toString();
        String [] temp = text.split("\\s+") ;

        String text1 = this.jstAvailableTimes.getSelectedValue();
        list.forEach((item) -> {

            String [] temp1 = item.split("\\s+");
            String text3 = temp1[0].trim()+" "+temp1[1].trim()+" "+temp1[2].trim()+" "+temp1[3].trim()+" "+temp1[4].trim();

            if(text1.equals(text3))
            {
                controller.saveBookingMade(Integer.parseInt(temp[3].trim()),Integer.parseInt(temp1[5].trim()),cmbDateList.getSelectedItem().toString());
            }
        });*/
    }//GEN-LAST:event_btnConfirmBookingActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddBookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AddBookingView().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirmBooking;
    private javax.swing.JComboBox<String> cmbActivity;
    private javax.swing.JComboBox<String> cmbAvailableEmployees;
    private javax.swing.JComboBox<String> cmbBusinessList;
    private javax.swing.JComboBox cmbCustomerList;
    private javax.swing.JComboBox<String> cmbDateList;
    private javax.swing.JScrollPane jspAvailabletimes;
    private javax.swing.JList<String> jstAvailableTimes;
    private javax.swing.JLabel lblActivity;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAvailableEmployees;
    private javax.swing.JLabel lblBusiness;
    private javax.swing.JLabel lblDates;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPreferred;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBooking;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
