package com.store.PageObject;

import com.store.Bases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Index_HomePage  {

    //Create Page Object class with Page Factory

    //Create object for WebDriver
    WebDriver driver;

    //Creating Constructor to initialise the webdriver
    public Index_HomePage(WebDriver driver) //remote driver
    {
        this.driver = driver;

        PageFactory.initElements(driver, this); //driver is used to search the Web Elements
    }


    //Identifying the WebElements on the Homepage
    @FindBy(linkText = "Create an Account")
    WebElement link_createAnAccount;

    @FindBy(linkText = "Sign In")
    WebElement link_signIn;


    //Identify action on WebElement
    public void clickCreateAnAccount()
    {
        link_createAnAccount.click();
    }

    public void clickSignIn()
    {
        link_signIn.click();
    }




}
