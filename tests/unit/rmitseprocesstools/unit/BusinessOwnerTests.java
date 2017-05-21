/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitseprocesstools.unit;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import rmitseprocesstools.controller.AuthController;
import rmitseprocesstools.controller.BussinessOwnerController;
import rmitseprocesstools.model.Business;

/**
 *
 * @author Thejana
 */
public class BusinessOwnerTests {
    
    Business b;
    BussinessOwnerController controller;
    
    public BusinessOwnerTests() {
        b = new AuthController().queryBusiness("b1");
        controller = new BussinessOwnerController();
    }
    
    @BeforeClass
    public static void setupTestEnv() {
        AuthController.currentUser = new AuthController().queryBusiness("b1");
    }
    
    @AfterClass
    public static void destroyTestEnv() {
        AuthController.currentUser = null;
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
