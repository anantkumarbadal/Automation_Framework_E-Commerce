package com.store.PageObject;

import com.store.Bases.BaseClass;
import com.store.Utilities.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    WebDriver driver;
    SeleniumUtils seleniumUtils;

    //Creating Constructor to initialise the webdriver
    public DashboardPage(WebDriver driver) //remote driver
    {
        this.driver = driver;
        PageFactory.initElements(driver, this); //driver is used to search the Web Elements
        this.seleniumUtils = new SeleniumUtils(driver);

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

    public void clickCustomerMenuDropdown()
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

    //Search box--------------------------------
    @FindBy(id = "search")
    WebElement searchbox;

    public void enterDataInSearchBox(String searchKey)
    {
        searchbox.sendKeys(searchKey);
    }

    //Search button
    @FindBy(xpath = "//button[@title='Search']")
    WebElement submit_search;

    public void clickOnSearchButton()
    {
        submit_search.click();
    }

    //Search Product from Auto suggestive Dropdown and click-----------------------

    @FindBy(id = "search")
    WebElement searchProduct;

    //@FindBy(xpath = "//div[@id='search_autocomplete']")
    @FindBy(xpath = "//ul[@role='listbox']")
    //WebElement autoSuggestProductDropdown;
    List<WebElement> autoSuggestedProductsInDropdown;

    public void enterProductInSearchBox(String searchKey)
    {
        searchProduct.sendKeys(searchKey);

       // seleniumUtils.waitForElementVisible((WebElement) autoSuggestedProductsInDropdown); //wait for the visibility of the first element in the list
      //  seleniumUtils.waitForElementVisible(autoSuggestedProductsInDropdown.get(0));
        if (!autoSuggestedProductsInDropdown.isEmpty()) {
            WebElement firstElement = autoSuggestedProductsInDropdown.get(0);
            seleniumUtils.waitForElementVisible(firstElement);
        }

    }

    public void selectFromAutoSuggestedProductDropdown(String productOptionFromList)
    {

        //Identifying the multiple objects that auto populated in dropdown

        for (WebElement option : autoSuggestedProductsInDropdown)
        {
            String productsName = option.getText();
          //  System.out.println("List of Products: " + productsName);
            if (productsName.contains(productOptionFromList))
            {
                option.click();
                break;
            }
            else
            {
                System.out.println("This Product is not in the list: " + productOptionFromList);
            }

        }
    }





}
