package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrawingTest implements IAbstractTest {
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

    @Test(dependsOnMethods = "testLogin", suiteName = "Drawing Test")
    @TestCaseKey("ALPHA-157")
    public void drawingAndComparePicturesTest() {
        CommonPageBase commonPage = initPage(getDriver(), CommonPageBase.class);
        commonPage.getHeader().isMenuBtnPresent();
        MenuPageBase menuPage = commonPage.getHeader().clickOnMenuBtn();
        DrawingPageBase drawingArea = menuPage.clickOnDrawingBtn();
        Assert.assertTrue(drawingArea.isEmptyPadPresent(), "DrawingPad is not empty");
        drawingArea.drawPicture();
        Assert.assertTrue(drawingArea.isDrawingPresent(), "There is no drawing image");
        drawingArea.clickOnClearBtn();
        Assert.assertTrue(drawingArea.isEmptyPadPresent(), "DrawingPad is not empty");
    }
}
