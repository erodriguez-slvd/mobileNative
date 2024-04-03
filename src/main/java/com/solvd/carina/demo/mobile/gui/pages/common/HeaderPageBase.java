package com.solvd.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HeaderPageBase extends AbstractPage {
    public HeaderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickOnCartIcon();
    public abstract void clickOnMenuIcon();
    public abstract CatalogPageBase clickOnAllItems();
    public abstract void clickOnDrawing();
    public abstract LoginPageBase clickOnLogout();
}
