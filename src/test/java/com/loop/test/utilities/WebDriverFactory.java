package com.loop.test.utilities;

/*
 * create a static method getDriver
 * Accepts argument String - browserType
 * returns webdriver
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 *
 * @param
 * @return the browser
 * */

public class WebDriverFactory {
    public static WebDriver getDriver (String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else {
            System.out.println("No driver found");
            System.out.println("Driver is null");
            return null;
        }
    }
}
