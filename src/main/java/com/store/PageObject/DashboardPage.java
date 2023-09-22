package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

    //Creating Constructor to initialise the webdriver
    public DashboardPage(WebDriver driver) //remote driver
    {
        this.driver = driver;

        PageFactory.initElements(driver, this); //driver is used to search the Web Elements
    }

    //Identifying the WebElements on the Dashboard Page

    //Logged In UserName
    @FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']") //validating Logged Username
    WebElement heading_loggedInUsername;


    public String getLoggedInUserName()
    {
        String text = heading_loggedInUsername.getText();
        return text;
    }


}
