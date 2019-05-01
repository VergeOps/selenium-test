package com.automation.selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.selenium.core.BasePage;

/**
 * Page object container for practice site womens page
 * 
 * @author Amanda Adams
 * 
 */
public class LoginPage extends BasePage {
	
	
	@FindBy(id="username")
	private WebElement inputUsername;
	
	@FindBy(id="password")
	private WebElement inputPassword;
	
	@FindBy(css="button[type='submit']")
	private WebElement btnSubmit;
	
	@FindBy(id="flash")
	private WebElement txtErrorMessage;

	/**
	* Constructs an instance of the page object
	* @param driver Active WebDriver
	*/
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private void login(String username, String password) {
		enterText(username, inputUsername);
		enterText(password, inputPassword);
		
		click(btnSubmit);
	}
	
	public LoginPage loginWithFailure(String username, String password) {
		login(username, password);
		return new LoginPage(getDriver());
	}
	
	public AccountPage loginSuccessfully(String username, String password) {
		login(username, password);
		return new AccountPage(getDriver());
	}
	
	public String getErrorText() {
		return getText(txtErrorMessage);
	}

}
