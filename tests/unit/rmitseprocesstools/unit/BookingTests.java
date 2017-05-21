package rmitseprocesstools.unit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.controller.BookingController;
import rmitseprocesstools.controller.EmployeeController;
import rmitseprocesstools.model.Booking;
import rmitseprocesstools.model.BookingStatus;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Thejana
 */
public class BookingTests {
    BookingController controller;
    Connection c = null;

    @Before
    public void InitializeDbTests()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        DbHandler.SetConnection(c);
        controller = new BookingController();
    }

    @After
    public void RollbackTestChanges()
    {
        try {
            c.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testBooking() {
        Assert.assertTrue(controller.saveBookingMade(1, 1, 1, 1, "9:00 AM", "9:30 AM", "22/05/2017"));

        boolean verified = false;

        for (Booking item: DbHandler.GetBookings()) {
            if(item.getEmployeeId() == 1 && item.getActivityId() == 1 && item.getPersonForId() == 1 && item.getBookingDate().toLocalDate().isEqual(LocalDate.of(2017,05,22))) {
                verified = true;
                break;
            }
        }

        Assert.assertTrue(verified);
    }
    
    @Test
    public void testCancelBooking() {
        Assert.assertTrue(controller.cancelBooking("1"));

        boolean verified = false;

        for (Booking item: DbHandler.GetBookings()) {
            if(item.getBookingId() == 1 && item.getStatus() == BookingStatus.CANCELLED) {
                verified = true;
            }
        }

        Assert.assertTrue(verified);
    }
    
    @Test
    public void testViewBooking() {
        JComboBox jcb = new JComboBox();
        jcb.addItem("1");
        jcb.setSelectedItem("1");
        JTextField date = new JTextField();
        JTextField time = new JTextField();
        JTextField status = new JTextField();
        controller.populateTrackBooking(jcb, date, time, status, false);

        Assert.assertEquals(date.getText(), "2017-05-22");
        Assert.assertEquals(time.getText(), "9:00 AM - 9:30 AM");
        Assert.assertEquals(status.getText(), "CONFIRMED");
    }
}
