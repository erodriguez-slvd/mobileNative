package com.solvd.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewPageBase extends AbstractPage {
    public CheckoutOverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnFinishBtn();

    public abstract boolean isTotalPricePresent();
}
