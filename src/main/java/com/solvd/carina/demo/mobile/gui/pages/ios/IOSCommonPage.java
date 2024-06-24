package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.components.common.TopMainMenuComponent;
import com.solvd.carina.demo.mobile.gui.components.ios.IOSTopMainMenuComponent;
import com.solvd.carina.demo.mobile.gui.pages.common.CommonPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CommonPageBase.class)
public class IOSCommonPage extends CommonPageBase {
    @ExtendedFindBy(iosPredicate = "name == \"headerContainer\"")
    private IOSTopMainMenuComponent header;

    public IOSCommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TopMainMenuComponent getHeader() {
        return header;
    }

}
