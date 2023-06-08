package com.loop.test.home_practice.day_8;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DocuportLLCRegistration extends TestBase {

    @Test
    public void free_registration() {

        driver.get("https://app.docuport.app/company-formation/resident");
        //Company Information Section
        //1.Choose the Formation state
        WebElement formationState = driver.findElement(By.xpath("(//input[contains(@type,'radio')])[5]//following-sibling::div"));
        formationState.click();

        //2.Choose the legal company name
        WebElement companyName = driver.findElement(By.xpath("(//input[contains(@id,'input-')])[7]"));
        companyName.sendKeys("Art's World");

        //3.Choose Industry
        WebElement industry = driver.findElement(By.xpath("(//input[contains(@id,'input-')])[10]"));
        industry.click();
        WebElement industryOption = driver.findElement(By.xpath("//div[contains(text(),'Arts and Crafts')]/.."));
        industryOption.click();

        //4.Enter First Name
        WebElement firstName = driver.findElement(By.xpath("//label[contains(text(),'First name *')]/following-sibling::input[1]"));
        firstName.sendKeys("Salvador");

        //5.Enter Last Name
        WebElement lastName = driver.findElement(By.xpath("//label[contains(text(),'Last name *')]/following-sibling::input[1]"));
        lastName.sendKeys("Dali");

        //6.Enter Email Address
        WebElement emailAddress = driver.findElement(By.xpath("//label[contains(text(),'Email address *')]/following-sibling::input"));
        emailAddress.sendKeys("sdali@gmail.com");

        //7.Enter Phone Number
        WebElement phoneNum = driver.findElement(By.xpath("//label[contains(text(),'Phone number *')]/following-sibling::input[1]"));
        phoneNum.sendKeys("9999999999");

        //8. Press Next Button
        WebElement nextButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        nextButton.click();
        System.out.println("Company Information Section is successfully filled out");

        //Registered Agent and Business Address page
        //9.Choose Company
        WebElement companyRadioButton = driver.findElement(By.xpath("(//input[contains(@role,'radio')])[8]//following-sibling::div"));
        companyRadioButton.click();

        //10.Enter Company Name
        WebElement lastName2 = driver.findElement(By.xpath("(//label[contains(text(),'Company')]/following-sibling::input)[2]"));
        lastName2.sendKeys("Art's World");

        //11.Enter Address
        WebElement Address = driver.findElement(By.xpath("//label[contains(text(),'Address line 1 *')]/following-sibling::input"));
        Address.sendKeys("123 Hibiscus line");

        //12.Enter City
        WebElement city = driver.findElement(By.xpath("//label[contains(text(),'City *')]/following-sibling::input"));
        city.sendKeys("Arlington");

        //13.Jurisdiction
        WebElement jurisdiction = driver.findElement(By.xpath("(//label[contains(text(),'Jurisdiction *')]/following-sibling::input)[1]"));
        jurisdiction.click();
        WebElement chooseOption = driver.findElement(By.xpath("//div[contains(text(),'Amelia')]/.."));
        chooseOption.click();

        //14.Enter Zip Code
        WebElement zipCode = driver.findElement(By.xpath("//label[contains(text(),'Zip code *')]/following-sibling::input"));
        zipCode.sendKeys("12345");

        //15.Enter Phone Number
        WebElement phoneNum2 = driver.findElement(By.xpath("(//label[contains(text(),'Phone number *')]/following-sibling::input)[2]"));
        phoneNum2.sendKeys("9999999999");

        //16. Press Next Button
        WebElement nextButton2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        nextButton2.click();
        System.out.println("Registered Agent and Business Address section is successfully filled out");

        //Management Structure page
        //17.Choose management structure
        WebElement radioButton = driver.findElement(By.xpath("(//input[contains(@role,'radio')]/following-sibling::div)[12]"));
        radioButton.click();

        //18.Enter first name
        WebElement firstName3 = driver.findElement(By.xpath("(//label[contains(text(),'First name *')]/following-sibling::input)[2]"));
        firstName3.sendKeys("Salvador");

        //19.Enter Last Name
        WebElement lastName3 = driver.findElement(By.xpath("(//label[contains(text(),'Last name *')]/following-sibling::input)[2]"));
        lastName3.sendKeys("Dali");

        //20.Share Ownership
        WebElement ownership = driver.findElement(By.xpath("//input[@type='number']"));
        ownership.sendKeys("1");

        //21.Enter SSN
        WebElement ssn = driver.findElement(By.xpath("//label[contains(text(),'SSN')]/following-sibling::input"));
        ssn.sendKeys("123456789");

        //22.Enter first name
        WebElement firstName4 = driver.findElement(By.xpath("(//label[contains(text(),'First name *')]/following-sibling::input)[3]"));
        firstName4.sendKeys("Salvador");

        //23.Enter Last Name
        WebElement lastName4 = driver.findElement(By.xpath("(//label[contains(text(),'Last name *')]/following-sibling::input)[3]"));
        lastName4.sendKeys("Dali");

        //24.Click Go to Payment
        WebElement goToPaymentButton = driver.findElement(By.xpath("//span[contains(., 'Go to payment')]/.."));
        goToPaymentButton.click();
        System.out.println("Management Structure section is successfully filled out");
    }
}
