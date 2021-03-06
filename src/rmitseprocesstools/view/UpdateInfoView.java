/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitseprocesstools.view;

import javax.swing.JOptionPane;
import rmitseprocesstools.controller.CustomerController;
import rmitseprocesstools.controller.BussinessOwnerController;
/**
 *
 * @author sandamali
 */
public class UpdateInfoView extends javax.swing.JFrame {

    /**
     * Creates new form UpdateInfoView
     */
    public UpdateInfoView() {        
        
        initComponents();
        
        
    }
    
    public void defaultCustomerInfo(String name, String address,String phone,String q, String a)
    {
        txtName.setText(name);
        txtAddress.setText(address);
        txtPhone.setText(phone);
        cmbQuestion.setSelectedItem(q);
        txtAnswer.setText(a);
        lblBusinessName.setVisible(false);
        txtBusinessName.setVisible(false);
      
    }
    
    public void defaultBusinessInfo(String bname,String name, String address,String phone,String q, String a)
    {
        txtName.setText(name);
        txtAddress.setText(address);
        txtPhone.setText(phone);
        cmbQuestion.setSelectedItem(q);
        txtAnswer.setText(a);
        lblBusinessName.setVisible(true);
        txtBusinessName.setVisible(true);
        txtBusinessName.setText(bname);
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUpdateInfo = new javax.swing.JPanel();
        lblAddress = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        lblContactNumber = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        cmbQuestion = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAnswer = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        txtPhone = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtBusinessName = new javax.swing.JTextField();
        lblBusinessName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelUpdateInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAddress.setText("Address");

        txtAnswer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lblContactNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContactNumber.setText("Contact Number");

        txtAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        cmbQuestion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mother's Maiden Name?", "Your First Pets Name?", "Your Favourite Book?", "Your First School Teacher?" }));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblQuestion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQuestion.setText("Question");

        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblAnswer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAnswer.setText("Answer");

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Update Personal Info");

        lblName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblName.setText("Name");

        txtBusinessName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBusinessName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusinessNameActionPerformed(evt);
            }
        });

        lblBusinessName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBusinessName.setText("Business Name");

        javax.swing.GroupLayout panelUpdateInfoLayout = new javax.swing.GroupLayout(panelUpdateInfo);
        panelUpdateInfo.setLayout(panelUpdateInfoLayout);
        panelUpdateInfoLayout.setHorizontalGroup(
            panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUpdateInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addGap(3, 3, 3))
            .addGroup(panelUpdateInfoLayout.createSequentialGroup()
                .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUpdateInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addComponent(lblContactNumber)
                            .addComponent(lblQuestion)
                            .addComponent(lblAnswer)
                            .addComponent(lblName)
                            .addComponent(lblBusinessName))
                        .addGap(30, 30, 30)
                        .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusinessName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelUpdateInfoLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(lblTitle)))
                .addGap(2, 63, Short.MAX_VALUE))
        );
        panelUpdateInfoLayout.setVerticalGroup(
            panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUpdateInfoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGap(26, 26, 26)
                .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelUpdateInfoLayout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelUpdateInfoLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(18, 18, 18)
                        .addComponent(lblAddress)))
                .addGap(18, 18, 18)
                .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactNumber))
                .addGap(11, 11, 11)
                .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuestion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnswer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusinessName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBusinessName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelUpdateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUpdateInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        CustomerController controller = new CustomerController();
        BussinessOwnerController controllerb = new BussinessOwnerController();
        
        CustomerOperationsView view = new CustomerOperationsView();
        BussinessOwnerOperationsView viewb = new BussinessOwnerOperationsView();

        if(txtBusinessName.isVisible()){
            if(controllerb.updateBusinessOwnerInfo(txtBusinessName.getText(),
               txtName.getText(),txtAddress.getText(),txtPhone.getText().trim(),
               cmbQuestion.getSelectedItem().toString(),txtAnswer.getText())){

                JOptionPane.showMessageDialog(null,"Business data update successfull.","",
                        JOptionPane.INFORMATION_MESSAGE);
                viewb.setVisible(true);
                this.setVisible(false);

            }else{
                JOptionPane.showMessageDialog(null,"Business data update has failed.",
                    "",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            if(controller.updateCustomerInfo(txtName.getText(),
                txtAddress.getText(),txtPhone.getText().trim(),
                cmbQuestion.getSelectedItem().toString(),txtAnswer.getText())){

                JOptionPane.showMessageDialog(null,"Customer data update successfull.","",
                        JOptionPane.INFORMATION_MESSAGE);
                view.setVisible(true);
                this.setVisible(false);

            }else{
                JOptionPane.showMessageDialog(null,"Customer data update has failed",
                    "",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try {
            CustomerOperationsView view = new CustomerOperationsView();
            view.setVisible(true);
            this.setVisible(false);

        } catch (Exception er) {

            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtBusinessNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusinessNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusinessNameActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateInfoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateInfoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateInfoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateInfoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateInfoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbQuestion;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAnswer;
    private javax.swing.JLabel lblBusinessName;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelUpdateInfo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtBusinessName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
