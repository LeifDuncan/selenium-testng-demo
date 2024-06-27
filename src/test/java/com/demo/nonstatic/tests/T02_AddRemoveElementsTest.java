package com.demo.nonstatic.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.nonstatic.base.Base;
import com.demo.nonstatic.pages.P02_AddRemoveElementsPage;
import com.demo.nonstatic.utils.TestUtils;

public class T02_AddRemoveElementsTest extends Base {

    P02_AddRemoveElementsPage addRemoveElementsPage;

    @BeforeMethod
    public void setup() {
        initialization("/add_remove_elements/");
        addRemoveElementsPage = new P02_AddRemoveElementsPage(driver);
    }

    @Test
    public void testMultipleAddDelete() {
        int times = TestUtils.randomIntBetween(3,5);
        
        for(int i=0; i < times; i++) {
            addRemoveElementsPage.addElement();
            TestUtils.hardWait();
        }

        TestUtils.hardWait();

        for(int i=0; i < times; i++) {
            addRemoveElementsPage.deleteElement(times-i);
            TestUtils.hardWait();
        }

        Assert.assertTrue(addRemoveElementsPage.getDeleteBtns().size() == 0, "Delete button should have been deleted");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    
}
