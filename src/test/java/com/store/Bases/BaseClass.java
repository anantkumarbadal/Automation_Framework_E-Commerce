package com.store.Bases;

import com.store.Utilities.ReadConfigFile;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public static WebDriverWait explicitWait;

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

            default:
                driver = null;
                break;
        }

        //Implicit wait for 10 seconds and apply for all web elements
        //   assert driver != null;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //maximize the window
        driver.manage().window().maximize();

        //for logging
        logger = LogManager.getLogger("MyEComStore");

        //open url
        driver.get(url);
        logger.info("URL Opened");

    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }

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
