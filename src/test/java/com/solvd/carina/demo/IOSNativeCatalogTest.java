package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSNativeCatalogTest implements IAbstractTest {
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
        catalogPage.sortProductsByAscendingPrice();
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByAscendingPrice());
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-150")
    public void testAreProductsSortedByDescendingName() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProductsByDescendingName();
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByDescendingName());
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-151")
    public void testAddProductToCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.addProductToCart();
        pause(3L);
        Assert.assertTrue(catalogPage.cartContainsProduct());
    }

    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-152")
    public void testRemoveProductFromCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.removeProductFromCart();
        Assert.assertTrue(catalogPage.isCartEmpty());
    }
}
