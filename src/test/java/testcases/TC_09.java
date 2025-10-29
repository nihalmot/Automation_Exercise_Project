package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;
import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import utilities.DataProviders;

public class TC_09 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_06(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickProducts();
		
		AllProductsPage allProductsPage = new AllProductsPage(driver);
		allProductsPage.populateSearchProduct(data.get(Constants.SEARCH_PRODUCT));
		Assert.assertTrue(allProductsPage.validateSearchedProducts(), "Searched products list did not displayed");
		
		
	}

}
