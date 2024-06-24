package com.solvd.carina.demo.mobile.gui.components.android;

import com.solvd.carina.demo.mobile.gui.components.common.FilterComponentBase;
import com.solvd.carina.demo.mobile.gui.enums.SortType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidFilterComponent extends FilterComponentBase {
    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortingDropdownBtn;

    public AndroidFilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void sortBy(SortType sortType) {
        sortingDropdownBtn.format(sortType.getSortType()).click();
    }
}
