package com.store.TestCases;

import com.store.Bases.BaseClass;
import com.store.PageObject.DashboardPage;
import com.store.PageObject.Index_HomePage;
import com.store.PageObject.LoginPage;
import com.store.Utilities.ReadConfigFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC005_DashboardPageTest extends BaseClass {

    //Validating the Dashboard page components

    @Test
    public void tc005_verifyDashboardPageFunctionality() throws InterruptedException, IOException {
        logger.info("Verify Dashboard Page functionality execution started");

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
        Thread.sleep(2000);

        //Validating the Dashboard components

        DashboardPage dp = new DashboardPage(driver);
        dp.clickStoreLogo();
        logger.info("Current URL: " + driver.getCurrentUrl());
        logger.info("Dashboard Page- Store logo functionality- page reloaded once clicked");

        //validating the page title- Home Page
        if (driver.getTitle().contains("Home Page"))
        {
            logger.info("Title Matched- " + driver.getTitle());
            Assert.assertTrue(true);
        }
        else
        {
            logger.info("Title not matched");
            captureScreenShot(driver, "tc005_verifyDashboardPageFunctionality");
            Assert.assertFalse(true);
        }





    }

}
