package com.loop.test.day_11_utils_practice;

import com.loop.pages.LoopPracticeDynamicLoading1;
import com.loop.test.utilities.BrowserUtils;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T0_dynamic_loading1 {
 /*
    1. go to https://loopcamp.vercel.app/dynamic_loading/1.html
    2. click start
    3. wait loading bar disappears
    4. validate username is displayed
    5. enter username tomsmith
    6. enter password incorrectpassword
    7. click submit button
    8. validate "Your password is invalid" is displayed
     */

   LoopPracticeDynamicLoading1 loopPracticeDynamicLoading1;
   WebDriverWait wait;

   @BeforeMethod
    public void setUp(){
       loopPracticeDynamicLoading1 = new LoopPracticeDynamicLoading1();
       wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
   }

   @AfterClass
   public void tearDown(){
       //Driver.closeDriver();
   }

   @Test
    public void dynamic_loading_1(){
       BrowserUtils.loopLinkClick("Dynamic Loading");
//       wait.until(ExpectedConditions.elementToBeClickable(loopPracticeDynamicLoading1.dynamicLoading1)).click();
       BrowserUtils.waitForClickable(loopPracticeDynamicLoading1.dynamicLoading1, 10).click();
       BrowserUtils.waitForClickable(loopPracticeDynamicLoading1.startButton,5).click();
       BrowserUtils.waitForInvisibility(loopPracticeDynamicLoading1.loadingBar,10);
       Assert.assertTrue(loopPracticeDynamicLoading1.username.isDisplayed());
       loopPracticeDynamicLoading1.username.sendKeys(ConfigurationReader.getProperty("dynamicLoading.username"));
       loopPracticeDynamicLoading1.password.sendKeys(ConfigurationReader.getProperty("dynamicLoading.incorrectPassword"));
       loopPracticeDynamicLoading1.submitButton.click();
       Assert.assertTrue(loopPracticeDynamicLoading1.errorMessage.isDisplayed());
   }
}
