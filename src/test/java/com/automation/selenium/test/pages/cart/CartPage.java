package com.automation.selenium.test.pages.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.selenium.core.BasePage;

public class CartPage extends BasePage {
	
	private static final String PRODUCT_ID = "PRODUCT_ID";
	private static final String REMOVE_IDENTIFIER = 
			"a.cart_quantity_delete[href*='id_product=" + PRODUCT_ID + "&']";
	
	@FindBy(id="summary_products_quantity")
	WebElement txtNumProducts;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public CartPage removeItemFromCart(int productID) {
		
		int prodsInCart = Integer.parseInt(getText(txtNumProducts).replaceAll("[^0-9]", ""));
		
		click(getRemoveElementFromProductID(productID));
		
		String s = "s";
		if (prodsInCart < 3) {
			s = "";
		}
		
		waitForText(txtNumProducts, (prodsInCart - 1) + " Product" + s);
		
		return new CartPage(getDriver());
	}
	
	public boolean isItemInCart(int productID) {
		
		sleep(1);
		changeWait(5);
		
		try {
			getRemoveElementFromProductID(productID);
		} catch (NoSuchElementException e) {
			return false;
		}
		
		resetWait();
		
		return true;
	}
	
	private WebElement getRemoveElementFromProductID(int productID) {
		return getDriver().findElement(By.cssSelector(REMOVE_IDENTIFIER.replaceAll(PRODUCT_ID, productID + "")));
	}
}
