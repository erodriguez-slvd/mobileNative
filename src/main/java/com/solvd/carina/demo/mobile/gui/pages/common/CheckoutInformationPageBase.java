package com.solvd.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutInformationPageBase extends AbstractPage {
    public CheckoutInformationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void completePersonalInformation(String name, String lastname, String zip);

    public abstract CheckoutOverviewPageBase clickOnContinueBtn();

    public abstract CatalogPageBase clickOnCancelBtn();
}
