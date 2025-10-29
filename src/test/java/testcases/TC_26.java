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

public class TC_26 extends BaseTest {

	@Test
	public void testTC_26() {

		HomePage homePage = new HomePage(driver);
		homePage.scrollElementIntoView();

		Assert.assertTrue(homePage.verifySubscriptionText(), "Subscription text is not visible");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

		Assert.assertTrue(homePage.isPageLoaded(), "Automation Exercise Text is fully visible");

	}

}
