package com.loop.test.day6_alerts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class T2_iframe extends TestBase {
    /*
  1- Open a chrome browser
  2- Go to: http://the-internet.herokuapp.com/iframe
  3- Clear text from comment body
  4- Type "Loop Academy" in comment body
  5- Verify "Loop Academy" text is written in comment body
  6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
   */
    @Test
    public void iFrameTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/iframe");
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //driver.switchTo().frame(iframe);  // switching to iframe
        // driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Loop Academy");
        driver.switchTo().defaultContent(); // it will take us directly to main html
        // driver.switchTo().parentFrame(); // this will take us to parent frame
        WebElement heading = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame containing')]"));
        String actual = heading.getText();
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        assertEquals(actual, expected, "actual does not match with expected");
    }

    @Test
    public void amazonIframe(){
        List<WebElement> iframes = new ArrayList<>();
        iframes = driver.findElements(By.xpath("//iframe")); //or By.tagName("iframe")
        System.out.println(iframes.size() + " iframes");
    }
}
