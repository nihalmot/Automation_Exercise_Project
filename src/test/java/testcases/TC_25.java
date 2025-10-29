package testcases;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginOrSignUpPage;
import pageObjects.PaymentPage;
import pageObjects.ShoppingCartPage;
import pageObjects.UserSignUpPage;
import utilities.DataProviders;

public class TC_25 extends BaseTest {

	@Test
	public void testTC_24() {

		HomePage homePage = new HomePage(driver);
		homePage.scrollElementIntoView();

		Assert.assertTrue(homePage.verifySubscriptionText(), "Subscription text is not visible");
		homePage.clickScrollUpButton();

		Assert.assertTrue(homePage.isPageLoaded(), "Automation Exercise Text is fully visible");

	}

}
