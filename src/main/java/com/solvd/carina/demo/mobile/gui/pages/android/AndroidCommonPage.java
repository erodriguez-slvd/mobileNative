package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.components.android.HeaderMenu;
import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CommonPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommonPageBase.class)
public class AndroidCommonPage extends CommonPageBase {
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/parent::android.view.ViewGroup")
    private HeaderMenu header;

    public AndroidCommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderMenuBase getHeader() {
        return header;
    }
}
