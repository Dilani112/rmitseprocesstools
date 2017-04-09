package rmitseprocesstools.view;

import rmitseprocesstools.controller.*;


public class EmployeeAvailabilityView extends javax.swing.JFrame {

    public EmployeeAvailabilityView() {
        initComponents();
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

        javax.swing.GroupLayout panelEmployeeAvailabilityLayout = new javax.swing.GroupLayout(panelEmployeeAvailability);
        panelEmployeeAvailability.setLayout(panelEmployeeAvailabilityLayout);
        panelEmployeeAvailabilityLayout.setHorizontalGroup(
            panelEmployeeAvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeAvailabilityLayout.createSequentialGroup()
                .addGroup(panelEmployeeAvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEmployeeAvailabilityLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollpanelEmployeeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmployeeAvailabilityLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEmployeeList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbEmployeeList, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmployeeAvailabilityLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEmployeeAvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmployeeAvailabilityLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmployeeAvailabilityLayout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addContainerGap())))
        );
        panelEmployeeAvailabilityLayout.setVerticalGroup(
            panelEmployeeAvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeAvailabilityLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitle)
                .addGap(38, 38, 38)
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
                .addComponent(panelEmployeeAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEmployeeAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
