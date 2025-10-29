package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.HomePage;
import pageObjects.TestCases;
import utilities.DataProviders;

public class TC_07 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_06(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickTestCases();

		TestCases testCases = new TestCases(driver);
		Assert.assertTrue(testCases.isPageLoaded(), "User is unable to navigate to Test Cases Page");

	}

}
