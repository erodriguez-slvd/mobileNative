package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "**/XCUIElementTypeTextField[`name == \"test-Username\"`]")
	@ClassChain
	private ExtendedWebElement nameInputField;
	@FindBy(xpath = "**/XCUIElementTypeSecureTextField[`name == \"test-Password\"`]")
	@ClassChain
	private ExtendedWebElement passwordInputField;
	@FindBy(xpath = "label == \"LOGIN\" AND name == \"test-LOGIN\"")
	@Predicate
	private ExtendedWebElement loginBtn;

	@Override
	public void typeName(String name) {
		nameInputField.type(name);
	}
	@Override
	public void typePassword(String password) {
		passwordInputField.type(password);
	}
	@Override
	public CatalogPageBase clickLoginBtn() {
		loginBtn.click();
		return initPage(getDriver(), CatalogPageBase.class);
	}
	@Override
	public boolean isLoginBtnActive() {
		return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
	}

}
