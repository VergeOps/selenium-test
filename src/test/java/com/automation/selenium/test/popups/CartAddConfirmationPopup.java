package com.automation.selenium.test.popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.selenium.core.BasePage;
import com.automation.selenium.test.pages.cart.CartPage;

public class CartAddConfirmationPopup extends BasePage {
	
	@FindBy(css="span[title='Continue shopping']")
	private WebElement btnContinueShopping;
	
	@FindBy(css="a[title='Proceed to checkout']")
	private WebElement btnProceedToCheckout;


	public CartAddConfirmationPopup(WebDriver driver) {
		super(driver);
	}
	
	public void continueShopping() {
		click(btnContinueShopping);
		
		waitForInvisible(btnContinueShopping);
	}
	
	public CartPage proceedToCheckout() {
		click(btnProceedToCheckout);
		
		return new CartPage(getDriver());
	}

}
