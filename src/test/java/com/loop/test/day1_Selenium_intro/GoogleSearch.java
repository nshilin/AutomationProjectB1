package com.loop.test.day1_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {

        /**
        *Navigate to Google search
         * get title of the page
         * get url of the page
         * validate the title, expected title is "Google"
         * validate the url of the page, exected url is "https://www.google.com"
         * close the browser*/

        //setup the driver
        WebDriverManager.chromedriver().setup();

        //create driver object
        WebDriver driver = new ChromeDriver();

        //navigate to URL
        driver.get("https://www.google.com");

        //maximize the window
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String expectedUrl = "https://www.google.com";

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title: " + actualTitle + ", matched expected title: " + expectedTitle + ", =. TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitle + ", DOES NOT match expected title: " + expectedTitle + ", =. TEST FAIL");
        }

        String actualUrl = driver.getCurrentUrl();
//        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.contains(expectedUrl)) {
            System.out.println("Actual title: " + actualUrl + ", matched expected title: " + expectedUrl + ", =. TEST PASS");
        } else {
            System.err.println("Actual title: " + actualUrl + ", DOES NOT match expected title: " + expectedUrl + ", =. TEST FAIL");
        }



        //quit the browser
        //driver.quit();

    }
}
