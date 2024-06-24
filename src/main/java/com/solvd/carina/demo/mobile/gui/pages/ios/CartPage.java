package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutInformationPageBase;
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

    @ExtendedFindBy(accessibilityId = "test-Description")
    private ExtendedWebElement productDescription;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"CONTINUE SHOPPING\"`]")
    @ClassChain
    private ExtendedWebElement continueShoppingBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"CHECKOUT\"`][1]")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CatalogPageBase clickOnContinueShoppingBtn() {
        continueShoppingBtn.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }

    @Override
    public CheckoutInformationPageBase clickOnCheckoutBtn() {
        checkoutBtn.click();
        return initPage(getDriver(), CheckoutInformationPageBase.class);
    }

    @Override
    public boolean isProductDescriptionPresent() {
        return productDescription.isElementPresent();
    }

    @Override
    public boolean isProductPricePresent() {
        return productPrice.isElementPresent();
    }

}
