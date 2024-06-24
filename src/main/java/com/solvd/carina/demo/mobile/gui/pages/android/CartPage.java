package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutInformationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(accessibilityId = "test-Description")
    private ExtendedWebElement productDescription;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutBtn;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE SHOPPING")
    private ExtendedWebElement continueShoppingBtn;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
    private ExtendedWebElement successfulOrder;

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
