package com.loop.test.day1_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {
        //setup the driver
        WebDriverManager.chromedriver().setup();

        //create driver object
        WebDriver driver = new ChromeDriver();

        //navigate to URL
        driver.get("https://demoqa.com/automation-practice-form/");

        //maximize the window
        driver.manage().window().maximize();

        /**
         * locate by attribute id
         * firstname
         */

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Natalie");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Shilin");

        WebElement gender = driver.findElement(By.name("gender"));
        gender.click();
    }
}
