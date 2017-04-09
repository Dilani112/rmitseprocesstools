package rmitseprocesstools.view;

import rmitseprocesstools.controller.*;


public class AddWorkTimeView extends javax.swing.JFrame {

    public AddWorkTimeView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        lblFinishHrs = new javax.swing.JLabel();
        cmbEmployeeList = new javax.swing.JComboBox<>();
        cmbFinishMinsList = new javax.swing.JComboBox<>();
        lblDate = new javax.swing.JLabel();
        lblFinishMins = new javax.swing.JLabel();
        cmbDateList = new javax.swing.JComboBox<>();
        lblStartTime = new javax.swing.JLabel();
        cmbStartHoursList = new javax.swing.JComboBox<>();
        lblHrs = new javax.swing.JLabel();
        cmbStartMinsList = new javax.swing.JComboBox<>();
        lblMins = new javax.swing.JLabel();
        lblFinishTime = new javax.swing.JLabel();
        cmbFinishHoursList = new javax.swing.JComboBox<>();
        btnAddTime = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Employee Work Time");

        lblEmployeeName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmployeeName.setText("Employee Name");

        lblFinishHrs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFinishHrs.setText("Hrs");

        cmbEmployeeList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbEmployeeList.setToolTipText("Please select an employee");
        cmbEmployeeList.setName("cmbEmployeeList"); // NOI18N

        cmbFinishMinsList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDate.setText("Date");

        lblFinishMins.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFinishMins.setText("Mins");

        cmbDateList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbDateList.setToolTipText("Select the date");
        cmbDateList.setName("cmbDate"); // NOI18N

        lblStartTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStartTime.setText("Start Time");

        cmbStartHoursList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbStartHoursList.setName("cmbStartHours"); // NOI18N

        lblHrs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHrs.setText("Hrs");

        cmbStartMinsList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbStartMinsList.setName("cmbStartMins"); // NOI18N

        lblMins.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMins.setText("Mins");

        lblFinishTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFinishTime.setText("Finish Time");

        cmbFinishHoursList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbFinishHoursList.setName("cmbEndHours"); // NOI18N

        btnAddTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddTime.setText("Add Time");

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmployeeName)
                                    .addComponent(lblDate)
                                    .addComponent(lblStartTime)
                                    .addComponent(lblFinishTime))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbDateList, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEmployeeList, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbFinishHoursList, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbStartHoursList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblHrs)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbStartMinsList, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblFinishHrs)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbFinishMinsList, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFinishMins)
                                            .addComponent(lblMins)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(lblTitle)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitle)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEmployeeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployeeName))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(cmbDateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartTime)
                    .addComponent(cmbStartHoursList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHrs)
                    .addComponent(cmbStartMinsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMins))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinishTime)
                    .addComponent(cmbFinishHoursList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFinishHrs)
                    .addComponent(cmbFinishMinsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFinishMins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnAddTime))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(AddWorkTimeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddWorkTimeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddWorkTimeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddWorkTimeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddWorkTimeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTime;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cmbDateList;
    private javax.swing.JComboBox<String> cmbEmployeeList;
    private javax.swing.JComboBox<String> cmbFinishHoursList;
    private javax.swing.JComboBox<String> cmbFinishMinsList;
    private javax.swing.JComboBox<String> cmbStartHoursList;
    private javax.swing.JComboBox<String> cmbStartMinsList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblFinishHrs;
    private javax.swing.JLabel lblFinishMins;
    private javax.swing.JLabel lblFinishTime;
    private javax.swing.JLabel lblHrs;
    private javax.swing.JLabel lblMins;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}