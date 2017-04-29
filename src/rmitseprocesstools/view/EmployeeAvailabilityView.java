package rmitseprocesstools.view;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rmitseprocesstools.controller.*;
import rmitseprocesstools.model.WorkTime;


public class EmployeeAvailabilityView extends javax.swing.JFrame {

    public EmployeeAvailabilityView() {
        initComponents();
        setCmbEmployeeListValues();
        setCmbEmployeeAvailabilityList();
    }

    public final void setCmbEmployeeListValues()
    {
       EmployeeController controller = new EmployeeController();
        List<String> list = controller.constructCmbEmployeeListbyBusinessId();
        
       list.forEach((name) -> {
           cmbEmployeeList.addItem(name);
        });     
    }
    
    public final void setCmbEmployeeAvailabilityList()
    {
       List <WorkTime> list = new ArrayList();
       
       String text = this.cmbEmployeeList.getSelectedItem().toString();
       String [] temp = text.split("\\s+") ;
       
       list = EmployeeController.viewEmployeeAvailability(Integer.parseInt(temp[4].trim()));        
       
       
        DefaultTableModel model = new DefaultTableModel(new Object[]{"WorkTime ID","Date","Start","Finish"}, 0);
        if(!list.isEmpty()){
            
            for(WorkTime workTime:list){
             model.addRow(new Object[]{
                 workTime.WorkTimeId,
                 workTime.EndDateTime.format(DateTimeFormatter.ISO_DATE),
                 workTime.StartDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME),
                 workTime.StartDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME),
                 });
             }
        }
        
        
        tblEmployeeAvailability.setModel(model);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEmployeeAvailability = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblEmployeeList = new javax.swing.JLabel();
        cmbEmployeeList = new javax.swing.JComboBox<>();
        scrollpanelEmployeeTable = new javax.swing.JScrollPane();
        tblEmployeeAvailability = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelEmployeeAvailability.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Employee Availability");

        lblEmployeeList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmployeeList.setText("Employee Name");

        cmbEmployeeList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbEmployeeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmployeeListActionPerformed(evt);
            }
        });

        tblEmployeeAvailability.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblEmployeeAvailability.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollpanelEmployeeTable.setViewportView(tblEmployeeAvailability);

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEmployeeAvailabilityLayout = new javax.swing.GroupLayout(panelEmployeeAvailability);
        panelEmployeeAvailability.setLayout(panelEmployeeAvailabilityLayout);
        panelEmployeeAvailabilityLayout.setHorizontalGroup(
            panelEmployeeAvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeAvailabilityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmployeeAvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmployeeAvailabilityLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addComponent(scrollpanelEmployeeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelEmployeeAvailabilityLayout.createSequentialGroup()
                        .addComponent(lblEmployeeList)
                        .addGap(36, 36, 36)
                        .addComponent(cmbEmployeeList, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelEmployeeAvailabilityLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(lblTitle)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelEmployeeAvailabilityLayout.setVerticalGroup(
            panelEmployeeAvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeAvailabilityLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle)
                .addGap(40, 40, 40)
                .addGroup(panelEmployeeAvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeList)
                    .addComponent(cmbEmployeeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollpanelEmployeeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEmployeeAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEmployeeAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try {
           BussinessOwnerOperationsView view = new BussinessOwnerOperationsView();     
           view.setVisible(true);
           this.setVisible(false);                
            
        } catch (Exception er) {
            
            JOptionPane.showMessageDialog(null,er.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cmbEmployeeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmployeeListActionPerformed
        setCmbEmployeeAvailabilityList();
    }//GEN-LAST:event_cmbEmployeeListActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeAvailabilityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeAvailabilityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeAvailabilityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeAvailabilityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeAvailabilityView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cmbEmployeeList;
    private javax.swing.JLabel lblEmployeeList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelEmployeeAvailability;
    private javax.swing.JScrollPane scrollpanelEmployeeTable;
    private javax.swing.JTable tblEmployeeAvailability;
    // End of variables declaration//GEN-END:variables
}
