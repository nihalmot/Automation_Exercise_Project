package testcases;

import java.util.Map;

import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import utilities.DataProviders;

public class TC_06 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_06(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickContactUs();

		ContactUsPage contactUsPage = new ContactUsPage(driver);
		contactUsPage.enterName(data.get(Constants.NAME));
		contactUsPage.enterEmail(data.get(Constants.EMAIL));
		contactUsPage.enterSubject(data.get(Constants.SUBJECT));
		contactUsPage.enterMessage(data.get(Constants.MESSAGE));
		contactUsPage.uploadFile();
		contactUsPage.clickOnSubmit();
		contactUsPage.clickOk();
		contactUsPage.validateSuccessMessage();
		contactUsPage.clickHomeButton();

	}

}
