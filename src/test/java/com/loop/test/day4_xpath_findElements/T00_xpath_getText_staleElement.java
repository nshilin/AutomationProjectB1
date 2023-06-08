package com.loop.test.day4_xpath_findElements;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.*;

/*
  1. Open Chrome browser
  2. Go to docuport
  3. Click on forgot password
  4. validate URL contains: reset-password
  5. validate - Enter the email address associated with your account
  6. enter forgotpasswordg1@gmail.com to email box
  7. validate cancel button is displayed
  8. validate send button is displayed
  9. click send button
  10. validate - We've sent you an email with a link to reset your password. Please check your email
   */
public class T00_xpath_getText_staleElement {
    public static void main(String[] args) throws InterruptedException {

        /* 1. Open Chrome browser
           2. Go to docuport*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        //3. Click on forgot password
        WebElement forgotPassword = driver.findElement(By.xpath("//*[contains(text(), 'Forgot password')]"));
        forgotPassword.click();

        //4. validate URL contains: reset-password
        String actualUrlForResetPassword = driver.getCurrentUrl();

        if (actualUrlForResetPassword.contains(DocuportConstants.RESET_PASSWORD_URL)){
            System.out.println("Actual url: " + actualUrlForResetPassword + " contains expected url: " + DocuportConstants.RESET_PASSWORD_URL);
        } else {
            System.out.println("Actual url: " + actualUrlForResetPassword + " DOES NOT contain expected url: " + DocuportConstants.RESET_PASSWORD_URL);
        }

        //5. validate - Enter the email address associated with your account

        WebElement validateMessage = driver.findElement(By.xpath("div[@class='v-messages__message']"));
        String actualValidateMessage = validateMessage.getText();

        if(actualValidateMessage.contains(DocuportConstants.RESET_PASSWORD_MESSAGE)){
           System.out.println("TEST PASS: => Actual validate message: " + actualValidateMessage + "contains expected message" + DocuportConstants.RESET_PASSWORD_MESSAGE);
                   } else {
           System.out.println("TEST FAIL: => Actual validate message: " + actualValidateMessage + "does not contain expected message" + DocuportConstants.RESET_PASSWORD_MESSAGE);
        }

        //6. enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='email']"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        //7. validate cancel button is displayed
        WebElement cancelButton = driver.findElement(By.xpath("//span[.=' Cancel ']"));//or  //a[@href='/login']
        WebElement sendButton = driver.findElement(By.xpath("//span[.=' Send ']"));

        if(cancelButton.isDisplayed()){
            System.out.println("TEST PASS => Cancel button is displayed");
        } else {
            System.err.println("TEST FAILED => Cancel button is NOT displayed");
        }

        //8. validate send button is displayed
        //9. click send button
        if(sendButton.isDisplayed()){
            System.out.println("TEST PASS => Send button is displayed");
        } else {
            System.err.println("TEST FAILED => Send button is NOT displayed");
        }

        sendButton.click();

        Thread.sleep(3000);

       // 10. validate - We've sent you an email with a link to reset your password. Please check your email
        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        Thread.sleep(5000);

        try{
            System.out.println(successMessage.getText() + " we successfully got the message");
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not accessible anymore");
            e.printStackTrace();
        }

        System.out.println(successMessage.getText());

        driver.quit();
    }
}
