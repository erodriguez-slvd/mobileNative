package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutInformationPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutInformationPageBase.class)
public class CheckoutInformationPage extends CheckoutInformationPageBase {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-First Name\"`]")
    private ExtendedWebElement firstName;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-Last Name\"`]")
    private ExtendedWebElement lastName;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-Zip/Postal Code\"`]")
    private ExtendedWebElement zipCode;

    @ExtendedFindBy(iosPredicate = "label == \"CONTINUE\" AND name == \"test-CONTINUE\"")
    private ExtendedWebElement continueBtn;

    @ExtendedFindBy(iosPredicate = "label == \"CANCEL\" AND name == \"test-CANCEL\"")
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
