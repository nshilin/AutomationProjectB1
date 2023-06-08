package com.loop.test.day3_css_xpath_isDisplayed;

/*go to docuport
 * identify */

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_css {

    public static void main(String[] args) {
        //go to url
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        ((WebDriver) driver).manage().window().maximize();
        driver.get("https://beta.docuport.app");

        //identify log in with css locator
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));
        String docuport = logo.getAttribute("alt");

        if (DocuportConstants.LOGO_DOCUPORT.equalsIgnoreCase(docuport)) {
            System.out.println("Expected logo text: " + DocuportConstants.LOGO_DOCUPORT + ", matches actual logo text: " + docuport);
        } else {
            System.out.println("Expected logo text: " + DocuportConstants.LOGO_DOCUPORT + ", DOES NOT match actual logo text: " + docuport);
        }

        WebElement userName = driver.findElement(By.cssSelector("input[id='input-14']"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        userName.sendKeys(DocuportConstants.PASSWORD);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

//        Thread.sleep(3000);

        WebElement homeIcon = driver.findElement(By.cssSelector("[class='v-icon notranslate mdi mdi-home theme--light']"));
        System.out.println(homeIcon.isDisplayed());

        if (homeIcon.isDisplayed()) {
            System.out.println("Login was successful");
        } else {
            System.out.println("Login failed");
        }

        driver.quit();
    }
}
