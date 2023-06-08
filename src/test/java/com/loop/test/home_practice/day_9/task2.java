package com.loop.test.home_practice.day_9;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class task2 {
    /*
    1. Go to https://loopcamp.vercel.app/hovers.html
2. Hover over to first image
3. Assert:
	a. “name: user1” is displayed
	b. “view profile” is displayed
4. Hover over to second image
5. Assert:
	a. “name: user2” is displayed
	b. “view profile” is displayed
6. Hover over to third image
7. Confirm:
	a. “name: user3” is displayed
	b. “view profile” is displayed
	*/

    @Test
    public void hover_practice() {
        Driver.getDriver().get(ConfigurationReader.getProperty("hover.practice"));
        WebElement firstImg = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));

        //2. Hover over to first image
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(firstImg).perform();
//
//         3. Assert:
//        a. “name: user1” is displayed
        String expectedUser1Text = "name: user1";
        String actualUser1Text = Driver.getDriver().findElement(By.xpath("//h5[contains(.,'name: user1')]")).getText();

        assertEquals(actualUser1Text, expectedUser1Text, "actual: " + actualUser1Text + " does not match expected: " + expectedUser1Text);

//        3. Assert:
//        b. “view profile” is displayed

        String expectedViewPr = "View profile";
        String actualViewPr = Driver.getDriver().findElement(By.xpath("//a[@href='users/1.html']")).getText();

        assertEquals(actualViewPr, expectedViewPr, "expected: " +  expectedViewPr + " does not match actual: " + actualViewPr);

//        4. Hover over to second image
        WebElement secondImg = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        action.moveToElement(secondImg).perform();

//        5. Assert:
//        a. “name: user2” is displayed

        String expectedUser2Text = "name: user2";
        String actualUser2Text = Driver.getDriver().findElement(By.xpath("//h5[contains(.,'name: user2')]")).getText();

        assertEquals(actualUser2Text, expectedUser2Text);

//        b. “view profile” is displayed
        String expectedViewPr2 = "View profile";
        String actualViewPr2 = Driver.getDriver().findElement(By.xpath("//a[@href='users/2.html']")).getText();

        assertEquals(actualViewPr2,expectedViewPr2,"actual: " + actualViewPr2 + " does not match expected: " + expectedViewPr2);

//        6. Hover over to third image
        WebElement thirdImg = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));
        action.moveToElement(thirdImg).perform();
//        7. Confirm:
//        a. “name: user3” is displayed
        String expectedUser3Text = "name: user3";
        String actualUser3Text = Driver.getDriver().findElement(By.xpath("//h5[contains(.,'name: user3')]")).getText();

        assertEquals(actualUser3Text, expectedUser3Text,"actual: " + actualUser3Text + " does not match expected: " + expectedUser3Text);
//        b. “view profile” is displayed
        String expectedViewPr3 = "View profile";
        String actualViewPr3 = Driver.getDriver().findElement(By.xpath("//a[@href='users/3.html']")).getText();

        assertEquals(actualViewPr3,expectedViewPr3,"actual: " + actualViewPr3 + " does not match expected: " + expectedViewPr3);

        Driver.closeDriver();
    }
}
