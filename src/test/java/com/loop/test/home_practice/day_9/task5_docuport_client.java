package com.loop.test.home_practice.day_9;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task5_docuport_client {
    @Test
    public void client_upload() throws InterruptedException {
        //1. login docuport as a a client
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        DocuportUtils.loginDocuport(Driver.getDriver(), "client");

        //2. go to my loads
        WebElement myUploads = Driver.getDriver().findElement(By.xpath("(//a[@href='/my-uploads'])[2]"));
        myUploads.click();

        //3. Click on Upload Documents Button
        WebElement uploadDocsButton = Driver.getDriver().findElement(By.xpath("(//button[@type='button']//following-sibling::button)[2]"));
        uploadDocsButton.click();

        //4. Choose a file and click on upload file button
        WebElement uploadFile = Driver.getDriver().findElement(By.xpath("//*[contains(@class,'docu-upload')]//button"));
        String path = "/Users/natalie/Desktop/Upload the document.docx";
        uploadFile.sendKeys(path);
        Thread.sleep(5000);

        //5.Choose Service
        WebElement chooseService = Driver.getDriver().findElement(By.xpath("//div[contains(@role,'combobox')]"));
        chooseService.click();

        WebElement bookkeeping = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Bookkeeping')]"));
        bookkeeping.click();

        WebElement docType = Driver.getDriver().findElement(By.xpath("//span[contains(@class,'ma-1 v-chip')]"));
        docType.click();

        WebElement quarter = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Q1')]"));
        quarter.click();

        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//button[contains(@type,'submit')]"));
        uploadButton.click();

        String actualSuccessMdg = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Document(s) have been uploaded successfully')]")).getText();
        String expectedsuccessMdg = "Document(s) have been uploaded successfully";
        Assert.assertEquals(actualSuccessMdg,expectedsuccessMdg);
        Driver.closeDriver();
    }
}
