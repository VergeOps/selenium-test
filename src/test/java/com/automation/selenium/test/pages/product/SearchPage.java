package com.automation.selenium.test.pages.product;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends ProductPage {
	
	@FindBy(xpath = "//a[@title='Add to cart']")
	private List<WebElement> listBtnAddToCart;

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean itemsDisplay() {
		
		return listBtnAddToCart.size() > 0;
	}

}
