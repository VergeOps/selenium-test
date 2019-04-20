package com.automation.selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.selenium.core.BasePage;

/**
 * Page object container for practice site home page
 * 
 * @author Amanda Adams
 * 
 */
public class HomePage extends BasePage {
  

	@FindBy (linkText="Women")
	private WebElement lnkWomen;
    
	/**
	* Constructs an instance of the page object
	* @param driver Active WebDriver
	*/
	public HomePage(WebDriver driver) {
		super(driver);
	}
  
  /**
   * Clicks the Women's page link on the HomePage
   * @return WomensPage
   */
  public WomensPage clickWomen() {
	  click(lnkWomen);
	  
	  getReporter().info("Clicked Women's Page");
	  
	  return new WomensPage(getDriver());
  }
 
  
}
