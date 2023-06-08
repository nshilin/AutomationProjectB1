package com.loop.test.day1_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        //setting up the webdriver
        WebDriverManager.chromedriver().setup();

        //create an instance of a driver
        WebDriver driver = new ChromeDriver();
        Thread.sleep(3000);

//        driver.get("https://etsy.app");

        //maximize
        driver.manage().window().maximize();
//        Thread.sleep(3000);
//        driver.manage().window().fullscreen();

        //navigate to
        driver.navigate().to("https://etsy.app");
//        Thread.sleep(3000);

        //slow things
        Thread.sleep(3000);

        //navigate back takes us to previous
        driver.navigate().back();

        //navigate forward
        driver.navigate().forward();

        //navigate refresh
        driver.navigate().refresh();


    }
}
