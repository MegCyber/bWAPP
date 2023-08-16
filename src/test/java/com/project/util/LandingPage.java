package com.project.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

    private WebDriver driver;
    @FindBy(name = "bug")
    private WebElement bWAPPOption;
    @FindBy(xpath = "//button[@name='form_bug']")
    private WebElement hackButton;
    @FindBy(xpath = "//button[@name='form']")
    private WebElement hackButton2;
    @FindBy(id = "select_portal")
    private WebElement exploitOption;
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "lastname")
    private WebElement lastname;
    @FindBy(xpath = "//button[normalize-space()='Go']")
    private WebElement goButton;
    @FindBy(id = "login")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(name = "form")
    private WebElement loginButton;
    @FindBy(css = "div[id='main'] b:nth-child(1)")
    private WebElement SQLMessage;
    @FindBy(css = "body > div:nth-child(3) > h1:nth-child(5)")
    private WebElement HTMLMessage;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLandingPageDisplayed() {
        return exploitOption.isDisplayed() || bWAPPOption.isDisplayed();
    }

    public void selectExploit(String type) throws InterruptedException {
        Select select = new Select(bWAPPOption);
        select.selectByVisibleText(type);
        Thread.sleep(2000);
        hackButton2.click();
        Thread.sleep(2000);
    }

    public void exploitHTML(String name) throws InterruptedException {
        firstName.sendKeys(name);
        lastname.sendKeys("HTML");
        Thread.sleep(2000);
        goButton.click();
        //goButton.submit();
        Thread.sleep(2000);
    }

    public String HTMLMessageDisplayed() {
        return HTMLMessage.getText();
    }

    public void exploitSQL(String username, String password) throws InterruptedException {
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);
    }

    public boolean isSQLMessageDisplayed() {
        return SQLMessage.isDisplayed();
    }

    public void exploitXSS(String name) throws InterruptedException {
        firstName.sendKeys(name);
        lastname.sendKeys("HTML");
        Thread.sleep(2000);
        goButton.click();
        Thread.sleep(2000);
    }
}



