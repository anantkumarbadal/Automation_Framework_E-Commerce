package com.store.TestCases;

import com.store.PageObject.CreateAccountPage;
import com.store.PageObject.HomePage;
import com.store.PageObject.LoginPage;
import org.testng.annotations.Test;

public class TC002_UserLoginTest extends BaseClass{

    //Creating Test Case
    @Test
    public void verifyUserLoginFunctionality() throws InterruptedException {

        //open url
        driver.get(url);
        logger.info("URL Opened");

        //performing actions on the Homepage
        HomePage hp = new HomePage(driver);
        hp.clickSignIn();
        logger.info("Clicked on Sign In Link in HomePage");

        //performing actions on the Sign In Page
        LoginPage lp = new LoginPage(driver);
        lp.enterEmailAddress("qatestingsdet@gmail.com");
        logger.info("Entered Email");
        Thread.sleep(1000);

        lp.enterPassword("Test@1234");
        logger.info("Entered Password");
        Thread.sleep(1000);

        lp.clickSignInButton();
        logger.info("Clicked on Sign In Button");
        Thread.sleep(1000);


    }

}
