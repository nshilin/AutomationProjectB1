package com.loop.test.day9_driver_faker_actions;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_actions_hoverover {
/*
1. Go to https://www.google.com
2. Hover over on Search button
3. Hover over on Feeling lucky button
 */

    @Test
    public void google_actions_hover() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement feelingLucky = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));

        Actions action = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        action.moveToElement(googleSearch).perform();
        Thread.sleep(3000);
        action.moveToElement(feelingLucky).perform();
        Driver.closeDriver();
        Thread.sleep(3000);
    }
}
