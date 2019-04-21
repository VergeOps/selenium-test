package com.automation.selenium.test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.selenium.core.BasePage;

public class ExerciseThreePage extends BasePage {

	@FindBy(xpath="//a[contains(text(),'Casual Dresses')])[1]")
	private WebElement lnkCasualDressesOne;

	@FindBy(css="li:first-child h5:first-of-type a.subcategory-name")
	private WebElement casualDressesSubCategory;
	
	@FindBy(id="layered_id_attribute_group_1")
	private WebElement chkSizeSmall;
	
	@FindBy(id="layered_id_attribute_group_2")
	private WebElement chkSizeMediim;
	
	@FindBy(id="layered_id_attribute_group_3")
	private WebElement chkSizeLarge;
	
	@FindBy(css="a[title='Delivery']")
	private WebElement lnkDelivery;
	
	@FindBy(xpath="//a[contains(., 'All specials')]")
	private WebElement allSpecialsButton;
	
	@FindBy(css="a.ajax_add_to_cart_button")
	private List<WebElement> listBtnAddToCart;
	
	@FindBy(className="icon-home")
	private WebElement lnkHome;
	
	@FindBy(css="button.bt_compare[type='submit']")
	private List<WebElement> listCompares;
	
	public ExerciseThreePage(WebDriver driver) {
		super(driver);
	}

}
