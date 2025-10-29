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

public class TC_05 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_05(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickLoginOrSignUp();

		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.populateSignUp(data.get(Constants.NAME), data.get(Constants.EMAIL));

		Assert.assertTrue(loginOrSignUpPage.validateEmailAlreadyExistMsg(),
				"Email address already exist message not displayed");

	}

}
