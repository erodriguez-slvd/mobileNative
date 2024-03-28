package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage {

	public LoginPageBase(WebDriver driver) {
		super(driver);
	}
	public abstract void typeName(String name);
	public abstract void typePassword(String password);
	public abstract CatalogPageBase clickLoginBtn();
	public abstract boolean isLoginBtnActive();

}
