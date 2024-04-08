package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.Setting;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {
    public DrawingPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CLEAR\"]")
    private ExtendedWebElement clearBtn;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-DRAWING-SCREEN\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View")
    private ExtendedWebElement signaturePad;
    @ExtendedFindBy(image = "images/template_drawing.png")
    private ExtendedWebElement templateDrawingImage;
    @ExtendedFindBy(image = "imgages/drawingLine.png")
    private ExtendedWebElement newDrawingImage;

    @Override
    public void drawPicture() {
        Point position = signaturePad.getLocation();
        Dimension size = signaturePad.getSize();
        int startX = position.x + size.width / 10;
        int startY = position.y + size.height / 10;
        int endX = startX * 5;
        tap(startX, startY);
        int pixelCount = 0;

        for (int i = 0; i < 5; i++) {
            swipe(startX, startY + pixelCount, endX, startY + pixelCount, 200);
            pixelCount += 10;
        }
    }
    @Override
    public void clickOnClearBtn() {
        clearBtn.click();
    }
    @Override
    public boolean isEmptyPadPresent() {
        setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.7);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return templateDrawingImage.isElementPresent();
    }
    @Override
    public boolean isDrawingPresent() {
        setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.5);
        return newDrawingImage.isElementPresent();
    }
}
