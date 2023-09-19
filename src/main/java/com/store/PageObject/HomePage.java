package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //Create Page Object class with Page Factory

    //Create object for WebDriver
    WebDriver driver;

    //Creating Constructor to initialise the webdriver
    public HomePage(WebDriver rdriver) //remote driver
    {
        this.driver = rdriver;

        PageFactory.initElements(rdriver, this); //rdriver is used to search the Web Elements
    }

    //Identifying the WebElements on the Homepage
    @FindBy(linkText = "Create an Account")
    WebElement createAnAccount;

    //Identify action on WebElement
    public void createAnAccount()
    {
        createAnAccount.click();
    }




}
