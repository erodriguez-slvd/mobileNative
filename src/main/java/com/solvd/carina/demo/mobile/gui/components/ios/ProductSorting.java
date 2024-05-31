package com.solvd.carina.demo.mobile.gui.components.ios;

import com.solvd.carina.demo.mobile.gui.components.common.ProductSortingBase;
import com.solvd.carina.demo.mobile.gui.enums.SortType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductSorting extends ProductSortingBase {
    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement sortingDropdownBtn;

    public ProductSorting(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void sortBy(SortType sortType) {
        sortingDropdownBtn.format(sortType.getSortType()).click();
    }
}