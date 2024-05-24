package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.DrawingPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSNativeTest implements IAbstractTest, IMobileUtils {

    @Test(dependsOnMethods = "testLogin", suiteName = "Product Test")
    @TestCaseKey("ALPHA-153")
    public void testGetProductDescription() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductDetailPageBase productPage = catalogPage.clickOnAProduct();
        productPage.getProductDescription();
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Drawing Test")
    @TestCaseKey("ALPHA-157")
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
