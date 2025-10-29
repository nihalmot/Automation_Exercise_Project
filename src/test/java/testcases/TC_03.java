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

public class TC_03 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_03(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickLoginOrSignUp();

		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.populateLogin(data.get(Constants.LOGIN_EMAIL), data.get(Constants.LOGIN_PASSWORD));

		homePage.validateUserLogin();
		Assert.assertTrue(loginOrSignUpPage.validateInvalidCredentials(),
				"Invalid credentials error message not displayed");

	}

}
