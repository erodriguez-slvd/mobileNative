package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.DrawingPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class AndroidNativeTest implements IAbstractTest {

    @Test(dependsOnMethods = "testLogin", suiteName = "Product Test")
    public void testGetProductDescription() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductDetailPageBase productPage = catalogPage.clickOnAProduct();
        productPage.getProductDescription();
    }

    @Test(dependsOnMethods = "testLogin", suiteName = "Drawing Test")
    public void drawingAndComparePicturesTest() {
        MenuPageBase menuPage = initPage(getDriver(), MenuPageBase.class);
        menuPage.clickOnMenuIcon();
        DrawingPageBase drawingArea = menuPage.clickOnDrawingBtn();
        drawingArea.drawPicture();
        drawingArea.clickOnClearBtn();
    }
}
