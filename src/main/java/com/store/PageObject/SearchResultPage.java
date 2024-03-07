package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Identifying the WebElements on the Search Result Page

    @FindBy(linkText = "Jade Yoga Jacket")
    WebElement searchResultProduct;

    public String getSearchResultProductName()
    {
        return searchResultProduct.getText();
    }






}






