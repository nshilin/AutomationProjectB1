package com.loop.test.home_practice.day_6;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends TestBase {
    /*task1
=============
1. go to https://demoqa.com/alerts
2. click - click button to see alert
3. handle alert
4. click - On button click, alert will appear after 5 seconds
5. handle alert
6. click - On button click, confirm box will appear
7. click ok and validate - You selected Ok
8. after that do it again this time cancel and validate - You selected Cancel
9. click - On button click, prompt box will appear
10. enter "Loop Academy" and validate You entered Loop Academy*/


    @Test
    public void infoAlert() throws InterruptedException{
        driver.get("https://demoqa.com/alerts");
        WebElement infoAlert = driver.findElement(By.xpath("//button[@id='alertButton']"));
        infoAlert.click();
        Alert alert = driver.switchTo().alert();
//        Thread.sleep(3000);
        alert.accept();
    }

    @Test
    public void onButtonClick() throws InterruptedException{
        driver.get("https://demoqa.com/alerts");
        WebElement infoAlert = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        infoAlert.click();
        Thread.sleep(6000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void confirmAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement infoAlert = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        infoAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement successMessage = driver.findElement(By.xpath("//span[contains(.,'You selected ')]"));
        String actual = successMessage.getText();
        String expected = "You selected Ok";
        Assert.assertEquals(expected, actual, "expected does not meet actual");
    }
}


