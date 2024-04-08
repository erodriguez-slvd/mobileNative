package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.solvd.carina.demo.mobile.gui.components.ios.HeaderMenu;
import com.solvd.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {
    public MenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    private HeaderMenu header;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]")
    private ExtendedWebElement cartIcon;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]")
    private ExtendedWebElement menuIcon;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ALL ITEMS\"]")
    private ExtendedWebElement allItemsBtn;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-DRAWING\"]")
    private ExtendedWebElement drawingBtn;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]")
    private ExtendedWebElement logoutBtn;

    @Override
    public CartPageBase clickOnCartIcon() {
        cartIcon.click();
        return initPage(getDriver(), CartPageBase.class);
    }
    @Override
    public void clickOnMenuIcon() {
        menuIcon.click();
    }
    @Override
    public CatalogPageBase clickOnAllItems() {
        allItemsBtn.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }
    @Override
    public DrawingPageBase clickOnDrawingBtn() {
        drawingBtn.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }
    @Override
    public LoginPageBase clickOnLogoutBtn() {
        logoutBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
    @Override
    public HeaderMenuBase getHeaderMenu() {
        return header;
    }
}
