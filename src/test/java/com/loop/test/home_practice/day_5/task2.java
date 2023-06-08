package com.loop.test.home_practice.day_5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*1. go to https://www.etsy.com/
2. search for rings
3. validate that Estimated Arrival shows any time
3. click Estimated Arrival dropdown
4. click Select custom date
5. choose may 30 from dropdown
6. validate Estimated Arrival shows may 30
*/
public class task2 {

WebDriver driver;

@BeforeMethod
    public void setupMethod(){
    //1. go to https://www.etsy.com/
    driver = WebDriverFactory.getDriver("Chrome");
    driver.manage().window().maximize();
    driver.navigate().to("https://www.etsy.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@AfterMethod
    public void tearDownMethod(){
    driver.close();
}
 @Test
    public void etsyTest(){
    //2. search for rings

     WebElement searchBar = driver.findElement(By.xpath("//input[contains(@id,'global-enhancements-search-query')]"));
     searchBar.sendKeys("rings", Keys.ENTER);

     //3. validate that Estimated Arrival shows any time
     WebElement estimatedArr = driver.findElement(By.xpath("//span[contains(text(), 'Estimated Arrival')]"));

//     WebElement estimatedArr = driver.findElement(By.xpath("//span[contains(text(), 'Estimated Arrival')]/text()[1]"));
////     Assert.assertEquals(estimatedArr.getText(), " Estimated Arrival ");
     estimatedArr.click();

     //4. click Select custom date
     Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@name,'delivery_days')]")));
     dropdown.selectByVisibleText("By May 30");

     //select[@aria-label='Select custom date']
     //select[contains(@name,'delivery_days')]

     //6. validate Estimated Arrival shows may 30
     WebElement dateOfArrival = driver.findElement(By.xpath("//span[contains(text(), 'By May 30')]"));
     Assert.assertEquals(dateOfArrival.getText(),"By May 30");

 }

}
