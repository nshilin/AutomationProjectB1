package com.loop.test.home_practice.day_9;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class task3 {
    /*
    1. Go to https://loopcamp.vercel.app/upload.html
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
	-File uploaded text is displayed on the page
     */
    @Test
    public void upload_task() {
        Driver.getDriver().get(ConfigurationReader.getProperty("upload.practice"));
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        String path = "/Users/natalie/Desktop/Upload the document.docx";
        chooseFile.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();


    }
}
