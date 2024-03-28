package com.solvd.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CatalogPageBase extends AbstractPage {
    public CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();
    public abstract boolean areProductTitlesVisible();
    public abstract void sortProductsByAscendingPrice();
    public abstract boolean areProductSortByAscendingPrice();
    public abstract void sortProductsByDescendingName();
    public abstract boolean areProductSortByDescendingName();

}
