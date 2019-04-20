package com.automation.selenium.test.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.selenium.core.BaseTest;
import com.automation.selenium.core.utility.PropertyConstants;

/**
 * Base Test class for the Selenium sample test project
 * @author Amanda Adams
 *
 */
public class ProjectBaseTest extends BaseTest {
	
	Logger logger = LogManager.getLogger();
	
	/**
	 * Method to initialize the WebDriver used by Selenium.  It will run before every test method.
	 * @param method The test method
	 * @param testData The test data
	 */
	@BeforeMethod(alwaysRun = true)
	protected void beginTest(Method method, Object[] testData) {
		
		initializeTest(method, testData);
		
		String environment = System.getProperty(PropertyConstants.ENVIRONMENT_PROPERTY);
		if (environment == null || environment.isEmpty()) {
			environment = "automationpractice.com";
		}
		  
		getDriver().navigate().to("http://" + environment + "/");
		
	}
	
	/**
	 * Method to terminate the test.  It runs after every test method.
	 * 
	 * @param result the result of the test
	 */
	@AfterMethod(alwaysRun = true)
	protected void endTest(ITestResult result) {
  	    killWebDriver(result);
	}
}
