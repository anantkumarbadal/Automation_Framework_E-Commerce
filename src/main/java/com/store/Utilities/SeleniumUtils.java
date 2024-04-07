package com.store.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    public WebDriver driver;
    public WebDriverWait explicitWait;

    public SeleniumUtils(WebDriver driver)
    {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10)); //default wait
    }

    //Explicit wait- Added common methods for waiting for elements-----------------------------------------------
    public void waitForElementVisible(WebElement element)
    {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element)
    {
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForAlertPopUp()
    {
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForPresenceOfElement(WebElement element)
    {
        explicitWait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    public void waitForPageToBeLoaded(WebElement element)
    {
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By)element));
    }

    //Java Script Executor Code-----------------------------------------------------------------------
    public Object executeScript(String script, Object... args) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(script, args);
    }

    // Scroll down the page
    public void javaScriptExecutor_scrollDown() {
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Scroll to an element
    public void javaScriptExecutor_scrollToElement(WebElement element) {
        executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Click an element using JavaScript
    public void javaScriptExecutor_clickElementByJS(WebElement element) {
        executeScript("arguments[0].click();", element);
    }

    // Highlight an element
    public void javaScriptExecutor_highlightElement(WebElement element) {
        executeScript("arguments[0].style.border='3px solid red'", element);
    }

    // Scroll up to the middle of the page
    public void javaScriptExecutor_scrollToMiddle() {
        executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
    }




}
