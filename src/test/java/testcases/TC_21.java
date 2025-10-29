package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;
import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import pageObjects.LoginOrSignUpPage;
import pageObjects.ProductDetailsPage;
import pageObjects.ShoppingCartPage;
import utilities.DataProviders;

public class TC_21 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_18(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickProducts();

		AllProductsPage allProductsPage = new AllProductsPage(driver);
		Assert.assertTrue(allProductsPage.isPageLoaded(), "All Products page not loaded");

		allProductsPage.scrollElementIntoView();
		allProductsPage.viewFirstProduct();

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsPage.validateWriteYourReviewVisibility(), "Write Your Review is not Visible");
		productDetailsPage.populateReviewOnProductDetails(data.get(Constants.REVIEWER_NAME),
				data.get(Constants.REVIEWER_EMAIL), data.get(Constants.REVIEW_COMMENT));

		Assert.assertTrue(productDetailsPage.validateThankYouMessageAfterReview(),
				"Thank you message is not displayed");

	}

}
