package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public CartPage(WebDriver driver) {
        super(driver);
    }


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-First Name\"`]")
    private ExtendedWebElement firstName;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-Last Name\"`]")
    private ExtendedWebElement lastName;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-Zip/Postal Code\"`]")
    private ExtendedWebElement zipCode;
    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"CONTINUE SHOPPING\"`]")
    @ClassChain
    private ExtendedWebElement continueShippingBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"CONTINUE\"`][2]")
    private ExtendedWebElement continueBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"CHECKOUT\"`][1]")
    private ExtendedWebElement checkoutBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Payment Information:\"`]")
    private ExtendedWebElement paymentInfo;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"FINISH\"`][1]")
    private ExtendedWebElement finishBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"CHECKOUT: COMPLETE!\"`]")
    private ExtendedWebElement successfulOrder;

    @Override
    public CatalogPageBase continueShopping() {
        continueShippingBtn.click();
        return initPage(getDriver(),CatalogPageBase.class);
    }
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

}
