package com.solvd.carina.demo.mobile.gui.components.common;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class TopMainMenuComponent extends AbstractUIObject {
    public TopMainMenuComponent(WebDriver driver) {
        super(driver);
    }

    public TopMainMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CartPageBase clickOnCartBtn();

    public abstract MenuPageBase clickOnMenuBtn();

    public abstract boolean isMenuBtnPresent();
}
