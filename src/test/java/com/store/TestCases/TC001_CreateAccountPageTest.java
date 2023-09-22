package com.store.TestCases;

import com.store.PageObject.CreateAccountPage;
import com.store.PageObject.HomePage;
import com.store.PageObject.RegisteredUserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_CreateAccountPageTest extends BaseClass {

    //inheriting all the re-usable methods from Base Class

    //Creating Test Case
    @Test
    public void verifyUserAccountRegistration() throws InterruptedException {
        //open url
        driver.get(url); //fetching the url from Base Class- Read Config file
        logger.info("URL Opened");

        //performing actions on the Homepage
        HomePage hp = new HomePage(driver);
        hp.clickCreateAnAccount();
        logger.info("Clicked on Create Account in HomePage");

        //performing actions on the Create Account Page
        CreateAccountPage cp = new CreateAccountPage(driver);
        cp.enterFirstName("Anant");
        logger.info("Enter FirstName");
        Thread.sleep(1000);
        cp.enterLastName("Kumar");
        logger.info("Enter LastName");
        Thread.sleep(1000);
        cp.enterEmailAddress("qatestingsdet999@gmail.com");
        logger.info("Enter Email Address");
        Thread.sleep(1000);
        cp.enterPassword("Test@1234");
        logger.info("Enter Password");
        Thread.sleep(1000);
        cp.enterConfirmPassword("Test@1234");
        logger.info("Enter Confirm Password");
        Thread.sleep(1000);
        cp.clickCreateAccountButton();
        logger.info("Clicked on Create Account Button");
        Thread.sleep(3000);

        //Validating that the User Account is created
        RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
        String userName = regUser.getUserName();
        logger.info("User Created: " + userName);

        //Validating the Username
        Assert.assertEquals(userName, "Welcome, Anant Kumar!");

        //validating the Alert Message
        String alertMessage = regUser.getAlertMessage();
        logger.info("Message displayed after creating Profile: " + alertMessage);
        //Validating the Message after Creating a Profile
        Assert.assertEquals(alertMessage, "Thank you for registering with Main Website Store.");



    }



}
