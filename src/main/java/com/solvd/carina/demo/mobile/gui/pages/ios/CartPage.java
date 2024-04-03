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
    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"CONTINUE SHOPPING\"`]")
    @ClassChain
    private ExtendedWebElement continueShippingBtn;

    @Override
    public CatalogPageBase continueShopping() {
        continueShippingBtn.click();
        return initPage(getDriver(),CatalogPageBase.class);
    }

}
