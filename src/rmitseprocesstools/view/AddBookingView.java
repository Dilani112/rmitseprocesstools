package rmitseprocesstools.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import rmitseprocesstools.controller.BussinessOwnerController;
import rmitseprocesstools.controller.BookingController;
import rmitseprocesstools.model.Booking;
import rmitseprocesstools.model.BookingStatus;
import javax.swing.JOptionPane;


public class AddBookingView extends javax.swing.JFrame {

    public AddBookingView() {
        initComponents();
        setCmbCustomerListValues();
        setCmbDateTimeListValues(); 
    }

    public final void setCmbCustomerListValues()
    {
       List<String> list = BookingController.setCustomerNameList();
        
       list.forEach((name) -> {
           cmbCustomerList.addItem(name);
        });     
    } 
    
    public final void setCmbDateTimeListValues()
    {
       List<String> list = BookingController.setScheDuleTimeListValues();
        
       list.forEach((schedule) -> {
           cmbDateTimeList.addItem(schedule);
        });     
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
        cmbDateTimeList = new javax.swing.JComboBox<>();
        btnConfirmBooking = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbCustomerList = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelBooking.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle.setText("                  Booking Form");

        lblName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblName.setText("Name ");

        lblPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhone.setText("Phone");

        txtPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lblPreferred.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPreferred.setText("Available Date/Time");

        cmbDateTimeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDateTimeListActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelBookingLayout = new javax.swing.GroupLayout(panelBooking);
        panelBooking.setLayout(panelBookingLayout);
        panelBookingLayout.setHorizontalGroup(
            panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookingLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBookingLayout.createSequentialGroup()
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhone)
                            .addComponent(lblName)
                            .addComponent(lblPreferred))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhone)
                            .addComponent(cmbCustomerList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDateTimeList, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBookingLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirmBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)))
                .addGap(19, 19, 19))
        );
        panelBookingLayout.setVerticalGroup(
            panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(26, 26, 26)
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblName)
                    .addComponent(cmbCustomerList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBookingLayout.createSequentialGroup()
                        .addComponent(lblPhone)
                        .addGap(19, 19, 19)
                        .addComponent(lblPreferred))
                    .addGroup(panelBookingLayout.createSequentialGroup()
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cmbDateTimeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmBooking)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnConfirmBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmBookingActionPerformed
        BookingController controller = new BookingController();
        String name = this.cmbCustomerList.getSelectedItem().toString();
        controller.saveBookingMade(name, name, name, BookingStatus.CONFIRMED);
       
    }//GEN-LAST:event_btnConfirmBookingActionPerformed

    private void cmbDateTimeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDateTimeListActionPerformed

    }//GEN-LAST:event_cmbDateTimeListActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try {
           BussinessOwnerController view = new BussinessOwnerController();     
           view.displayBussinessOwnerOperationsView();
           this.setVisible(false);                
            
        } catch (Exception er) {
            
            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cmbCustomerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerListActionPerformed
       
        String name = this.cmbCustomerList.getSelectedItem().toString();
        BookingController controller = new BookingController();
        txtPhone.setText(controller.getCustomerPhoneByName(name));
        
    }//GEN-LAST:event_cmbCustomerListActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void cmbCustomerListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerListItemStateChanged
        
    }//GEN-LAST:event_cmbCustomerListItemStateChanged

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
    private javax.swing.JComboBox cmbCustomerList;
    private javax.swing.JComboBox<String> cmbDateTimeList;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPreferred;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBooking;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
