package com.solvd.carina.demo.mobile.gui.components.ios;

import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class HeaderMenu extends HeaderMenuBase implements ICustomTypePageFactory {
    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Menu\"`]")
    private ExtendedWebElement menuBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Cart\"`]")
    private ExtendedWebElement cartBtn;

    @Override
    public CartPageBase clickOnCartBtn() {
        cartBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }
    @Override
    public MenuPageBase clickOnMenuBtn() {
        menuBtn.click();
        return initPage(getDriver(), MenuPageBase.class);
    }
    @Override
    public boolean isMenuBtnPresent() {
        return menuBtn.isElementPresent();
    }

}
