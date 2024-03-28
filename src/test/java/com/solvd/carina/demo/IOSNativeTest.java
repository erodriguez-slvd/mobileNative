package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSNativeTest implements IAbstractTest, IMobileUtils {
    @Test(suiteName = "Login Test")
    public void testLogin(){
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typeName(R.TESTDATA.get("username"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        Assert.assertTrue(loginPage.isLoginBtnActive());
        CatalogPageBase catalog=loginPage.clickLoginBtn();
        Assert.assertTrue(catalog.isTitlePresent(), "Product Catalog Page is not opened");
    }
    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    public void testGetAllProductsName(){
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        Assert.assertTrue(catalogPage.areProductTitlesVisible());
    }
    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    public void testAreProductsSortedByAscendingPrice(){
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProductsByAscendingPrice();
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByAscendingPrice());
    }
    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    public void testAreProductsSortedByDescendingName(){
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProductsByDescendingName();
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByDescendingName());
    }
    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    public void testAddProductToCart(){
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.addProductToCart();
        pause(3L);
        Assert.assertTrue(catalogPage.CartContainsProduct());
    }
    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Catalog Test")
    public void testRemoveProductFromCart(){
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.removeProductFromCart();
        catalogPage.isCartEmpty();
    }
}
