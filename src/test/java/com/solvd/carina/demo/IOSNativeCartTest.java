package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSNativeCartTest implements IAbstractTest {
    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Cart Test")
    @TestCaseKey("ALPHA-154")
    public void testContinueShoppingBtn() {
        MenuPageBase headerPage = initPage(getDriver(), MenuPageBase.class);
        CartPageBase cartPage = headerPage.clickOnCartIcon();
        cartPage.continueShopping();
    }

    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Cart Test")
    @TestCaseKey("ALPHA-155")
    public void testCreateAnOrder() {
        CartPageBase cartPage = initPage(getDriver(), CartPageBase.class);
        cartPage.createAnOrder(R.TESTDATA.get("firstName"), R.TESTDATA.get("lastName"), R.TESTDATA.get("zipCode"));
        Assert.assertTrue(cartPage.isOrderCreated());
    }
}
