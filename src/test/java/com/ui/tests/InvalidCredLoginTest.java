package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final String INVALID_EMAIL_ADDRESS = "amollatthe@gmail.com";
	private static final String INVALID_PASSWORD_ADDRESS = "Qasfe1234";

	@Test(description = "Verify if the proper error message is shown for the user when user enters invalid credentials", groups = {
			"e2e", "sanity", "smoke" })
	public void loginTest() {
		assertEquals(homePage.goToLoginPage()
				.doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD_ADDRESS).getErrorMessage(),
				"Authentication failed.");
	}

}
