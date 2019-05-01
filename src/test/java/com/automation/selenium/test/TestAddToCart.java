package com.automation.selenium.test;

import org.testng.annotations.Test;

import com.automation.selenium.core.assertions.HardAssert;
import com.automation.selenium.test.base.ProjectBaseTest;
import com.automation.selenium.test.pages.HomePage;

public class TestAddToCart extends ProjectBaseTest {
	
	/**
	 * Sample add to cart test
	 * 
	 */
	@Test(testName = "Add to Cart", groups = {"cart", "checkout", "wip"})
	public void testAddToCart() {
	  
		HomePage page = new HomePage(getDriver());
		
		boolean itemInCart = page.clickDresses()
			.addItemToCartAndContinueShopping(3)
			.addItemToCartAndProceedToCheckout(4)
			.removeItemFromCart(3)
			.isItemInCart(3);
		
		HardAssert.assertFalse(itemInCart, "Product 3 should not be in the cart");

	}

}
