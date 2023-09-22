package com.store.TestCases;

import com.store.Utilities.ReadConfigFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseClass {

    //base class for re-usable methods which will be used across all the test case and will be common for all

    ReadConfigFile readConfigFile = new ReadConfigFile();
    //retrieving the values from config file
    String url = readConfigFile.getBaseUrl();
    String browser = readConfigFile.getBrowser();

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

    }

   // @AfterClass
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }



}
