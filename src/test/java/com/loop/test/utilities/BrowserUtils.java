package com.loop.test.utilities;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class BrowserUtils extends TestBase {
    /**
     * validate if driver switched to expected url or title
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author natalie
     * note: usually we do not do validation in method, this is for practicing purposes
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedUrl = expectedUrl.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * switches to a new window by the exact title
     * returns to original window if windows with given title is not found
     */
    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * @param driver
     * @param expectedTitle returns void, assertion is implemented
     * @author natalie
     */
    public static void validateTitle(WebDriver driver, String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * @param nameOfthePage from loop practice page
     * once you on the page call it
     * @author nsh
     */
    public static void loopLinkClick(String nameOfthePage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfthePage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * hover over method
     *
     * @param element
     */
    public static void hoverOver(WebElement element) {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
    }

    /**
     * method that scrolls to the given element
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * method that scrolls to the given element and clicks with js
     *
     * @param element
     */
    public static void scrollAndClick(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click;", element);
    }

    /**
     * method that will doubleclick any given element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick().perform();
    }

    /**
     * method that will wait for visibility of the given element
     *
     * @param element
     * @param timeToWait return element
     * @author Nadir
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWait) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWait));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * method that will wait for invisibility
     *
     * @param element
     * @param timeToWait
     * @author Nadir
     */
    public static void waitForInvisibility(WebElement element, int timeToWait) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * method that will wait until the element becomes clickable
     *
     * @param element
     * @param timeOut
     * @return
     * @author Natalie
     */
    public static WebElement waitForClickable(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * method performs a pause
     * @param seconds
     */
    public static void justWait(int seconds) {
       try{
        Thread.sleep(seconds * 1000);
       } catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}

