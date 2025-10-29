package testcases;

import java.util.Map;

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

public class TC_15 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_15(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickLoginOrSignUp();

		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.populateSignUp(data.get(Constants.NAME), data.get(Constants.EMAIL));

		UserSignUpPage userSignUpPage = new UserSignUpPage(driver);
		userSignUpPage.chooseTitle(data.get(Constants.TITLE));
		userSignUpPage.choosePassword(data.get(Constants.PASSWORD));
		userSignUpPage.selectDOB(data.get(Constants.DAY), data.get(Constants.MONTH), data.get(Constants.YEAR));
		userSignUpPage.selectSignupNewsletter();
		userSignUpPage.scrollElementIntoView();
		userSignUpPage.selectSignupOffers();
		userSignUpPage.enterFirstName(data.get(Constants.FIRSTNAME));
		userSignUpPage.enterLastName(data.get(Constants.LASTNAME));
		userSignUpPage.enterCompany(data.get(Constants.COMPANY));
		userSignUpPage.enterAddress1(data.get(Constants.ADDRESS1));
		userSignUpPage.enterAddress2(data.get(Constants.ADDRESS2));
		userSignUpPage.selectCountry(data.get(Constants.COUNTRY));
		userSignUpPage.enterState(data.get(Constants.STATE));
		userSignUpPage.enterCity(data.get(Constants.CITY));
		userSignUpPage.enterZipcode(data.get(Constants.ZIP));
		userSignUpPage.enterMobileNumber(data.get(Constants.MOBILE));
		userSignUpPage.clickCreateAccount();

		Assert.assertTrue(userSignUpPage.validateAccountCreated(), "Account is not created");
		userSignUpPage.clickContinue();

		Assert.assertTrue(homePage.validateUserLogin(), "User is not logged in");
		homePage.scrollElementIntoView();
		homePage.addFirstProductToCart();
		homePage.clickViewCart();

		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.clickProceedToCheckout();

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.validateAddressDetails();
		checkoutPage.reviewYourOrder();
		checkoutPage.typeCommentForOrder(data.get(Constants.CHECKOUT_ORDER_COMMENT));
		checkoutPage.scrollElementIntoView();
		checkoutPage.clickPlaceOrder();

		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.enterNameOnCard(data.get(Constants.NAME_ON_CARD));
		paymentPage.enterCardNumber(data.get(Constants.CARD_NUMBER));
		paymentPage.enterCVC(data.get(Constants.CVC));
		paymentPage.enterExpieryMonth(data.get(Constants.EXPIERY_MONTH));
		paymentPage.enterExpieryYear(data.get(Constants.EXPIERY_YEAR));
		paymentPage.scrollElementIntoView();
		paymentPage.payAndConfirmOrder();
		Assert.assertTrue(paymentPage.validateOrderConfirmation(), "Order is not placed");

		homePage.clickDeleteAccount();
		Assert.assertTrue(userSignUpPage.validateAccountDeleted(), "Account not deleted yet!");
		userSignUpPage.clickContinue();

	}

}
