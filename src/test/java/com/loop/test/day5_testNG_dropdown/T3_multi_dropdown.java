package com.loop.test.day5_testNG_dropdown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/*
   1. Open Chrome browser
   2. Go to https://demoqa.com/select-menu
   3. Select all the options from multiple select dropdown.
   4. Print out all selected values.
   5. Deselect all values.
    */
public class T3_multi_dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void multiSelect() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']")));

//        Assert.assertTrue(dropdown.isMultiple());
//        dropdown.selectByIndex(0);
//        dropdown.selectByValue("saab");
//        dropdown.selectByVisibleText("Opel");
//        dropdown.selectByIndex(3);

        List<WebElement> options = new ArrayList<>();
        options = dropdown.getOptions();

        options.forEach(option -> {
            option.click();
            System.out.println("option = " + option.getText());
        });

        System.out.println("=======================");

        for (WebElement option : options) {
            option.click();
            System.out.println("option = " + option.getText());
        }

        //disselect all values
        dropdown.deselectAll();

        System.out.println("selected option = " + dropdown.getFirstSelectedOption().getText());

    }
}
