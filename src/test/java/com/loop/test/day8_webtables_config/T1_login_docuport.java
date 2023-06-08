package com.loop.test.day8_webtables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import org.testng.annotations.Test;

public class T1_login_docuport extends TestBase {

    @Test
    public void test_login_logout(){

        DocuportUtils.loginDocuport(driver, "client");
        DocuportUtils.logOut(driver);

        DocuportUtils.loginDocuport(driver, DocuportConstants.ADVISOR);
        DocuportUtils.logOut(driver);

        DocuportUtils.loginDocuport(driver, DocuportConstants.EMPLOYEE);
        DocuportUtils.logOut(driver);

        DocuportUtils.loginDocuport(driver, DocuportConstants.SUPERVISOR);
        DocuportUtils.logOut(driver);

    }
}
