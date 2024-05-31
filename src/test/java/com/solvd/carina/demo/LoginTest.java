package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CommonPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {
    @Test(suiteName = "Login Test")
    @TestCaseKey("ALPHA-147")
    public void testLogin() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typeName(R.TESTDATA.get("username"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        Assert.assertTrue(loginPage.isLoginBtnActive());
        CatalogPageBase catalog = loginPage.clickLoginBtn();
        Assert.assertTrue(catalog.isTitlePresent(), "Product Catalog Page is not opened");
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Login Test")
    @TestCaseKey("ALPHA-156")
    public void testLogout() {
        CommonPageBase common = initPage(getDriver(), CommonPageBase.class);
        LoginPageBase loginPage = common.getHeader().clickOnMenuBtn().clickOnLogoutBtn();
        Assert.assertTrue(loginPage.isLoginBtnActive(), "LoginPage is not open.");
    }
}
