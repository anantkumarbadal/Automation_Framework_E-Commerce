package com.store.Bases;

import com.store.Utilities.ReadConfigFile;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    //base class for re-usable methods which will be used across all the test case and will be common for all

    ReadConfigFile readConfigFile = new ReadConfigFile();
    //retrieving the values from config file
    public String url = readConfigFile.getBaseUrl();
    public String browser = readConfigFile.getBrowser();

    public static WebDriver driver;
    public static Logger logger;


    //setting up a method to launch the browser
    @BeforeClass
    public void setup()
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "msedge":
                driver= new EdgeDriver();
                break;

            case "firefox":
                driver= new FirefoxDriver();
                break;

        /* using headless browser Headless browsers allow you to run your tests without opening a visible browser window,
        making them ideal for CI environments.
        */

            case "chrome-headless":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1200");

                driver = new ChromeDriver(options);
                break;

            case "firefox-headless":
                FirefoxOptions options1 = new FirefoxOptions();
                options1.addArguments("--headless");
                options1.addArguments("--disable-gpu");
                options1.addArguments("--window-size=1920,1200");

                driver = new FirefoxDriver(options1);
                break;


            default:
                driver = null;
                break;
        }

        //Implicit wait for 10 seconds and apply for all web elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //maximize the window
        driver.manage().window().maximize();

        //for logging
        logger = LogManager.getLogger("MyEComStore");

        //open url
        driver.get(url);
        logger.info("URL Opened: " + driver.getCurrentUrl());

    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }

    // Add common reusable methods------------------------------------------------------------------------------------

    //Creating method for screenshot- It will take the screenshot and save in the Root Folder
    public void captureScreenShot(WebDriver driver, String testCaseName) throws IOException
    {
        //step-1 convert WebDriver object to TakeScreenshot interface
        TakesScreenshot screenshot = ((TakesScreenshot)driver); //type casting webdriver object

        //step-2 call getScreenshotAs method to create image file
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "//Screenshots//" + testCaseName + ".png");

        //step-3 copy image file to destination
        FileUtils.copyFile(source, destination);

    }


}
