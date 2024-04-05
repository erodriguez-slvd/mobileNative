package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.*;
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
    @Test(dependsOnMethods = "testLogin", suiteName = "Login Test")
    public void testLogout(){
        MenuPageBase headerPage = initPage(getDriver(), MenuPageBase.class);
        headerPage.clickOnMenuIcon();
        LoginPageBase loginPage = headerPage.clickOnLogoutBtn();
        Assert.assertTrue(loginPage.isLoginBtnActive());
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
        Assert.assertTrue(catalogPage.isCartEmpty());
    }
    @Test(dependsOnMethods = "testLogin", suiteName = "Product Test")
    public void testGetProductDescription(){
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductDetailPageBase productPage = catalogPage.clickOnAProduct();
        productPage.getProductDescription();
    }
    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"}, suiteName = "Cart Test")
    public void testContinueShoppingBtn(){
        MenuPageBase headerPage = initPage(getDriver(), MenuPageBase.class);
        CartPageBase cartPage = headerPage.clickOnCartIcon();
        cartPage.continueShopping();
    }
    @Test(dependsOnMethods = "testLogin", suiteName = "Drawing Test")
    public void drawingAndComparePicturesTest() {
        MenuPageBase menuPage = initPage(getDriver(), MenuPageBase.class);
        menuPage.getHeaderMenu().isMenuBtnPresent();
        menuPage.getHeaderMenu().clickOnMenuBtn();
        DrawingPageBase drawingArea = menuPage.clickOnDrawingBtn();
        Assert.assertTrue(drawingArea.isEmptyPadPresent());
        drawingArea.drawPicture();
        Assert.assertTrue(drawingArea.isDrawingPresent());
        drawingArea.clickOnClearBtn();
        Assert.assertTrue(drawingArea.isEmptyPadPresent());
    }
}
