package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest implements IAbstractTest {
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

    @Test(dependsOnMethods = "testLogin", suiteName = "Product Test")
    @TestCaseKey("ALPHA-153")
    public void testGetProductDescription() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductDetailPageBase productPage = catalogPage.clickOnAProduct();
        productPage.getProductDescription();
    }
}