package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.HeaderPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HeaderPageBase.class)
public class HeaderPage extends HeaderPageBase {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "**/XCUIElementTypeOther[`name == \"test-Cart\"`]")
    @ClassChain
    private ExtendedWebElement cartIcon;
    @FindBy(xpath = "**/XCUIElementTypeOther[`name == \"test-Menu\"`]")
    @ClassChain
    private ExtendedWebElement menuIcon;
    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"ALL ITEMS\"`]")
    @ClassChain
    private ExtendedWebElement allItemsBtn;
    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"DRAWING\"`]")
    @ClassChain
    private ExtendedWebElement drawingBtn;
    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"LOGOUT\"`]")
    @ClassChain
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
    public void clickOnDrawing() {
        drawingBtn.click();
    }
    @Override
    public LoginPageBase clickOnLogout() {
        logoutBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
}
