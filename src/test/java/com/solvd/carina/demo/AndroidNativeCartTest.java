package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidNativeCartTest implements IAbstractTest {
    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Cart Test")
    public void testContinueShoppingBtn() {
        MenuPageBase menuPage = initPage(getDriver(), MenuPageBase.class);
        CartPageBase cartPage = menuPage.clickOnCartIcon();
        CatalogPageBase catalogPage = cartPage.continueShopping();
    }

    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Cart Test")
    public void testCreateAnOrder() {
        CartPageBase cartPage = initPage(getDriver(), CartPageBase.class);
        cartPage.createAnOrder(R.TESTDATA.get("firstName"), R.TESTDATA.get("lastName"), R.TESTDATA.get("zipCode"));
        Assert.assertTrue(cartPage.isOrderCreated(), "The order is not correctly generated.");
    }
}
