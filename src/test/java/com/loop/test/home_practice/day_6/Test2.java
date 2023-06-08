package com.loop.test.home_practice.day_6;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 extends TestBase {
    @Test
    public void iframes() {
        //1.
        driver.get("https://demoqa.com/nestedframes");
        //2.Validate "Child Iframe" text
        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/sampleiframe']")));
        //driver.switchTo().frame(driver.findElement(By.xpath("//body[contains(.,'Parent frame')]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]")));
        WebElement childIframe = driver.findElement(By.xpath("//body[contains(.,'Child Iframe')]"));
        String actual = childIframe.getText();
        String expected = "Child Iframe";
        Assert.assertEquals(expected,actual,"expected does not meet actual");
        //3.Validate "Parent Iframe" text
        driver.switchTo().parentFrame();
        WebElement parentIframe = driver.findElement(By.xpath("//body[contains(.,'Parent frame')]"));
        String actualParent = parentIframe.getText();
        String expectedParent = "Parent frame";
        Assert.assertEquals(expectedParent,actualParent,"expected does not meet actual");
        //4.Validate the "Sample Nested Iframe page.
        driver.switchTo().defaultContent();
        WebElement textOnPage = driver.findElement(By.xpath("//div[@id='framesWrapper']//div[contains(.,'Sample Nested ')]"));
        String actualText = textOnPage.getText();
        String expectedText = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        Assert.assertEquals(expectedText,actualText,"expected does not meet actual");

    }
}
