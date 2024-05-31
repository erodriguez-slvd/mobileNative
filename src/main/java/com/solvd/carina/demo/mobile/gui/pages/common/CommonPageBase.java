package com.solvd.carina.demo.mobile.gui.pages.common;

import com.solvd.carina.demo.mobile.gui.components.common.HeaderMenuBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract  class CommonPageBase extends AbstractPage {
    public CommonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderMenuBase getHeader();
}
