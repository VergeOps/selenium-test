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
public class AccountPage extends BasePage {
	
	@FindBy(css="a[href*='logout']")
	private WebElement btnLogout;

	@FindBy(id="flash")
	private WebElement txtLoggedInMessage;
	
	/**
	* Constructs an instance of the page object
	* @param driver Active WebDriver
	*/
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage logout() {
		click(btnLogout);
		
		return new LoginPage(getDriver());
	}
	
	public String getLoginSuccessMessage() {
		return getText(txtLoggedInMessage);
	}

}
