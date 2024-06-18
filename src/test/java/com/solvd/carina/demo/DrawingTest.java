package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CommonPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.DrawingPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrawingTest extends BaseTest implements IAbstractTest {
    @Test(suiteName = "Drawing Test")
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
