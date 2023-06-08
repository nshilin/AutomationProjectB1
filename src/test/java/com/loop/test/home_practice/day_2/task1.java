package com.loop.test.home_practice.day_2;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout
*/
public class task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        WebElement loginInput = driver.findElement(By.cssSelector("input[id='input-14']"));
        loginInput.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[id='input-15']"));
        passwordInput.sendKeys(DocuportConstants.PASSWORD);

        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        Thread.sleep(2000);
        WebElement BGAvatar = driver.findElement(By.cssSelector("div[class='v-avatar primary']>span"));

        String BGNum = driver.findElement(By.cssSelector("span[class='subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3']")).getText();
        System.out.println("You logged in " + BGNum + " account");

        if(BGAvatar.isDisplayed()) {
            System.out.println("Login was successful");
        } else {
            System.out.println("Login failed");
        }

        WebElement BatchGroupSection = driver.findElement(By.cssSelector("div[class='d-flex align-center']"));
        BatchGroupSection.click();

        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
        logout.click();

        Thread.sleep(2000);
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        if(logo.isDisplayed()){
            System.out.println("Logout was successful");
        } else {
            System.out.println("Logout Failed");
        }

        driver.quit();
    }
}
