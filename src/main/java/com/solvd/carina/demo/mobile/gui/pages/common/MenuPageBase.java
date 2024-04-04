package com.solvd.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HeaderPageBase extends AbstractPage implements IMobileUtils {
    public HeaderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickOnCartIcon();
    public abstract void clickOnMenuIcon();
    public abstract CatalogPageBase clickOnAllItems();
    public abstract DrawingPageBase clickOnDrawingBtn();
    public abstract LoginPageBase clickOnLogoutBtn();
    public abstract HeaderPageBase getHeader();
}
