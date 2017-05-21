/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitseprocesstools.unit;

import org.junit.*;
import rmitseprocesstools.DbHandler;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.controller.BussinessOwnerController;
import rmitseprocesstools.model.Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thejana
 */
public class BusinessOwnerTests {
    Connection c = null;
    Business b;
    BussinessOwnerController controller;

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
        b = new AuthController().queryBusiness("business1");
        AuthController.currentUser = b;
        controller = new BussinessOwnerController();
    }

    @After
    public void RollbackTestChanges()
    {
        AuthController.currentUser = null;

        try {
            c.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    @Test
    public void testUpdateBusinessDetails() {
        Assert.assertEquals(true, controller.updateBusinessOwnerInfo(b.BusinessName, b.Name, b.Address, b.Phone, b.Question, b.Answer));
        Assert.assertEquals(false, controller.updateBusinessOwnerInfo("", b.Name, b.Address, b.Phone, b.Question, b.Answer));
        Assert.assertEquals(false, controller.updateBusinessOwnerInfo("", "", "", "", "", ""));
        Assert.assertEquals(false, controller.updateBusinessOwnerInfo(b.BusinessName, "", b.Address, b.Phone, b.Question, b.Answer));
        Assert.assertEquals(false, controller.updateBusinessOwnerInfo(b.BusinessName, b.Name, "", b.Phone, b.Question, b.Answer));
        Assert.assertEquals(false, controller.updateBusinessOwnerInfo(b.BusinessName, b.Name, b.Address, "", b.Question, b.Answer));
        Assert.assertEquals(false, controller.updateBusinessOwnerInfo(b.BusinessName, b.Name, b.Address, b.Phone, "", b.Answer));
        Assert.assertEquals(false, controller.updateBusinessOwnerInfo(b.BusinessName, b.Name, b.Address, b.Phone, b.Question, ""));
        Assert.assertEquals(false, controller.updateBusinessOwnerInfo(b.BusinessName, b.Name, b.Address, b.Password, b.Question, b.Answer));
    }
    
}
