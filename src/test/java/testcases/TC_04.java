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

public class TC_04 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_02(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickLoginOrSignUp();

		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.populateLogin(data.get(Constants.LOGIN_EMAIL), data.get(Constants.LOGIN_PASSWORD));

		homePage.validateUserLogin();
		homePage.clickLogoutAccount();

		Assert.assertTrue(loginOrSignUpPage.isPageLoaded(), "User did not navigated to login page");

	}

}
