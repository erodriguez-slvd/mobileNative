package com.solvd.carina.demo.mobile.gui.pages.common;

import com.solvd.carina.demo.mobile.gui.enums.SortType;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CatalogPageBase extends AbstractPage {
    public CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();

    public abstract boolean areProductTitlesVisible();

    public abstract void sortProduct(SortType sortType);

    public abstract void openSortingFilter();

    public abstract boolean areProductSortByAscendingPrice();

    public abstract boolean areProductSortByDescendingName();

    public abstract void addProductToCart();

    public abstract void removeProductFromCart();

    public abstract boolean cartContainsProduct();

    public abstract boolean isCartEmpty();

    public abstract ProductDetailPageBase clickOnAProduct();
}
