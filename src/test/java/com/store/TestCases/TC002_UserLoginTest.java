package com.store.TestCases;

import com.store.Bases.BaseClass;
import com.store.PageObject.DashboardPage;
import com.store.PageObject.HomePage;
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
        HomePage hp = new HomePage(driver);
        hp.clickSignIn();
        logger.info("Clicked on Sign In Link in HomePage");

        //performing actions on the Sign In Page
        LoginPage lp = new LoginPage(driver);
        lp.enterEmailAddress("qatestingsdet@gmail.com");
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

        if(userName.equalsIgnoreCase("Welcome, Anant Kumar!"))
        {
            logger.info("VerifyLogin - Passed");
            Assert.assertTrue(true);
        }
        else
        {
            logger.info("VerifyLogin - Failed");
            captureScreenShot(driver, "tc002_verifyUserLoginFunctionality"); //capturing screenshot
           // Assert.fail();
            Assert.assertTrue(false);


        }



    }

}
