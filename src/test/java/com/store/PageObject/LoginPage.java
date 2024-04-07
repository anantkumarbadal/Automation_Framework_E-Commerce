package com.store.PageObject;

import com.store.Bases.BaseClass;
import com.store.Utilities.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    SeleniumUtils seleniumUtils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.seleniumUtils = new SeleniumUtils(driver);
    }


    //Identifying the WebElements on the Login Page

    //Registered Username
    @FindBy(name = "login[username]")
    WebElement txt_registeredUserEmail;

    //Registered User Password
    @FindBy(name = "login[password]")
    WebElement txt_registeredUserPassword;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    WebElement btn_singIn;


    //Identify action on WebElement
    public void enterEmailAddress(String emailAddress) {
        txt_registeredUserEmail.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        txt_registeredUserPassword.sendKeys(password);
    }

    public void clickSignInButton()
    {
        btn_singIn.click();
    }


}
