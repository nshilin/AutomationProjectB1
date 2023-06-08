package com.loop.test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    /*
    Creating the private constructor so this class' object is not reachable from outside
     */

    private Driver(){
    }

    /*
    Making driver instance private
    Static - run before everything else and also use in a static method
     */

    private static WebDriver driver;

    /*
    reusable method that will return the same driver instance every time when called
     */

    /**
     * singleton pattern
     * @return driver
     * @author nsh
     */
    public static WebDriver getDriver(){
        if(driver==null){
            String browserType = ConfigurationReader.getProperty("browser");
            switch(browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    /**
     * closing driver
     * @author natalie
     */
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
