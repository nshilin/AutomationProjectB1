package com.loop.test.home_practice.day_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        WebElement gmail = driver.findElement(By.className("gb_t"));

        gmail.click();

        String expected = "Gmail";
        String actual = driver.getTitle();

        if(expected.equalsIgnoreCase(actual)){
            System.out.println("Expected: " + actual);
        } else {
            System.out.println("Expected: " + expected + "\nActual: " + actual);
        }

        driver.navigate().back();

        String expectedGoogle = "Google";
        String actualGoogle = driver.getTitle();

        if(expectedGoogle.equalsIgnoreCase(actualGoogle)){
            System.out.println("Expected: " + actualGoogle);
        } else {
            System.out.println("Expected: " + expectedGoogle + "\nActual: " + actualGoogle);
        }

        driver.quit();
    }
}
