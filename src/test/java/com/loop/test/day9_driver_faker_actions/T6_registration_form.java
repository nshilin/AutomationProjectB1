package com.loop.test.day9_driver_faker_actions;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class T6_registration_form {
    /*
    1. go to url: https://loopcamp.vercel.app/registration_form.html
    2. fill the form
    3. use faker
   */

    @Test
    public void registration_form_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
        WebElement registrationForm = Driver.getDriver().findElement(By.xpath("//a[.='Registration Form']"));
        registrationForm.click();

        Faker faker = new Faker();

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().firstName());

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.bothify("???###"));

        WebElement emailAddress = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailAddress.sendKeys(faker.internet().emailAddress());

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("571-###-####"));

        WebElement otherCheck = Driver.getDriver().findElement(By.xpath("//input[@value='other']"));
        otherCheck.click();

        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        dateOfBirth.sendKeys(dateFormat.format(faker.date().birthday()));

        Select dropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        dropdown.selectByValue("DE");

        Select dropdown2 = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        dropdown2.selectByVisibleText("Designer");

        WebElement programmingLanguage = Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        programmingLanguage.click();

        WebElement signUp = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUp.click();


        Driver.closeDriver();
    }
}
