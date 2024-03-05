package com.store.PageObject;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
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

    //Logged In Username
    @FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']")
    WebElement heading_loggedInUsername;


    public String getLoggedInUserName() {
        String text = heading_loggedInUsername.getText();
        return text;
    }

    //Logout implementation
    @FindBy(css = "div[class='panel header'] button[type='button']")
    WebElement dropdown_customerMenu;

    public void clickCustomerMenuDropdwon()
    {
        dropdown_customerMenu.click();
    }

    @FindBy(linkText = "Sign Out")
    WebElement link_logout;

    public void clickLogoutLink()
    {
        link_logout.click();
    }

    //Dashboard Page components---------------------------

    //Store Logo
  //  @FindBy(linkText = "store logo")
    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    WebElement link_storeLogo;

    public void clickStoreLogo()
    {
        link_storeLogo.click();
    }

    //


}
