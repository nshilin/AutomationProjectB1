package com.loop.test.day7_windows_webtables;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class T3_webtables extends TestBase {
    /*
1. login as an advisor
2. go to users
3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
4. validate that user name for alex.de.souza@gmail.com is alexdesouze
5. validate that phone number for alex.de.souza@gmail.com is +994512060042
6. validate that role for alex.de.souza@gmail.com is client
7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
 */
    @Test
    public void test_webtables_Alex() {
        DocuportUtils.loginDocuport(driver, DocuportConstants.ADVISOR);
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();

        //3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
        String actual = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.ALEX_DE_SOUZA_EMAIL, DocuportConstants.FULL_NAME);
        System.out.println("actual = " + actual);
        assertEquals(actual, DocuportConstants.ALEX_DE_SOUZA_FULL_NAME);

//4. validate that user name for alex.de.souza@gmail.com is alexdesouze
        String actualUsername = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.ALEX_DE_SOUZA_EMAIL, DocuportConstants.USERNAME);
        System.out.println("actual = " + actualUsername);
        assertEquals(actualUsername, DocuportConstants.ALEX_DE_SOUZA_USERNAME);

        //5. validate that phone number for alex.de.souza@gmail.com is +994512060042
        String actualPhoneNum = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.ALEX_DE_SOUZA_EMAIL, DocuportConstants.PHONE_NUMBER);
        System.out.println("actual = " + actualPhoneNum);
        assertEquals(actualPhoneNum, DocuportConstants.ALEX_DE_SOUZA_PHONE_NUM);

        //6. validate that role for alex.de.souza@gmail.com is client
        String actualRole = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.ALEX_DE_SOUZA_EMAIL, DocuportConstants.ROLE);
        System.out.println("actual = " + actualRole);
        assertEquals(actualRole, DocuportConstants.ALEX_DE_SOUZA_ROLE);

        //7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
        String actualAdvisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.ALEX_DE_SOUZA_EMAIL, DocuportConstants.ADVISOR);
        System.out.println("actual = " + actualAdvisor);
        assertEquals(actualAdvisor, DocuportConstants.ALEX_DE_SOUZA_ADVISOR);
    }

    @Test
    public void test_webtables_B1G1_Supervisor() {
        DocuportUtils.loginDocuport(driver, DocuportConstants.ADVISOR);
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();

        //3. validate that full name for b1g1_supervisor@gmail.com is Batch1 Group1
        String actualFullNameSupervisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_SUPERVISOR_EMAIL, DocuportConstants.FULL_NAME);
        System.out.println("actual = " + actualFullNameSupervisor);
        assertEquals(actualFullNameSupervisor, DocuportConstants.B1G1_FULL_NAME);

        //4. validate that username for b1g1_supervisor@gmail.com is b1g1_supervisor@gmail.com
        String actualUsernameSupervisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_SUPERVISOR_EMAIL, DocuportConstants.USERNAME);
        System.out.println("actual = " + actualUsernameSupervisor);
        assertEquals(actualUsernameSupervisor, DocuportConstants.B1G1_SUPERVISOR_USERNAME);

        //5. validate that phone number for b1g1_supervisor@gmail.com is 0000000000
        String actualPhoneNumSupervisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_SUPERVISOR_EMAIL, DocuportConstants.PHONE_NUMBER);
        System.out.println("actual = " + actualPhoneNumSupervisor);
        assertEquals(actualPhoneNumSupervisor, DocuportConstants.PHONE_NUM_10_0);

        //6. validate that role for b1g1_supervisor@gmail.com is Supervisor
        String actualRoleSupervisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_SUPERVISOR_EMAIL, DocuportConstants.ROLE);
        System.out.println("actual = " + actualRoleSupervisor);
        assertEquals(actualRoleSupervisor, DocuportConstants.B1G1_SUPERVISOR_ROLE);

        //7. validate that advisor for  b1g1_supervisor@gmail.com is null
        String actualAdvisorSupervisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_SUPERVISOR_EMAIL, DocuportConstants.ADVISOR);
        assertEquals(actualAdvisorSupervisor, DocuportConstants.NULL_VALUE);
    }

    @Test
    public void test_webtables_B1G1_Advisor() {
        DocuportUtils.loginDocuport(driver, DocuportConstants.ADVISOR);
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();

        //3. validate that full name for b1g1_advisor@gmail.com is Batch1 Group1
        String actualFullNameAdvisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_ADVISOR_EMAIL, DocuportConstants.FULL_NAME);
        System.out.println("actual = " + actualFullNameAdvisor);
        assertEquals(actualFullNameAdvisor, DocuportConstants.B1G1_FULL_NAME);

        //4. validate that username for b1g1_advisor@gmail.com is b1g1_supervisor@gmail.com
        String actualUsernameAdvisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_ADVISOR_EMAIL, DocuportConstants.USERNAME);
        System.out.println("actual = " + actualUsernameAdvisor);
        assertEquals(actualUsernameAdvisor, DocuportConstants.B1G1_ADVISOR_USERNAME);

        //5. validate that phone number for b1g1_advisor@gmail.com is 0000000000
        String actualPhoneNumAdvisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_ADVISOR_EMAIL, DocuportConstants.PHONE_NUMBER);
        System.out.println("actual = " + actualPhoneNumAdvisor);
        assertEquals(actualPhoneNumAdvisor, DocuportConstants.PHONE_NUM_10_0);

        //6. validate that role for b1g1_advisor@gmail.com is Advisor
        String actualRoleAdvisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_ADVISOR_EMAIL, DocuportConstants.ROLE);
        System.out.println("actual = " + actualRoleAdvisor);
        assertEquals(actualRoleAdvisor, DocuportConstants.B1G1_ADVISOR_ROLE);

        //7. validate that advisor for  b1g1_advisor@gmail.com is null
        String actualAdvisorAdvisor = DocuportWebTableUtils.returnAnyField(driver, DocuportConstants.B1G1_ADVISOR_EMAIL, DocuportConstants.ADVISOR);
        assertEquals(actualAdvisorAdvisor, DocuportConstants.NULL_VALUE);
    }
}
