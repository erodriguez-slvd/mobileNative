package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutInformationPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutInformationPageBase.class)
public class CheckoutInformationPage extends CheckoutInformationPageBase {
    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firstName;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastName;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement zipCode;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    private ExtendedWebElement continueBtn;

    @ExtendedFindBy(accessibilityId = "test-CANCEL")
    private ExtendedWebElement cancelBtn;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void completePersonalInformation(String name, String lastname, String zip) {
        firstName.type(name);
        lastName.type(lastname);
        zipCode.type(zip);
    }

    @Override
    public CheckoutOverviewPageBase clickOnContinueBtn() {
        continueBtn.click();
        return initPage(getDriver(), CheckoutOverviewPageBase.class);
    }

    @Override
    public CatalogPageBase clickOnCancelBtn() {
        cancelBtn.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }
}
