package com.loop.test.home_practice.day_5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
/*go to https://app.docuport.app/company-formation/resident
What type of business do you want to start? - choose corporation
Validate that corporation has been selected
Formation State - choose Virginia
Validate Virginia is selected
Validate order summer as below:

State registration fee $100
Payment processing $6
Service fee $150
Total $256

Formation State - choose Maryland
Validate Maryland is selected
Validate order summer as below:

State registration fee $170
Payment processing $10.20
Service fee $150
Total $330.20*/
public class extra_task {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
    driver = WebDriverFactory.getDriver("Chrome");
    driver.manage().window().maximize();
    driver.get("https://app.docuport.app/company-formation/resident");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void docuportPractice(){
        //What type of business do you want to start? - choose corporation
        WebElement typeOfBusiness = driver.findElement(By.xpath("//div[contains]"));
    }
}
