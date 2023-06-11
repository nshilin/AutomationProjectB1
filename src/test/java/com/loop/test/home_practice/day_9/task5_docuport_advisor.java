package com.loop.test.home_practice.day_9;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class task5_docuport_advisor {
    /*
    1. login docuport as a advisor
2. go to my loads
3. try to upload a file
     */
    @Test
    public void advisor_login() {
        //1. login docuport as a advisor
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        DocuportUtils.loginDocuport(Driver.getDriver(), "advisor");

        //2. go to my loads
        WebElement myUploads = Driver.getDriver().findElement(By.xpath("(//a[@href='/my-uploads'])[2]"));
        myUploads.click();

        WebElement uploadDocsButton = Driver.getDriver().findElement(By.xpath("(//button[@type='button']//following-sibling::button)[2]"));
        uploadDocsButton.click();

        String path = "/Users/natalie/Desktop/Upload the document.docx";
        WebElement uploadFile = Driver.getDriver().findElement(By.xpath("//*[contains(@class,'docu-upload')]//button"));
        uploadFile.sendKeys(path);

        
        WebElement client = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Client')]//following-sibling::input[1]"));
        client.click();

        WebElement test = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Test')]"));
        test.click();

        WebElement service = Driver.getDriver().findElement(By.xpath("(//div[contains(@class,'v-input__append')]//preceding-sibling::input)[2]"));
        service.click();

        WebElement bokkeeping = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Bookkeeping')]"));
        bokkeeping.click();

        WebElement docType = Driver.getDriver().findElement(By.xpath("//span[contains(@class,'ma-1 v-chip')]"));
        docType.click();

        WebElement quarter = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Q2')]"));
        quarter.click();

        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//button[contains(@type,'submit')]"));
        uploadButton.click();

        Driver.closeDriver();
    }
}

