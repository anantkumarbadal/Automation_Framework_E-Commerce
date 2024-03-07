package com.store.TestCases;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.store.Bases.BaseClass;
import com.store.PageObject.DashboardPage;
import com.store.PageObject.Index_HomePage;
import com.store.PageObject.LoginPage;
import com.store.PageObject.SearchResultPage;
import com.store.Utilities.ReadConfigFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC006_SearchProductTest extends BaseClass {

    @Test
    public void tc006_verifySearchProductFunctionality() throws InterruptedException, IOException {

        logger.info("Verify Search Product Page execution started");

        Index_HomePage hp = new Index_HomePage(driver);
        hp.clickSignIn();
        logger.info("Clicked on Sign in link in Homepage");

        LoginPage lp = new LoginPage(driver);

        //fetching the credentials globally from the properties file- test data stored

        lp.enterEmailAddress(ReadConfigFile.getGlobalValue("Email"));
        logger.info("Entered Email");
        lp.enterPassword(ReadConfigFile.getGlobalValue("Password"));
        logger.info("Entered Password");
        lp.clickSignInButton();
        logger.info("Clicked on Sign In Button");
        Thread.sleep(1000);

        //Validating the Search Product functionality

        DashboardPage dp = new DashboardPage(driver);
        dp.enterDataInSearchBox(ReadConfigFile.getGlobalValue("ProductName"));
        logger.info("Entered Search key in Search Box");
        dp.clickOnSearchButton();
        logger.info("Clicked on Search button and navigated to Search Result Page");
        Thread.sleep(1000);

        //validating on search result page- get name of product searched
        SearchResultPage sp = new SearchResultPage(driver);
        String searchResultPageProductName = sp.getSearchResultProductName();

        //verify the correct product is displayed after search
        if (searchResultPageProductName.contains("Jacket"))
        {
            logger.info("Search Product Test Case- Passed" + ", Product Displayed: " + searchResultPageProductName);
            Assert.assertTrue(true);
            dp.clickCustomerMenuDropdwon();
            dp.clickLogoutLink();
        }
        else
        {
            logger.info("Search Product Test Case- Failed" + ", Product Displayed: " + searchResultPageProductName);
            captureScreenShot(driver, "tc006_verifySearchProductFunctionality");
            Assert.assertFalse(true);
        }


    }

}
