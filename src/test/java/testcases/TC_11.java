package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;
import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import utilities.DataProviders;

public class TC_11 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_06(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.populateCart();
		homePage.scrollElementIntoView();
		
		Assert.assertTrue(homePage.verifySubscriptionText(), "Subscription text is not displayed");
		homePage.populateEmailSubscription(data.get(Constants.SUBSCRIPTION_EMAIL));
		Assert.assertEquals(homePage.validateSubscriptionMessage(), "You have been successfully subscribed!", "Email not subscribed");
		
	}

}
