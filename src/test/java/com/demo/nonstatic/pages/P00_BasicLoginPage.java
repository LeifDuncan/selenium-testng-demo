package com.demo.nonstatic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.nonstatic.base.Base;

public class P00_BasicLoginPage extends Base {

    @FindBy(xpath = "//div[@data-alert][@class='flash success']")
    WebElement flashMessage;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    
    @FindBy(xpath = "//button/i[contains(@class, 'sign-in')]")
    WebElement loginBtn;

    public P00_BasicLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public P01_BasicSecurePage login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new P01_BasicSecurePage(driver);
    }

    public String getFlashMessage() {
        return flashMessage.getText();
    }
}
