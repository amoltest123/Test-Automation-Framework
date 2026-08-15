package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_lOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
//		goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to performing the click to the Sign in Page");
		clickOn(SIGN_IN_lOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public void quit() {
		getDriver().quit();

	}
}
