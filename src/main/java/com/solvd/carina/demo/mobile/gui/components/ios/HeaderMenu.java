package com.solvd.carina.demo.mobile.gui.components.ios;

import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.ios.CartPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class HeaderMenu extends HeaderMenuBase{
    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @ExtendedFindBy(iosPredicate = "name == 'test-Menu'")
    private ExtendedWebElement menuBtn;
    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    private ExtendedWebElement cartBtn;




    @Override
    public CartPageBase clickOnCartBtn() {
        cartBtn.click();
        return ;
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
