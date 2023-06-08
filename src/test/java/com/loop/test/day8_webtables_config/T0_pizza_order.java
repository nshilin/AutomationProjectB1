package com.loop.test.day8_webtables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.PizzaOrderWebTableUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T0_pizza_order extends TestBase {
  /*
    1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
     */

    /*
    validate that the card number for Alexandra Gray is 321456789012
     */

    @Test
    public void validate_card_for_alexandra() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Alexandra Gray";
        String expectedCardNumber = "321456789012";
        String actualCardNumber = driver.findElement(By.xpath("//td[contains(text(),'321456789012')]")).getText();
        assertEquals(actualCardNumber, expectedCardNumber);
    }

    public void test_pizza_type() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Alexandra Gray";
        String expectedPizzaType = "Thin Crust";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Pizza type"), expectedPizzaType);
    }

    @Test
    public void test_amount() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "John Doe";
        String expectedAccount = "3";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Amount"), expectedAccount);
    }

    @Test
    public void test_date() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Steward Dawidson";
        String expectedDate = "03/29/2021";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Date"), expectedDate);
    }

    @Test
    public void test_street() {

    }

    @Test
    public void test_city() {

    }

    @Test
    public void test_state() {

    }

    @Test
    public void test_zip() {

    }

    @Test
    public void test_card() {

    }

    @Test
    public void test_card_number() {

    }

    @Test
    public void test_exp() {

    }

}

