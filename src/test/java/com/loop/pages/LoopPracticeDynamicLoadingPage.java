package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
            1. go https://loopcamp.vercel.app/dynamic_loading/7.html
            2. Wait until title is “Dynamic title”
            3. Assert: Message “Done!” is displayed.
            4. Assert: Image is displayed.
     */
public class LoopPracticeDynamicLoadingPage {

    public LoopPracticeDynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "div[@id='alert']")
    public WebElement doneMessage;

    @FindBy(xpath="//img[@src='/img/a-few-moments.jpg']")
    public WebElement image;
}
