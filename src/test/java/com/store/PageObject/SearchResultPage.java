package com.store.PageObject;

import com.store.Bases.BaseClass;
import com.store.Utilities.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {


    WebDriver driver;
    SeleniumUtils seleniumUtils;

    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }

    //Identifying the WebElements on the Search Result Page

    @FindBy(linkText = "Jade Yoga Jacket")
    WebElement searchResultProduct;

    public String getSearchResultProductName()
    {

        return searchResultProduct.getText();
    }


    //verifying the product searched after clicked from auto suggestive dropdown
    @FindBy(xpath = "//a[contains(text(),'Helios EverCool™ Tee')]")
    WebElement searchedProductOnThePage;

    public void clickOnSearchedProduct()
    {
        seleniumUtils.javaScriptExecutor_scrollToElement(searchedProductOnThePage);
        seleniumUtils.waitForElementClickable(searchedProductOnThePage);
        searchedProductOnThePage.click();
    }

    //product page after searching and clicking the product

    @FindBy(xpath = "//span[@class='base']")
    WebElement nameOfProduct;

    public String getProductName()
    {
        return nameOfProduct.getText();
    }











}






