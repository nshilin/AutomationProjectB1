package com.loop.test.home_practice.day_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://beta.docuport.app/login");

        driver.manage().window().maximize();

        WebElement usernameInput = driver.findElement(By.id("input-14"));

        String username = "b1g2_supervisor@gmail.com";
        usernameInput.sendKeys(username + Keys.ENTER);

        WebElement passwordInput = driver.findElement(By.id("input-15"));

        String password = "Group2";
        passwordInput.sendKeys(password + Keys.ENTER);
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.className("v-btn__content"));

        loginButton.click();

        driver.quit();

    }
}
