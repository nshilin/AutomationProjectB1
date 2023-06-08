package com.loop.test.home_practice.day_3;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1. go to docuport
2. sign as adviser
3. store left navigate items to (Home, Received docs, My uploads, Invitations etc) to the List
4. iterate and print out href values

optional step:
5. Validate that expected matching to actual
Home, Received docs, My uploads, Clients, Invitations, Users, Leads, Bookkeeping, 1099 form, Reconciliation
*/
public class Task2 {
    public static void main(String[] args) {
        //1. go to docuport
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/login?redirect=%2F");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2. sign as advisor
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='input-14']"));
        loginInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='input-15']"));
        passwordInput.sendKeys(DocuportConstants.PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        loginButton.click();

        //3.store left navigate items to (Home, Received docs, My uploads, Invitations etc) to the List
        List<WebElement> leftPanelValues = driver.findElements(By.xpath("//div[@role='listbox']/a"));

        //4. iterate and print out href values
        for (WebElement eachLink : leftPanelValues) {
            if (!eachLink.getText().equals("")) {
                System.out.println("href value of " + eachLink.getText() + ": " + eachLink.getAttribute("href"));
            }
        }

//        5. optional step: Validate that expected matching to actual

        List<String> expected = new ArrayList<>(Arrays.asList("Home", "Received docs", "My uploads", "Clients", "Invitations", "Users", "Leads", "Bookkeeping", "1099 Form", "Reconciliations"));

        for (String expectedValue: expected) {
            boolean valueMatch = false;
            for (WebElement actualValue : leftPanelValues) {
                if (actualValue.getText().equalsIgnoreCase(expectedValue)) {
                    valueMatch = true;
                    System.out.println("TEST PASS: value EXPECTED:  =>  " + expectedValue + " matches the value ACTUAL:  => " + actualValue.getText());
                }
            }
            if (!valueMatch) {
                System.err.println("TEST FAIL: Expected " + expectedValue + " value DOES NOT match with the actual");
            }
        }
        driver.quit();
    }
}














