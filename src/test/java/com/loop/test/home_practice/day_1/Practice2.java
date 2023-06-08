package com.loop.test.home_practice.day_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class Practice2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com");

        driver.manage().window().maximize();

        WebElement searchBar = driver.findElement(By.name("search_query"));

        String textToFind = "Wooden Spoon";
        searchBar.sendKeys(textToFind + Keys.ENTER);

        String expected = "Wooden spoon | Etsy";

        String actual = driver.getTitle();

        if (expected.equals(actual)) {
            System.out.println("Expected: " + actual);
        } else {
            System.out.println("Expected: " + expected + "\nActual: " + actual);
        }
        driver.quit();
    }
}
