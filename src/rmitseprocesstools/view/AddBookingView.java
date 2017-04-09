package rmitseprocesstools.view;

import java.util.List;
import rmitseprocesstools.controller.BussinessOwnerController;
import rmitseprocesstools.controller.BookingController;
import javax.swing.JOptionPane;


public class AddBookingView extends javax.swing.JFrame {

    public AddBookingView() {
        initComponents();
        setCmbCustomerListValues();
        setCmbDateListValues(); 
        
    }

    public final void setCmbCustomerListValues()
    {
       List<String> list = BookingController.setCustomerNameList();
        
       list.forEach((name) -> {
           cmbCustomerList.addItem(name);
        });     
    }
    
    public final void setCmbDateListValues()
    {
       List<String> list = BookingController.setScheDuleDateListValues();
        
       list.forEach((item) -> {
           cmbDateList.addItem(item);
        });     
    }

    
    public final void setCmbTimeListValues(String selectedDateListValue)
    {
       List<String> list = BookingController.setScheDuleTimeListValues(selectedDateListValue);
        
       list.forEach((item) -> {
           
           String [] temp = item.split("\\s+");
           cmbTimeList.addItem(temp[0].trim()+" "+temp[1].trim()+" "+temp[2].trim()+" "+temp[3].trim()+" "+temp[4].trim());
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
        cmbTimeList = new javax.swing.JComboBox<>();
        btnConfirmBooking = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbCustomerList = new javax.swing.JComboBox();
        lblDates = new javax.swing.JLabel();
        cmbDateList = new javax.swing.JComboBox<>();

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

        txtPhone.setEditable(false);
        txtPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lblPreferred.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPreferred.setText("Available Times");

        cmbTimeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTimeListActionPerformed(evt);
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

        lblDates.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDates.setText("Available Date");

        cmbDateList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbDateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDateListActionPerformed(evt);
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
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDates)
                    .addComponent(lblName)
                    .addComponent(lblPhone)
                    .addComponent(lblPreferred))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookingLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnConfirmBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(panelBookingLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDateList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPhone)
                                .addComponent(cmbCustomerList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbTimeList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBookingLayout.createSequentialGroup()
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbDateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDates))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTimeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreferred))
                .addGap(26, 26, 26)
                .addGroup(panelBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConfirmBooking))
                .addContainerGap())
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
                .addComponent(panelBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmBookingActionPerformed
       
        BookingController controller = new BookingController();
        List<String> list = BookingController.setScheDuleTimeListValues(cmbDateList.getSelectedItem().toString());
        
        String text = this.cmbCustomerList.getSelectedItem().toString();
        String [] temp = text.split("\\s+") ;
               
        String text1 = this.cmbTimeList.getSelectedItem().toString();
        list.forEach((item) -> {
           
            String [] temp1 = item.split("\\s+");
            String text3 = temp1[0].trim()+" "+temp1[1].trim()+" "+temp1[2].trim()+" "+temp1[3].trim()+" "+temp1[4].trim();
            
            if(text1.equals(text3))
            {                 
                controller.saveBookingMade(Integer.parseInt(temp[3].trim()),Integer.parseInt(temp1[5].trim()),cmbDateList.getSelectedItem().toString()); 
            }
        });
        
    }//GEN-LAST:event_btnConfirmBookingActionPerformed

    private void cmbTimeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTimeListActionPerformed

        
    }//GEN-LAST:event_cmbTimeListActionPerformed

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
       
        String text = this.cmbCustomerList.getSelectedItem().toString();
        String [] temp = text.split("\\s+") ;
        BookingController controller = new BookingController();
        txtPhone.setText(controller.getCustomerPhoneById(temp[3].trim()));
    }//GEN-LAST:event_cmbCustomerListActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void cmbCustomerListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerListItemStateChanged
        
    }//GEN-LAST:event_cmbCustomerListItemStateChanged

    private void cmbDateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDateListActionPerformed
        
        cmbTimeList.removeAllItems();
        setCmbTimeListValues(cmbDateList.getSelectedItem().toString());
        
    }//GEN-LAST:event_cmbDateListActionPerformed

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
    private javax.swing.JComboBox<String> cmbDateList;
    private javax.swing.JComboBox<String> cmbTimeList;
    private javax.swing.JLabel lblDates;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPreferred;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBooking;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
