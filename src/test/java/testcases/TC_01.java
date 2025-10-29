package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;
import pageObjects.HomePage;
import pageObjects.LoginOrSignUpPage;
import pageObjects.UserSignUpPage;
import utilities.DataProviders;

public class TC_01 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_01(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickLoginOrSignUp();

		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.populateSignUp(data.get(Constants.NAME), data.get(Constants.EMAIL));

		UserSignUpPage userSignUpPage = new UserSignUpPage(driver);
		userSignUpPage.chooseTitle(data.get(Constants.TITLE));
		userSignUpPage.choosePassword(data.get(Constants.PASSWORD));
		userSignUpPage.selectDOB(data.get(Constants.DAY), data.get(Constants.MONTH), data.get(Constants.YEAR));
		userSignUpPage.scrollElementIntoView();
		userSignUpPage.selectSignupNewsletter();
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
		userSignUpPage.scrollElementIntoView();
		userSignUpPage.clickCreateAccount();

		Assert.assertTrue(userSignUpPage.validateAccountCreated(), "Account is not created");
		userSignUpPage.clickContinue();

		Assert.assertTrue(homePage.validateUserLogin(), "User did not logged in");
		homePage.clickDeleteAccount();

		Assert.assertTrue(userSignUpPage.validateAccountDeleted(), "Account is not deleted");
		userSignUpPage.clickContinue();

	}

}
