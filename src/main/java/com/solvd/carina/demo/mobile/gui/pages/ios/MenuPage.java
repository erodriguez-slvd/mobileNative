package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HeaderPageBase.class)
public class HeaderPage extends HeaderPageBase implements IMobileUtils {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer']/parent::XCUIElementTypeOther")
    private HeaderPageBase header;

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
    public HeaderPageBase getHeader() {
        return header;
    }
}
