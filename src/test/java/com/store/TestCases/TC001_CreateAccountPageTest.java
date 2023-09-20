package com.store.TestCases;

import com.store.PageObject.CreateAccountPage;
import com.store.PageObject.HomePage;
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

        //performing actions on the Create Account Page
        CreateAccountPage cp = new CreateAccountPage(driver);
        cp.enterFirstName("Anant");
        Thread.sleep(1000);
        cp.enterLastName("Kumar");
        Thread.sleep(1000);
        cp.enterEmailAddress("qatestingsdet@gmail.com");
        Thread.sleep(1000);
        cp.enterPassword("Testing123456789@!");
        Thread.sleep(1000);
        cp.enterConfirmPassword("Testing123456789@!");
        Thread.sleep(1000);
        cp.clickCreateAccountButton();
        Thread.sleep(3000);
    }


}
