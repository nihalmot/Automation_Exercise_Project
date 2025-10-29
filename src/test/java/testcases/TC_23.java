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
import pageObjects.ShoppingCartPage;
import pageObjects.UserSignUpPage;
import utilities.DataProviders;

public class TC_23 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_18(Map<String, String> data) {

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
		
		Assert.assertTrue(homePage.validateUserLogin(), "User i not logged in");
		homePage.scrollElementIntoView();
		homePage.addRecommendedItemsToCart();
		homePage.clickRecommendedItemsRightArrow();
		homePage.addRecommendedItemsToCart();
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		homePage.populateCart();
		
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		Assert.assertEquals(shoppingCartPage.getAddedProductCount(), 6, "All the products are not added into the cart");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shoppingCartPage.clickProceedToCheckout();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkoutPage.validateAddressDetails(), "Address is displayed correctly");
		
		homePage.clickDeleteAccount();
		Assert.assertTrue(homePage.validateAccountDeleted(), "Account is not deleted");
		homePage.clickContinueButton();
	}

}
