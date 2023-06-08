package com.loop.test.home_practice.day_3;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
1. go to docuport app
2. validate that Home, Received docs, My uploads, Invitations are displayed
3. press three lines
4. Home, Received docs, My uploads, Invitations will disappear
5. Validate the buttons are not displayed */
public class Task1 {
    public static void main(String[] args) {

        //1. go to docuport app
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/login?redirect=%2F");
        driver.manage().window().maximize();

        WebElement loginInput = driver.findElement(By.xpath("//input[@id='input-14']"));
        loginInput.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='input-15']"));
        passwordInput.sendKeys(DocuportConstants.PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        loginButton.click();

        //2. validate that Home, Received docs, My uploads, Invitations are displayed
        WebElement home = driver.findElement(By.xpath("//a[@class='py-x-2 v-item--active v-list-item--active v-list-item v-list-item--link theme--light']"));
        if(home.isDisplayed()){
            System.out.println("TEST PASS: Home section is displayed");
        } else {
            System.out.println("TEST FAIL: Home section is NOT displayed");
        }

        WebElement receivedDocs = driver.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-folder-download theme--light']/../.."));
        if(receivedDocs.isDisplayed()){
            System.out.println("TEST PASSED: Received Docs is displayed");
        } else {
            System.out.println("TEST FAILED: Received Docs is NOT displayed");
        }

        WebElement myUploads = driver.findElement(By.xpath("//a[contains(@href, '/my-uploads')]"));
        if(myUploads.isDisplayed()){
            System.out.println("TEST PASSED: myUploads is Displayed");
        } else {
            System.out.println("TEST FAILED: myUploads is NOT Displayed");
        }

        WebElement invitations = driver.findElement(By.xpath("//a[contains(@href, '/invitations')]"));
        if(invitations.isDisplayed()){
            System.out.println("TEST PASSED: invitations is Displayed");
        } else {
            System.out.println("TEST FAILED: invitations is NOT Displayed");
        }

        //3. press three lines
        WebElement hamburgherMenu = driver.findElement(By.xpath("//i[@class ='v-icon notranslate mdi mdi-menu theme--light']"));
        hamburgherMenu.click();

        //4. Validate Home, Received docs, My uploads, Invitations are not displayed
        if(home.isDisplayed() || receivedDocs.isDisplayed() || myUploads.isDisplayed() || invitations.isDisplayed()){
            System.out.println("TEST FAILED");
        } else {
            System.out.println("TEST PASSED");
        }
        driver.quit();
    }
}
