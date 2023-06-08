package com.loop.test.home_practice.day_2;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*1. navigate to docuport application
2. validate placeholders for user name and password
3. without sending username and password click login button
4. validate username and password error messages */
public class Task2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        ((WebDriver) driver).manage().window().maximize();
        driver.get("https://beta.docuport.app");

        String actualUsernamePlaceholder = driver.findElement(By.cssSelector("label[for='input-14']")).getText();
        String expectedlUsernamePlaceholder = "Username or email";

        if(actualUsernamePlaceholder.equals("Username or email")){
            System.out.println("Actual username placeholder: " + actualUsernamePlaceholder + " matches the expected username placeholder: " + expectedlUsernamePlaceholder + ": Test PASSED");
        } else {
            System.out.println("Actual username placeholder: " + actualUsernamePlaceholder + " DOES NOT match the expected username placeholder: " + expectedlUsernamePlaceholder);
            System.err.println("TEST FAILED");
        }

        String actualPasswordPlaceholder = driver.findElement(By.cssSelector("label[for='input-15']")).getText();

        if(actualPasswordPlaceholder.equalsIgnoreCase("Password")){
            System.out.println("Actual password placeholder: " + actualPasswordPlaceholder + " matches the expected password placeholder: " + actualPasswordPlaceholder + ": Test PASSED");
        } else {
            System.out.println("Actual password placeholder: " + actualPasswordPlaceholder + " DOES NOT match the expected password placeholder: " + actualPasswordPlaceholder);
            System.err.println("TEST FAILED");
        }

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

//        String actualUsernameErrorMsg = driver.findElement(By.cssSelector("div[class='v-messages__message']"));


//        String actualUsernameErrorMessage = driver.findElement(By.cssSelector("div[class='v-messages__message']"));



//        if (actualErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)) {
//            System.out.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + " , matches actual error message: " + actualErrorMessage + ". Test PASSED");
//        } else {
//            System.out.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + " , DOES NOT match actual error message: " + actualErrorMessage);
//            System.err.println("Test FAILED");
        }
    }


