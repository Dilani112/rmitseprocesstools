package rmitseprocesstools.view;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import rmitseprocesstools.controller.BookingController;
import rmitseprocesstools.controller.BussinessOwnerController;
import rmitseprocesstools.controller.EmployeeController;
import rmitseprocesstools.model.Booking;

public class BookingSummaryView extends javax.swing.JFrame {


    public BookingSummaryView() {
        initComponents();
        setTableBookingSummary();     
    }


    public final void setTableBookingSummary()
    {
       List <Booking> list = new ArrayList();
       list = BookingController.getBookingSummaryList(txtTitle);        
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Booking ID","Person ID","Status","Date","Start Time","End Time", "Activity"}, 0);
        for(Booking booking:list){
             model.addRow(new Object[]{
                 booking.getBookingId(),
                 BookingController.getCustomerNameById(booking.getPersonForId()),
                 booking.getStatus(),
                 booking.getBookingDate().format(DateTimeFormatter.ISO_DATE),
                 booking.getStartDateTime().format(DateTimeFormatter.ISO_TIME),
                 booking.getEndDateTime().format(DateTimeFormatter.ISO_TIME),
                BookingController.GetBookingActivityName(booking.getBookingId())});
        }
        tblSummary.setModel(model);
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSummary = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        spanelSummary = new javax.swing.JScrollPane();
        tblSummary = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelSummary.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTitle.setText("Booking Summary");

        tblSummary.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSummary.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSummary.setEnabled(false);
        spanelSummary.setViewportView(tblSummary);

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSummaryLayout = new javax.swing.GroupLayout(panelSummary);
        panelSummary.setLayout(panelSummaryLayout);
        panelSummaryLayout.setHorizontalGroup(
            panelSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSummaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spanelSummary, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSummaryLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)))
                .addContainerGap())
            .addGroup(panelSummaryLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(txtTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSummaryLayout.setVerticalGroup(
            panelSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSummaryLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtTitle)
                .addGap(18, 18, 18)
                .addComponent(spanelSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingSummaryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JPanel panelSummary;
    private javax.swing.JScrollPane spanelSummary;
    private javax.swing.JTable tblSummary;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
