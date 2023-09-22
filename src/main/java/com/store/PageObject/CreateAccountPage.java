package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    //Create object for WebDriver
    WebDriver driver;

    //Creating Constructor to initialise the webdriver
    public CreateAccountPage(WebDriver driver) //remote driver
    {
        this.driver = driver;

        PageFactory.initElements(driver, this); //driver is used to search the Web Elements
    }

    //Identifying the WebElements on the Create Account Page
    @FindBy(id = "firstname")
    WebElement txt_firstName;

    @FindBy(id = "lastname")
    WebElement txt_lastName;

    @FindBy(id = "email_address")
    WebElement txt_enterEmailAddress;

    @FindBy(name = "password")
    WebElement txt_enterPassword;

    @FindBy(name = "password_confirmation")
    WebElement txt_enterConfirmPassword;

    @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    WebElement btn_createAccountButton;

    //Identify action on WebElement
    public void enterFirstName(String firstname)
    {
        txt_firstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname)
    {
        txt_lastName.sendKeys(lastname);
    }

    public void enterEmailAddress(String emailAddress)
    {
        txt_enterEmailAddress.sendKeys(emailAddress);
    }

    public void enterPassword(String enterPassword)
    {
        txt_enterPassword.sendKeys(enterPassword);
    }

    public void enterConfirmPassword(String enterConfirmPassword)
    {
        txt_enterConfirmPassword.sendKeys(enterConfirmPassword);
    }

    public void clickCreateAccountButton()
    {
        btn_createAccountButton.click();
    }


}
