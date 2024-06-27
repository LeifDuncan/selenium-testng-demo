package com.demo.nonstatic.experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.nonstatic.base.Base;

public class P00a_BasicSecurePage extends Base {

    private By securePageFlashBy = By.xpath("//div[@id='flash'][contains(text(),'You logged into a secure area!')]");
    
    @FindBy(xpath = "//a[contains(@href, 'github.com')]")
    private WebElement forkmeBtn;

    public P00a_BasicSecurePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSecurePageFlash() {
        return driver.findElement(securePageFlashBy);
    }

    public WebElement getLogoutBtn(String btnText) {
        String expression = String.format("//a[contains(@href, '%s')]", btnText);
        return driver.findElement(By.xpath(expression));
    }

    public WebElement getForkmeBtn() {
        return forkmeBtn;
    }

    // User actions

    public void logout() {
        getLogoutBtn("logout").click();
    }

}
