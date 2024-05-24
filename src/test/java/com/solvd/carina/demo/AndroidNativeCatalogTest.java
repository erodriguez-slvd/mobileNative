package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidNativeCatalogTest implements IAbstractTest {
    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    public void testGetAllProductsName() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        Assert.assertTrue(catalogPage.areProductTitlesVisible(), "Product titles are not visible.");
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    public void testAreProductsSortedByAscendingPrice() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProductsByAscendingPrice();
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByAscendingPrice(), "Filter By Ascending Price is not working.");
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    public void testAreProductsSortedByDescendingName() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProductsByDescendingName();
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByDescendingName(), "Filter By Descending Name is not working.");
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Catalog Test")
    public void testAddProductToCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.addProductToCart();
        pause(3L);
        Assert.assertTrue(catalogPage.cartContainsProduct(), "The product has not been added to the cart.");
    }

    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Catalog Test")
    public void testRemoveProductFromCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.removeProductFromCart();
        Assert.assertTrue(catalogPage.isCartEmpty(), "The product has not been deleted from the cart.");
    }
}
