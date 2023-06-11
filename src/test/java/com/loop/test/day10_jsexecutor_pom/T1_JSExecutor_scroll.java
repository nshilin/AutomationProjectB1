package com.loop.test.day10_jsexecutor_pom;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class T1_JSExecutor_scroll {
    /*
    1. Go to https://www.etsy.com
    2. Scroll down
    3. Generate random email and enter into subscribe box
    4. Click on Subscribe
    5. Verify "Great! We've sent you an email to confirm your subscription." is displayed
     */
    @Test
    public void etsy_scroll_test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy"));
        WebElement emailBox = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
//1.Use actions to move to element
        //        Actions action = new Actions(Driver.getDriver());
//        action.moveToElement(emailBox).perform();

        //#2 with Key press
//        action.sendKeys(Keys.PAGE_DOWN).perform();

        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        //3 move horizontally or vertically
//        js.executeScript("window.scrollBy(0,5000)");

        //4 - the best way of using scrolling
        js.executeScript("arguments[0].scrollIntoView(true)", emailBox);
    }
}
