package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.enums.SortType;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest implements IAbstractTest {
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

    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-148")
    public void testGetAllProductsName() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        Assert.assertTrue(catalogPage.areProductTitlesVisible());
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-149")
    public void testAreProductsSortedByAscendingPrice() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProduct(SortType.PRICE_LOW_TO_HIGH);
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByAscendingPrice());
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-150")
    public void testAreProductsSortedByDescendingName() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProduct(SortType.PRICE_LOW_TO_HIGH);
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByDescendingName());
    }

}
