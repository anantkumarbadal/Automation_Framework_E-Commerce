package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    //Identifying the WebElements on the Login Page
    @FindBy(name = "login[username]")
    WebElement txt_enterEmailAddress;

    @FindBy(name = "login[password]")
    WebElement txt_enterPassword;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    WebElement btn_singIn;


    //Identify action on WebElement
    public void enterEmailAddress(String emailAddress) {
        txt_enterEmailAddress.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        txt_enterPassword.sendKeys(password);
    }

    public void clickSignInButton() {
        btn_singIn.click();
    }


}
