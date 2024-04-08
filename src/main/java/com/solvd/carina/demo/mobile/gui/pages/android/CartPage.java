package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    private ExtendedWebElement firstName;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    private ExtendedWebElement lastName;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    private ExtendedWebElement zipCode;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]")
    private ExtendedWebElement continueShopping;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    private ExtendedWebElement continueBtn;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    private ExtendedWebElement checkoutBtn;
    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[2]")
    private ExtendedWebElement paymentInfo;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    private ExtendedWebElement finishBtn;
    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
    private ExtendedWebElement successfulOrder;

    @Override
    public void createAnOrder(String name, String lastname, String zip) {
        checkoutBtn.click();
        completeOrderInformation(name, lastname, zip);
        continueBtn.click();
        LOGGER.info(paymentInfo.getText());
        swipe(finishBtn,1);
        finishBtn.click();
    }
    @Override
    public void completeOrderInformation(String name, String lastname, String zip) {
        firstName.type(name);
        lastName.type(lastname);
        zipCode.type(zip);
    }
    @Override
    public boolean isOrderCreated() {
        return successfulOrder.isElementPresent();
    }
    @Override
    public CatalogPageBase continueShopping() {
        continueShopping.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }
}
