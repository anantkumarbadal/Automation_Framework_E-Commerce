package com.store.TestCases;

import com.store.Bases.BaseClass;
import com.store.PageObject.DashboardPage;
import com.store.PageObject.Index_HomePage;
import com.store.PageObject.LoginPage;
import com.store.Utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC004_UserLogin_DataDrivenTest extends BaseClass {
    @Test(dataProvider = "LoginDataProvider")//use this data provider to get the data
    public void tc004_verifyUserLogin_DataDriven(String userEmail, String userPassword, String expectedUserName /*need this three parameters*/) throws InterruptedException, IOException {

        logger.info("Verify Login test with Data Driven concept execution started");

        //performing actions on the Homepage
        Index_HomePage hp = new Index_HomePage(driver);
        hp.clickSignIn();
        logger.info("Clicked on Sign In Link in HomePage");

        //performing actions on the Sign In Page
        LoginPage lp = new LoginPage(driver);
        lp.enterEmailAddress(userEmail);
        logger.info("Entered Email");
        //   Thread.sleep(1000);

        lp.enterPassword(userPassword);
        logger.info("Entered Password");
        //    Thread.sleep(1000);

        lp.clickSignInButton();
        logger.info("Clicked on Sign In Button");
        Thread.sleep(3000);

        //verifying Logged In Username
        DashboardPage dp = new DashboardPage(driver);
        String actualUserName = dp.getLoggedInUserName();

        if (actualUserName.contains(expectedUserName)) {
            logger.info("VerifyLogin - Passed");
            logger.info("Username displayed: " + actualUserName);
            Assert.assertTrue(true);

            //Sign out
            dp.clickCustomerMenuDropdwon();
            dp.clickLogoutLink();
            logger.info("Clicked on Logout");
        } else {
            logger.info("VerifyLogin - Failed");
            captureScreenShot(driver, "tc004_verifyUserLogin_DataDriven"); //capturing screenshot

              Assert.assertTrue(false, "Actual User Name: " + actualUserName + ", Expected User Name: " + expectedUserName);
          //  Assert.fail("Actual User Name: " + actualUserName + ", Expected User Name: " + expectedUserName);
        }

    }

    //Data provider to provide the data in method
    @DataProvider(name = "LoginDataProvider")
    public String[][] LoginDataProvider()//lecture-4 35 minutes
    {
        // String fileName = System.getProperty("user.dir") + "\\src\\test\\TestData\\MyStoreTestData.xlsx";
        String fileName = "src/test/TestData/MyStoreTestData.xlsx";

        int totalRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
        int totalColumns = ReadExcelFile.getColumnCount(fileName, "LoginTestData");

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
                    data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
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
