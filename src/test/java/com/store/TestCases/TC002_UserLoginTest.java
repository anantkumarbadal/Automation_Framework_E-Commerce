package com.store.TestCases;

import com.store.Bases.BaseClass;
import com.store.PageObject.DashboardPage;
import com.store.PageObject.Index_HomePage;
import com.store.PageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC002_UserLoginTest extends BaseClass {

    //Creating Test Case
    @Test
    public void tc002_verifyUserLoginFunctionality() throws InterruptedException, IOException {

        logger.info("Verify Login test execution started");

        //performing actions on the Homepage
        Index_HomePage hp = new Index_HomePage(driver);
        hp.clickSignIn();
        logger.info("Clicked on Sign In Link in HomePage");

        //performing actions on the Sign In Page
        LoginPage lp = new LoginPage(driver);
        lp.enterEmailAddress("testAutomation@mailinator.com");
        logger.info("Entered Email");
     //   Thread.sleep(1000);

        lp.enterPassword("Test@1234");
        logger.info("Entered Password");
    //    Thread.sleep(1000);

        lp.clickSignInButton();
        logger.info("Clicked on Sign In Button");
        Thread.sleep(3000);

        //verifying Logged In Username
        DashboardPage dp = new DashboardPage(driver);
        String userName = dp.getLoggedInUserName();

        //if(userName.equalsIgnoreCase("Welcome, Anant Kumar!"))
        if(userName.contains("Anant Kumar"))
        {
            logger.info("VerifyLogin - Passed");
            logger.info("Username displayed: " + userName);
            Assert.assertTrue(true);
        }
        else
        {
            logger.info("VerifyLogin - Failed");
            captureScreenShot(driver, "tc002_verifyUserLoginFunctionality"); //capturing screenshot
            //Assert.assertTrue(false);
            Assert.fail();


        }



    }

}
