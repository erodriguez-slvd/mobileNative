package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase implements IMobileUtils {
    @ExtendedFindBy(iosPredicate = "label == \"CANCEL\" AND name == \"test-CANCEL\"")
    private ExtendedWebElement finishBtn;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Total')]")
    private ExtendedWebElement totalPrice;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnFinishBtn() {
        finishBtn.click();
    }

    @Override
    public boolean isTotalPricePresent() {
        swipe(totalPrice, 1);
        return totalPrice.isElementPresent();
    }
}
