package com.automation.selenium.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.selenium.core.assertions.HardAssert;
import com.automation.selenium.test.base.ProjectBaseTest;
import com.automation.selenium.test.pages.AccountPage;
import com.automation.selenium.test.pages.LoginPage;


/**
 * Sample test class
 * @author Amanda Adams
 *
 */
public class TestLogin extends ProjectBaseTest {

	/**
	 * Sample initial test
	 * 
	 */
	@Test(dataProvider="successfulLogin")
	public void testLoginSuccessfully(String username, String password) {
	  
		getDriver().get("https://the-internet.herokuapp.com/login");
		LoginPage page = new LoginPage(getDriver());
		String successMessage = page.loginSuccessfully(username, password)
				.getLoginSuccessMessage();
		
		HardAssert.assertContains(successMessage, "You logged into a secure area!", "Secure area message should display after successful login.");
		
		AccountPage accountPage = new AccountPage(getDriver());
		accountPage.logout();
	}
	
	@Test(dataProvider="failedLogin")
	public void testLoginFailure(String username, String password, String expectedError) {
		getDriver().get("https://the-internet.herokuapp.com/login");
		
		LoginPage page = new LoginPage(getDriver());
		String errorMessage = page.loginWithFailure(username, password)
				.getErrorText();
		
		HardAssert.assertContains(errorMessage, expectedError, "Error message should display after failed login.");
		
		
	}
	
	@DataProvider(name="successfulLogin", parallel=true)
	public Object[][] getSuccessfulLoginData() {
		
		Object[][] data = {
			{"tomsmith", "SuperSecretPassword!"}
		};
		return data;
		
	}
	
	@DataProvider(name="failedLogin", parallel=true)
	public Object[][] getFailedLoginData() {
		
		Object[][] data = {
				{"", "SuperSecretPassword!", "Your username is invalid!"},
				{"tomsmith", "", "Your password is invalid!"},
				{"", "", "Your username is invalid!"},
				{"xxxx", "SuperSecretPassword!", "Your username is invalid!"},
				{"tomsmith", "xxxx", "Your password is invalid!"},
			};
			return data;
	}
}
