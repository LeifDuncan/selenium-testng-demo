package com.demo.nonstatic.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.nonstatic.base.Base;

public class P02_AddRemoveElementsPage extends Base {

    public By pageHeaderBy = By.xpath("//h3");
    public By addBtnBy = By.xpath("//button[text()='Add Element']");
    public By deleteBtnBy = By.xpath("//button[text()='Delete']");

    public int deleteBtnCount;

    public P02_AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddbtn() {
        return driver.findElement(addBtnBy);
    }

    public void addElement() {
        getAddbtn().click();
    }

    public List<WebElement> getDeleteBtns() {
        List<WebElement> deleteBtns = driver.findElements(deleteBtnBy);
        deleteBtnCount = deleteBtns.size();
        return deleteBtns;
    }

    public void deleteElement(int index) {
        List<WebElement> deleteBtns = getDeleteBtns();
        if(index >=0 && getDeleteBtns().size() > index) {
            deleteBtns.get(index).click();
        } else {
            throw new IllegalArgumentException("Index is invalid.");
        }
    }

}
