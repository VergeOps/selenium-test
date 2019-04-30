package com.automation.selenium.test.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.selenium.core.BasePage;
import com.automation.selenium.test.pages.cart.CartPage;
import com.automation.selenium.test.popups.CartAddConfirmationPopup;

public class ProductPage extends BasePage {
	
	private static final String PRODUCT_ID = "PRODUCT_ID";
	private static final String PRODUCT_IMG_IDENTIFIER = "a.product_img_link[href*='id_product=" + PRODUCT_ID + "&'] img";
	private static final String PRODUCT_ADD_TO_CART_IDENTIFIER = 
			"a.ajax_add_to_cart_button[data-id-product='" + PRODUCT_ID + "']";
	
	
	private CartAddConfirmationPopup popup;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	private void addItemToCart(int productID) {
		hover(getElementByID(PRODUCT_IMG_IDENTIFIER, productID));
		click(getElementByID(PRODUCT_ADD_TO_CART_IDENTIFIER, productID));
		
	}
	
	public CartPage addItemToCartAndProceedToCheckout(int productID) {
		addItemToCart(productID);
		
		popup = new CartAddConfirmationPopup(getDriver());
		popup.proceedToCheckout();
		
		return new CartPage(getDriver());
	}
	
	public ProductPage addItemToCartAndContinueShopping(int productID) {
		addItemToCart(productID);
		
		popup = new CartAddConfirmationPopup(getDriver());
		popup.continueShopping();
		
		return this;
	}
	
	private WebElement getElementByID(String baseIdentifier, int id) {
		return getDriver().findElement(
				By.cssSelector(baseIdentifier.replaceAll(PRODUCT_ID, id + "")));
	}
}
