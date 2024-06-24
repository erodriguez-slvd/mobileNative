package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailPageBase.class)
public class ProductDetailPage extends ProductDetailPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(accessibilityId = "test-Description")
    private ExtendedWebElement productDescription;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getProductDescription() {
        LOGGER.info(productDescription.getText());
    }
}
