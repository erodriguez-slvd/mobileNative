package com.solvd.carina.demo.mobile.gui.components.ios;

import com.solvd.carina.demo.mobile.gui.components.common.FilterComponentBase;
import com.solvd.carina.demo.mobile.gui.enums.SortType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class IOSFilterComponent extends FilterComponentBase {
    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement sortingDropdownBtn;

    public IOSFilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void sortBy(SortType sortType) {
        sortingDropdownBtn.format(sortType.getSortType()).click();
    }
}
