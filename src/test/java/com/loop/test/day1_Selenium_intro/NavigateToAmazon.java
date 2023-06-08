package com.loop.test.day1_Selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToAmazon {
    /*navigate to amazon
    navigate back
    navigate forward
    refresh*/
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
//        driver.close(); //it's not quitting the driver
        driver.quit(); //this quits the driver completely
    }
}
