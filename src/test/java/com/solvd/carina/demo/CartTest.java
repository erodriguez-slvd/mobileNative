package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest implements IAbstractTest {
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

    @Test(dependsOnMethods = "testLogin", suiteName = "Cart Test")
    @TestCaseKey("ALPHA-151")
    public void testAddProductToCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.addProductToCart();
        pause(3L);
        Assert.assertTrue(catalogPage.cartContainsProduct(), "The product has not been added to the cart.");
    }

    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Cart Test")
    @TestCaseKey("ALPHA-152")
    public void testRemoveProductFromCart() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.removeProductFromCart();
        Assert.assertTrue(catalogPage.isCartEmpty(), "The product has not been deleted from the cart.");
    }

    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Cart Test")
    @TestCaseKey("ALPHA-154")
    public void testContinueShoppingBtn() {
        CommonPageBase commonPage = initPage(getDriver(), CommonPageBase.class);
        CartPageBase cartPage = commonPage.getHeader().clickOnCartBtn();
        CatalogPageBase catalogPage = cartPage.clickOnContinueShoppingBtn();
        Assert.assertTrue(catalogPage.isTitlePresent(), "Continue Shopping Button is not working.");
    }

    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Cart Test")
    @TestCaseKey("ALPHA-155")
    public void testCheckoutBtn() {
        CommonPageBase commonPage = initPage(getDriver(), CommonPageBase.class);
        CartPageBase cartPage = commonPage.getHeader().clickOnCartBtn();
        CheckoutInformationPageBase checkoutInformation = cartPage.clickOnCheckoutBtn();
        checkoutInformation.completePersonalInformation(R.TESTDATA.get("firstName"), R.TESTDATA.get("lastName"), R.TESTDATA.get("zipCode"));
        CheckoutOverviewPageBase checkoutOverview = checkoutInformation.clickOnContinueBtn();
        Assert.assertTrue(checkoutOverview.isTotalPricePresent(), "The total price of order is not present.");
    }
}
