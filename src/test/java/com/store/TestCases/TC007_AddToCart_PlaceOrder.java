package com.store.TestCases;

import com.store.Bases.BaseClass;
import com.store.PageObject.DashboardPage;
import com.store.PageObject.Index_HomePage;
import com.store.PageObject.LoginPage;
import com.store.PageObject.SearchResultPage;
import com.store.Utilities.ReadConfigFile;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC007_AddToCart_PlaceOrder extends BaseClass {
    @Test
    public void tc007_verifyProductPage_AddToCart_PlaceOrder() throws InterruptedException, IOException {

        logger.info("Verify Product Searched and Add to Cart then Place Order execution started");

        Index_HomePage hp = new Index_HomePage(driver);
        hp.clickSignIn();
        logger.info("Clicked on Sign in link in Homepage");

        LoginPage lp = new LoginPage(driver);
        lp.enterEmailAddress(ReadConfigFile.getGlobalValue("Email"));
        logger.info("Entered Email");
        lp.enterPassword(ReadConfigFile.getGlobalValue("Password"));
        logger.info("Entered Password");
        lp.clickSignInButton();
        logger.info("Clicked on Sign In Button");
        Thread.sleep(2000);

        //Validating the Search Product functionality

        DashboardPage dp = new DashboardPage(driver);
        dp.enterProductInSearchBox(ReadConfigFile.getGlobalValue("ProductName"));
        logger.info("Entered Product Name in Search Box: " + ReadConfigFile.getGlobalValue("ProductName"));
        dp.selectFromAutoSuggestedProductDropdown("jackets for men");
        logger.info("Selected Product from Auto suggested dropdown of product list");
        Thread.sleep(2000);

        //Click on Search Product to navigate to Product Page
        SearchResultPage sp = new SearchResultPage(driver);
        sp.clickOnSearchedProduct();
        logger.info("Clicked on Searched Product");



    }
}
