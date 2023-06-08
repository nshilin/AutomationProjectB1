package com.loop.test.day5_testNG_dropdown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

//1. Open Chrome browser
//        2. Go to http://the-internet.herokuapp.com/add_remove_elements/
//        3. Click to “Add Element” button
//        4. Verify “Delete” button is displayed after clicking.
//        5. Click “Delete” button.
//        6. Verify “Delete” button is NOT displayed after clicking.
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
public class T0_staleElementException {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        button.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
        if (deleteButton.isDisplayed()){
            System.out.println("TEST PASS: Delete Button is displayed");
        } else {
            System.out.println("TEST FAIL: Delete Button is NOT displayed");
        }

        deleteButton.click();

        try{
            deleteButton.isDisplayed();
        } catch (StaleElementReferenceException e){
            System.out.println("Exception is handled");
            System.out.println("Element is not displayed anymore");
        }

        driver.quit();
    }
}
