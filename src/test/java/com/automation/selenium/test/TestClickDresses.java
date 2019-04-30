package com.automation.selenium.test;

import org.testng.annotations.Test;

import com.automation.selenium.test.base.ProjectBaseTest;
import com.automation.selenium.test.pages.HomePage;


/**
 * Sample test class
 * @author Amanda Adams
 *
 */
public class TestClickDresses extends ProjectBaseTest {

	/**
	 * Sample initial test
	 * 
	 */
	@Test
	public void testSampleDressesLinkClick() {
	  
		HomePage page = new HomePage(getDriver());
		page.clickDresses();
		
	}
	
}
