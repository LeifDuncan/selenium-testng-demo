package com.demo.nonstatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.nonstatic.base.Base;

public class P01_BasicSecurePage extends Base {

    private By secureFlashBy = By.xpath("//div[@id='flash'][contains(text(),'logged into')]");

    public P01_BasicSecurePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getClickableButton(String buttonText) { // either forkme or logout
        return driver.findElement(By.xpath(String.format("//a[contains(@href, '%s')]", buttonText)));
    }

    public WebElement getLogoutButton() {
        return getClickableButton("logout");
    }

    public WebElement getForkMeButton() {
        return getClickableButton("github");
    }

    public void clickLogout() {
        getLogoutButton().click();
    }

    public void clickForkMe() {
        getForkMeButton().click();
    }

    public WebElement getSecureFlash() {
        return driver.findElement(secureFlashBy);
    }

    public String getSecureFlashText() {
        return driver.findElement(secureFlashBy).getText();
    }

}
