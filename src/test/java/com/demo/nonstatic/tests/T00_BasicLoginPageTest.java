package com.demo.nonstatic.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.nonstatic.base.Base;
import com.demo.nonstatic.pages.P00_BasicLoginPage;
import com.demo.nonstatic.pages.P01_BasicSecurePage;

public class T00_BasicLoginPageTest extends Base {

    P00_BasicLoginPage basicLoginPage;
    P01_BasicSecurePage basicSecurePage;

    @BeforeMethod
    public void setup() {
        initialization("/login");
        basicLoginPage = new P00_BasicLoginPage(driver);
    }

    @Test
    public void testLogin() {
        basicSecurePage = basicLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(basicSecurePage.getSecureFlash().isDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    
}
