package com.store.TestCases;

import com.store.Bases.BaseClass;
import com.store.PageObject.CreateAccountPage;
import com.store.PageObject.HomePage;
import com.store.PageObject.RegisteredUserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_CreateAccountPageTest extends BaseClass {

    //inheriting all the re-usable methods from Base Class

    //Creating Test Case
    @Test(enabled = false)
    public void tc001_verifyUserAccountRegistration() throws InterruptedException {


        //performing actions on the Homepage
        HomePage hp = new HomePage(driver);
        hp.clickCreateAnAccount();
        logger.info("Clicked on Create Account link in HomePage");

        //performing actions on the Create Account Page
        CreateAccountPage cp = new CreateAccountPage(driver);
        cp.enterFirstName("Anant");
     //   logger.info("Enter FirstName");

        cp.enterLastName("Kumar");
     //   logger.info("Enter LastName");

        cp.enterEmailAddress("qatestingsdet@gmail.com");
     //   logger.info("Enter Email Address");

        cp.enterPassword("Test@1234");
    //    logger.info("Enter Password");

        cp.enterConfirmPassword("Test@1234");
    //    logger.info("Enter Confirm Password");
        Thread.sleep(1000);
        cp.clickCreateAccountButton();
        logger.info("Clicked on Create Account Button");
        Thread.sleep(1000);

        //Validating if the USer Account is already Created with given Email Address
        //Creating object for Page class
        RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
        //fetching username
        String userName = regUser.getUserName();
        //fetching alert message for New User Created
        String alertMessage = regUser.getAlertMessage();
        //fetching error message is the Account already exist with the Email
        String errorMessage = regUser.getErrorAlertMessage();

        if (userName.contains("Anant Kumar"))
        {
            //Validating that the New User Account is created
            Assert.assertEquals(userName, "Welcome, Anant Kumar!");
            logger.info("User Created: " + userName);

            //Validating the Message after Creating a Profile
            Assert.assertEquals(alertMessage, "Thank you for registering with Main Website Store.");
            logger.info("Message displayed after creating Profile: " + alertMessage);
        }
        else
        {
            logger.info("Error Message: " + errorMessage);
        }


    }



}
