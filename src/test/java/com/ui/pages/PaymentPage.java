package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static final By NO_PAYMENT_MODULE_TEXT_LOCATOR = By.xpath("//p[contains(@class, 'alert-warning')]");

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public String verifyNoPaymentModuleText() {
		return getVisibleText(NO_PAYMENT_MODULE_TEXT_LOCATOR);
	}

}
