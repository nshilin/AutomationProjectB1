package com.loop.test.day10_jsexecutor_pom;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_drag_and_drop {
    /*
    TC #1: Loop Practice Drag and Drop Test
    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Move it on top of the big circle
    5. And release on it.
    6. Verify “You did great!” text appears on big circle
     */
    @Test
    public void practice_drag_drop_test(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(smallCircle)
                .clickAndHold()
                .moveToElement(bigCircle)
                .release()
                .perform();
        WebElement successMsg = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'You did great!')]"));
        String actual = successMsg.getText();
        String expected = "You did great!";
        Assert.assertEquals(actual,expected, "Actual does not match expected");
    }
}
