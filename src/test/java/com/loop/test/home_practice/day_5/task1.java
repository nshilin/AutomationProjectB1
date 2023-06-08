package com.loop.test.home_practice.day_5;

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

/*
1. go to http://the-internet.herokuapp.com/dropdown
2. validate "Please select an option" is selected by default
3. Choose option 1 and validate that it is selected
4. Choose option 2 and validate that it is selected
5. Validate dropdown name is "Dropdown List"
*/
public class task1 {
    WebDriver driver;
    String expected = "Please select an option";
    String actual;

    //1. go to http://the-internet.herokuapp.com/dropdown
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    //2. validate "Please select an option" is selected by default
@Test
    public void herokuappDropdown (){
        Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@id,'dropdown')]")));
        actual = dropdown.getFirstSelectedOption().getText();
    Assert.assertEquals(actual, expected, "does not match");

    //3. Choose option 1 and validate that it is selected
    dropdown.selectByValue("1");
    Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 1");

    //4. Choose option 2 and validate that it is selected
    dropdown.selectByVisibleText("Option 2");
    Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");

    //5. Validate dropdown name is "Dropdown List"
    ////select[contains(@id,'dropdown')]/preceding::h3[contains(text(),'Dropdown List')]
    ////*[contains(text(),'Dropdown List')]
    WebElement dropdownNamePart = driver.findElement(By.xpath("//select[contains(@id,'dropdown')]/preceding-sibling::h3[contains(text(),'Dropdown List')]"));
    Assert.assertEquals(dropdownNamePart.getText(),"Dropdown List");

}
}
