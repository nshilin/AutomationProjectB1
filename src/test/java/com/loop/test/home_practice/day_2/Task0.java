package com.loop.test.home_practice.day_2;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*1. go to http://the-internet.herokuapp.com/forgot_password
2. locate 5 elements, forgot password, email, email input, retrieve password, powered selenium
3. use css
4. verify those elements are displayed*/
public class Task0 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/forgot_password");

        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class = 'example']>h2"));
        if(forgotPassword.isDisplayed()){
            System.out.println("Forget password heading is displayed");
        } else {
            System.out.println("Forget password heading is not displayed");
        }

        WebElement email = driver.findElement(By.cssSelector("label[for ='email']"));
        if(email.isDisplayed()){
            System.out.println("Email heading is displayed");
        } else {
            System.out.println("Email heading is not displayed");
        }

        WebElement emailInput = driver.findElement(By.cssSelector("input[type ='text']"));
        if(emailInput.isDisplayed()){
            System.out.println("Email input is displayed");
        } else {
            System.out.println("Email input is not displayed");
        }

        WebElement retrievePassword = driver.findElement(By.cssSelector("button[id='form_submit']"));

        if(retrievePassword.isDisplayed()){
            System.out.println("Retrieve password button is displayed");
        } else {
            System.out.println("Retrieve password button is not displayed");
        }

        WebElement poweredSelenium = driver.findElement(By.cssSelector("div[style='text-align: center;']>a"));
        if(poweredSelenium.isDisplayed()){
            System.out.println("Powered by Essential Selenium is displayed");
        } else {
            System.out.println("Powered by Essential Selenium is not displayed");
        }

        driver.quit();
    }
}
