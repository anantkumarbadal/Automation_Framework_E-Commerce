package com.store.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListener implements ITestListener {

    //Configuring Extent Report using TestNG Listener
    ExtentSparkReporter sparkhtmlReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;
    public void configureReport() {

        //Time stamp in real time scenario

        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String reportName = "MyStoreExtentListenerReport-" + timestamp + ".html";

        //These all will be called before Test Case Execution- once at class level

        //initializing the Extent classes
        sparkhtmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//ExtentReport//" + reportName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkhtmlReporter);//attaching the htmlReporter here

        //adding system information/environment information
        extentReports.setSystemInfo("Machine", "PC-1");
        extentReports.setSystemInfo("OS", "Window 11");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Host", "QA");
        extentReports.setSystemInfo("Username", "Anant");
        extentReports.setSystemInfo("Report", "Extent Listener Report");

        //configuration to change the look and feel of report
        sparkhtmlReporter.config().setDocumentTitle("Extent Listener Report");
        sparkhtmlReporter.config().setReportName("Automation Test Report");
        sparkhtmlReporter.config().setTheme(Theme.STANDARD);

    }

    //Listener Tests- we have to implement all the test methods present in ITestListener Interface - All methods are abstract so we are implementing in the Class here

    //This will be invoked in the start of the Execution before Test Cases
    public void onStart(ITestContext Result) //execute only once-class level
    {
        //calling the Extent Report method to invoke before Test case execution
        configureReport();
        System.out.println("On Start method invoked....");
    }

    //This will execute after the end of Test Cases execution
    public void onFinish(ITestContext Result)//execute only once-class level
    {
        System.out.println("On Finished method invoked....");
        extentReports.flush(); //calling this method to write all the information-mandatory to call this method
    }

    //When Test Case get started, this method is called
    public void onTestStart(ITestResult Result) //at the starting of every Test Case execution- called with every TCs
    {
        System.out.println("Name of the test method started: " + Result.getName());
    }

    //When Test case get failed, this method is called
    public void onTestFailure(ITestResult Result) {
        System.out.println("Name of the test method failed: " + Result.getName());

        //configuring the failed Test case result in Extent report
        extentTest = extentReports.createTest(Result.getName()); //createTest returns ExtentTest object so storing in its object- entry in html report
        extentTest.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed Test Case is: " + Result.getName(), ExtentColor.RED));
        extentTest.fail(Result.getThrowable()); //logging all the failure details

        //Implementing capture screenshot to be taken while failing the Test Cases- and integrating this screenshot in Extent Report
        String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png"; //created path in the directory to save the file
        File screenshotFile = new File(screenShotPath); //creating the File in the location

        if (screenshotFile.exists()) {
            extentTest.fail("Captured Screenshot is below: " + extentTest.addScreenCaptureFromPath(screenShotPath));
        }
    }

    //When Test Case gets skipped , this method is called
    public void onTestSkipped(ITestResult Result) {
        System.out.println("Name of the Test method skipped: " + Result.getName());

        //configuring the skipped Test case result in Extent report
        extentTest = extentReports.createTest(Result.getName());
        extentTest.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped Test Case is: " + Result.getName(), ExtentColor.YELLOW));
        extentTest.skip(Result.getThrowable()); //logging all the skipped details
    }

    //When Test case get passed, this method is called
    public void onTestSuccess(ITestResult Result) {
        System.out.println("Name of the test method successfully executed: " + Result.getName());

        //configuring the passed Test case result in Extent report
        extentTest = extentReports.createTest(Result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel("Name of the passed Test Case is: " + Result.getName(), ExtentColor.GREEN));
      //  extentTest.pass(Result.getThrowable()); //logging all the passing details

    }

    //Just addressing the ITestListener methods- not implemented- its mandatory to address all the Abstract method present in ITestListener interface
    public void OnTestFailedButWithinSuccessPercentage(ITestResult Result) {
        // System.out.println();
    }


}
