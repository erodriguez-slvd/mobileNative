package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {
    @FindBy(xpath = "**/XCUIElementTypeOther[`name == \"test-Cart\"`]")
    @ClassChain
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "**/XCUIElementTypeOther[`name == \"test-Menu\"`]")
    @ClassChain
    private ExtendedWebElement menuIcon;

    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"ALL ITEMS\"`]")
    @ClassChain
    private ExtendedWebElement allItemsBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-DRAWING'")
    private ExtendedWebElement drawingBtn;

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGOUT'")
    private ExtendedWebElement logoutBtn;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

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
}
