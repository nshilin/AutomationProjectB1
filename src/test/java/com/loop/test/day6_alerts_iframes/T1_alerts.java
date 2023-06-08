package com.loop.test.day6_alerts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed

     */
public class T1_alerts extends TestBase {

    @Test
    public void informationAlert(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickJSAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        clickJSAlert.click();
        Alert alert = driver.switchTo().alert();
        //driver.switchTo().alert().accept();

        alert.accept();
//p[contains(text(),'You successfully clicked an alert')]
        WebElement successMessageForInfoAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForInfoAlert.getText();
        String expected = "You successfully clicned an alert";
        Assert.assertEquals(expected, actual, "expected doesn't meet actual");
    }

    /*
    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.*/

    @Test
    public void confirmationAlert(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickJSConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        clickJSConfirm.click();

        driver.switchTo().alert().accept(); //will click "ok"
        WebElement successMessageForInfoAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForInfoAlert.getText();
        String expected = "You clicked: Ok";
        Assert.assertEquals(expected, actual, "expected doesn't meet actual");

        clickJSConfirm.click();

        driver.switchTo().alert().dismiss(); //will click cancel - will dismiss
        actual = successMessageForInfoAlert.getText();
        expected = "You clicked: Cancel";
        Assert.assertEquals(actual,expected,"actual does not match the expected");
    }

    /*
Information alert practice
1. Open browser
2. Go to website: http://the-internet.herokuapp.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Validate “You successfully clicked an alert” text is displayed*/
    @Test
    public void promptAlert(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        clickJSPrompt.click();
        String text = "Loop Academy";
//        driver.switchTo().alert().sendKeys("Loop Academy");
        //or
        //driver.switchTo().alert().sendKeys(text + Keys.ENTER);
//        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Loop Academy");
        alert.accept();

        WebElement successMessagePromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessagePromptAlert.getText();
        String expected = "You entered: " + text;
        Assert.assertEquals(actual, expected, "expected doesn't meet actual");


    }
}
