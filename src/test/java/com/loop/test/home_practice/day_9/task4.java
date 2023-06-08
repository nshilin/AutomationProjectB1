package com.loop.test.home_practice.day_9;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class task4 {
    /*
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/
3. Scroll down to “Powered by LOOPCAMP”
4. Scroll using Actions class “moveTo(element)” method
     */

    @Test
    public void scroll(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
        WebElement poweredByLoopcamp = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Powered by')]"));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(poweredByLoopcamp).perform();

        String expected = "Powered by LOOPCAMP";
        String actual = poweredByLoopcamp.getText();
        assertEquals(actual,expected, "actual " + " does not meet the expected " + expected);

        //Task5
        //1. Continue from where the Task 4 is left in the same test.
        //2. Scroll back up to Loop Academy link/picture using PageUP button
        WebElement loopAcademyLogo = Driver.getDriver().findElement(By.xpath("//a[contains(@class,'nav-link')]"));
        loopAcademyLogo.sendKeys(Keys.PAGE_UP);
        
    }
}
