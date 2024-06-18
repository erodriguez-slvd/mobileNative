package com.solvd.carina.demo.mobile.gui.components.common;

import com.solvd.carina.demo.mobile.gui.enums.SortType;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductSortingBase extends AbstractUIObject {
    public ProductSortingBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void sortBy(SortType sortType);
}
