package com.store.TestCases;

import com.store.Bases.BaseClass;
import com.store.PageObject.CreateAccountPage;
import com.store.PageObject.Index_HomePage;
import com.store.PageObject.RegisteredUserAccount;
import com.store.Utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC003_CreateAccount_DataDrivenTest extends BaseClass {

    //applying data driven testing and fetching the test data from excel file

    //inheriting all the re-usable methods from Base Class

    @Test(enabled = true, dataProvider = "CreateAccountDataProvider")
    public void tc003_verifyCreateAccount_DataDriven(String firstname, String lastName, String userEmail, String userPassword, String userConfirmPassword, String expectedUserName, String expectedThankYouMessage) throws InterruptedException, IOException {

        logger.info("Verify Create Account test with Data Driven concept execution started");

        //performing actions on the Homepage
        Index_HomePage hp = new Index_HomePage(driver);
        hp.clickCreateAnAccount();
        logger.info("Clicked on Create Account link in HomePage");

        //performing actions on the Create Account Page
        CreateAccountPage cp = new CreateAccountPage(driver);
        cp.enterFirstName(firstname);
        logger.info("Entered FirstName");

        cp.enterLastName(lastName);
        logger.info("Entered LastName");

        cp.enterEmailAddress(userEmail);
        logger.info("Entered Email Address");

        cp.enterPassword(userPassword);
        logger.info("Entered Password");

        cp.enterConfirmPassword(userConfirmPassword);
        logger.info("Entered Confirm Password");
        Thread.sleep(1000);

        cp.clickCreateAccountButton();
        logger.info("Clicked on Create Account Button");
        Thread.sleep(1000);

        //Creating object for Page class
        RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
        //fetching username
        String actualUserName = regUser.getUserName();

        //fetching thank you message for New User Created
        String actualThankYouMessage = regUser.getAlertMessage();

        //fetching error message is the Account already exist with the Email
        String errorMessage = regUser.getErrorAlertMessage();

        //Implement in better way------------------------------------
        if (actualUserName.contains(expectedUserName))
        {
            //Validating that the New User Account is created
            Assert.assertEquals(actualUserName, expectedUserName);
            logger.info("Verify Create Account- Passed -  " + actualUserName);
            logger.info("Email: " + userEmail);

            //Validating the Message after Creating a Profile
            Assert.assertEquals(actualThankYouMessage, expectedThankYouMessage );
            logger.info("Message displayed after creating Profile: " + actualThankYouMessage);
        }
        else
        {
            logger.info("Verify Create Account- Failed- " + errorMessage);
            captureScreenShot(driver, "tc003_verifyCreateAccount_DataDriven");
            Assert.assertTrue(false);
        }

    }
    @DataProvider(name = "CreateAccountDataProvider")
    public String[][] CreateAccountDataProvider()//lecture-4 35 minutes
    {

        String fileName = "src/test/TestData/MyStoreTestData.xlsx";

        int totalRows = ReadExcelFile.getRowCount(fileName, "UserRegistrationData");
        int totalColumns = ReadExcelFile.getColumnCount(fileName, "UserRegistrationData");

        System.out.println("Total Rows: " + totalRows);
        System.out.println("Total Columns: " + totalColumns);

        // Check if totalRows is greater than 1 before initializing data array
        if (totalRows > 1) {
            String[][] data = new String[totalRows - 1][totalColumns];

            //outer loop will take each row and fetch the data according to column
            // Populate data array
            for (int i = 1; i < totalRows; i++)//rows- taken i=1 because we need the data from 2nd row- 1,2
            {
                for (int j = 0; j < totalColumns; j++)//column- each colum data will be fetched for particular row- 0,1,2
                {
                    data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "UserRegistrationData", i, j);
                }
            }
            return data;
        } else {
            // Handle case where there are no rows or only one row in the Excel sheet
            // You may throw an exception, log an error, or return null depending on your requirements
            throw new RuntimeException("There are no rows or only one row in the Excel sheet. Data provider cannot proceed.");
        }
    }

}
