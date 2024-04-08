package com.solvd.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage implements IMobileUtils {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract CatalogPageBase continueShopping();
    public abstract void createAnOrder(String name, String lastname, String zip);
    public abstract void completeOrderInformation(String firstName, String lastName, String zipCode);
    public abstract boolean isOrderCreated();
}
