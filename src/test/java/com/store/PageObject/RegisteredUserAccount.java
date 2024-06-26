package com.store.PageObject;

import com.store.Bases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {

    //Validating that the User Account is created successfully and displayed

    WebDriver driver;

    public RegisteredUserAccount(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    //Identifying the WebElements on the My Account Page
    @FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']")
    WebElement createdUserName;

    public String getUserName()
    {
        return createdUserName.getText();
    }

    @FindBy(xpath = "//div[@role='alert']")// Alert Message for Confirmation
    WebElement alertMessage;

    public String getAlertMessage()
    {
        return alertMessage.getText();
    }

    //If the email address is already used and Account already created and giving error message to Login
    @FindBy(xpath = "//div[@role='alert']")
    WebElement errorAlertMessage;

    public String getErrorAlertMessage()
    {
        return errorAlertMessage.getText();
    }


}
