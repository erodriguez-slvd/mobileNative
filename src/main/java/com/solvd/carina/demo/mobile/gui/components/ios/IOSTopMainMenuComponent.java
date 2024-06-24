package com.solvd.carina.demo.mobile.gui.components.ios;

import com.solvd.carina.demo.mobile.gui.components.common.TopMainMenuComponent;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class IOSTopMainMenuComponent extends TopMainMenuComponent implements ICustomTypePageFactory {
    @ExtendedFindBy(iosPredicate = "name == 'test-Menu'")
    private ExtendedWebElement menuBtn;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartBtn;

    public IOSTopMainMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

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
